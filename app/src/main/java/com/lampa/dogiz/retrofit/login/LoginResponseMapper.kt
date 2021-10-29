package com.lampa.dogiz.retrofit.login

import com.lampa.dogiz.model.login.LoginCheckCodeResponse
import com.lampa.dogiz.model.Step
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class LoginResponseMapper @Inject constructor() : EntityMapper<LoginResponseEntity, LoginCheckCodeResponse> {

    override fun mapFromEntity(entity: LoginResponseEntity): LoginCheckCodeResponse {
        return LoginCheckCodeResponse(
            step = if(entity.step == "SIGNUP") Step.SIGNUP else Step.HUB,
            auth = entity.auth,
            user = entity.user?.let { LoginUserMapper().mapFromEntity(it) }
        )
    }

    override fun mapToEntity(domainModel: LoginCheckCodeResponse): LoginResponseEntity {
        return LoginResponseEntity(
            step = domainModel.step.toString(),
            auth = domainModel.auth,
            user = domainModel.user?.let { LoginUserMapper().mapToEntity(it) }
        )
    }
}