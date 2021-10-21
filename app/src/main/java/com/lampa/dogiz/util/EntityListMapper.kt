package com.lampa.dogiz.util

interface EntityListMapper<Entity, DomainModel> {

    fun mapFromEntityList(entity: List<Entity>): List<DomainModel>

    fun mapToEntityList(domainModel: List<DomainModel>): List<Entity>
}