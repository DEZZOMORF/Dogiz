package com.lampa.dogiz.di

import android.content.Context
import android.provider.Settings.Secure
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lampa.dogiz.manager.SharedPreferencesManager
import com.lampa.dogiz.retrofit.ApiService
import com.lampa.dogiz.util.NetworkUrls
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .addInterceptor {
                return@addInterceptor it.proceed(
                    it.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer " + SharedPreferencesManager(context).userAccessToken)
                        .build()
                )
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkUrls.MAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit.Builder): ApiService {
        return retrofit
            .build()
            .create(ApiService::class.java)
    }
}