package com.lampa.dogiz.retrofit.hub.mapper

import com.lampa.dogiz.model.Dog
import com.lampa.dogiz.retrofit.DogEntity
import com.lampa.dogiz.util.EntityListMapper
import com.lampa.dogiz.util.EntityMapper
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class HubDogsMapper @Inject constructor() : EntityMapper<DogEntity, Dog>, EntityListMapper<DogEntity, Dog> {

    override fun mapFromEntity(entity: DogEntity): Dog {
        val birthday: Date? = entity.birthday?.let { SimpleDateFormat("yyyy-MM-dd").parse(it) }

        //val age: Float? =
        return Dog(
            id = entity.id,
            name = entity.name,
            gender = entity.gender,
            birthday = birthday,
            weight = entity.weight,
            spayed = entity.spayed,
            friendlyDogs = entity.friendlyDogs,
            friendlyHuman = entity.friendlyHuman,
            vaccinated = entity.vaccinated,
            desc = entity.desc,
            statusQuiz = entity.statusQuiz,
            position = entity.position,
            age = null
        )
    }

    override fun mapToEntity(domainModel: Dog): DogEntity {
        return DogEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    override fun mapFromEntityList(entities: List<DogEntity>): List<Dog> {
        return entities.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainModel: List<Dog>): List<DogEntity> {
        return domainModel.map { mapToEntity(it) }
    }
}
