package com.lampa.dogiz.retrofit

import com.lampa.dogiz.model.User
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class UserMapper @Inject constructor() : EntityMapper<UserEntity, User> {

    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            email = entity.email,
            phone = entity.phone,
            firstName = entity.firstName,
            lastName = entity.lastName,
            role = entity.role,
            dogs = entity.dogs?.let { CheckCodeDogMapper().mapFromEntityList(it) },
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
            dogs = domainModel.dogs?.let { CheckCodeDogMapper().mapToEntityList(it) },
            address = domainModel.address,
            company = domainModel.company
        )
    }
}