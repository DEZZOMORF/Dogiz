package com.lampa.dogiz.retrofit

import com.lampa.dogiz.model.CheckCodeDog
import com.lampa.dogiz.model.Dog
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class CheckCodeDogMapper @Inject constructor() : EntityMapper<DogEntity, CheckCodeDog> {

    override fun mapFromEntity(entity: DogEntity): CheckCodeDog {
        return CheckCodeDog(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: CheckCodeDog): DogEntity {
        return DogEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<DogEntity>): List<CheckCodeDog> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<CheckCodeDog>): List<DogEntity> {
        return entities.map { mapToEntity(it) }
    }
}