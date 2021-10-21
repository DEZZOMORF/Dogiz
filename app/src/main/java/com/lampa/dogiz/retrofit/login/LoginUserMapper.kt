package com.lampa.dogiz.retrofit.login

import com.lampa.dogiz.model.User
import com.lampa.dogiz.retrofit.UserEntity
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class LoginUserMapper @Inject constructor() : EntityMapper<UserEntity, User> {

    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            email = entity.email,
            phone = entity.phone,
            firstName = entity.firstName,
            lastName = entity.lastName,
            role = entity.role,
            dogs = entity.dogs?.let { LoginDogMapper().mapFromEntityList(it) },
            address = entity.address,
            company = entity.company
        )
    }

    override fun mapToEntity(domainModel: User): UserEntity {
        return UserEntity(
            email = domainModel.email,
            phone = domainModel.phone,
            firstName = domainModel.firstName,
            lastName = domainModel.lastName,
            role = domainModel.role,
            dogs = domainModel.dogs?.let { LoginDogMapper().mapToEntityList(it) },
            address = domainModel.address,
            company = domainModel.company
        )
    }
}