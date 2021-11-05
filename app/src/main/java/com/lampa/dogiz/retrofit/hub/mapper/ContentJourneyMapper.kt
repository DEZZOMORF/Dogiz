package com.lampa.dogiz.retrofit.hub.mapper

import com.lampa.dogiz.model.Journey
import com.lampa.dogiz.model.JourneyTypeEvent
import com.lampa.dogiz.retrofit.hub.entity.content.ContentJourneyEntity
import com.lampa.dogiz.util.EntityListMapper
import com.lampa.dogiz.util.EntityMapper
import java.text.SimpleDateFormat
import javax.inject.Inject

class ContentJourneyMapper @Inject constructor() : EntityMapper<ContentJourneyEntity, Journey>, EntityListMapper<ContentJourneyEntity, Journey> {

    override fun mapFromEntity(entity: ContentJourneyEntity): Journey {
        return Journey(
            title = entity.title,
            desc = entity.desc,
            typeEvent = when (entity.typeEvent) {
                "ACHIVEMENT" -> JourneyTypeEvent.ACHIEVEMENT
                "MEMORIES" -> JourneyTypeEvent.MEMORIES
                "SPORT" -> JourneyTypeEvent.SPORT
                else -> JourneyTypeEvent.ACHIEVEMENT
            },
            date = entity.date?.let { SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(it) }
        )
    }

    override fun mapToEntity(domainModel: Journey): ContentJourneyEntity {
        return ContentJourneyEntity()
    }

    override fun mapFromEntityList(entity: List<ContentJourneyEntity>): List<Journey> {
        return entity.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainModel: List<Journey>): List<ContentJourneyEntity> {
        return domainModel.map { mapToEntity(it) }
    }
}
