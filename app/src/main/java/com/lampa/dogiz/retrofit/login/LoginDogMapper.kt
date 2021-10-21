package com.lampa.dogiz.retrofit.login

import com.lampa.dogiz.model.login.LoginDog
import com.lampa.dogiz.retrofit.DogEntity
import com.lampa.dogiz.util.EntityListMapper
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class LoginDogMapper @Inject constructor() : EntityMapper<DogEntity, LoginDog>, EntityListMapper<DogEntity, LoginDog> {

    override fun mapFromEntity(entity: DogEntity): LoginDog {
        return LoginDog(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: LoginDog): DogEntity {
        return DogEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    override fun mapFromEntityList(entities: List<DogEntity>): List<LoginDog> {
        return entities.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainModel: List<LoginDog>): List<DogEntity> {
        return domainModel.map { mapToEntity(it) }
    }
}