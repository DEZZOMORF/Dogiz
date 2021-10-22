package com.lampa.dogiz.retrofit.login

import com.lampa.dogiz.model.UserAddress
import com.lampa.dogiz.retrofit.AddressEntity
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class LoginAddressMapper @Inject constructor() : EntityMapper<AddressEntity, UserAddress> {

    override fun mapFromEntity(entity: AddressEntity): UserAddress {
        return UserAddress(
            country = entity.country,
            city = entity.city
        )
    }

    override fun mapToEntity(domainModel: UserAddress): AddressEntity {
        return AddressEntity(
            country = domainModel.country,
            city = domainModel.city
        )
    }
}