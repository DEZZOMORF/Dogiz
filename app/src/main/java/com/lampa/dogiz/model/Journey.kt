package com.lampa.dogiz.model

import java.util.*

data class Journey(
    val title: String?,
    val desc: String?,
    val typeEvent: JourneyTypeEvent?,
    var date: Date?,
)

enum class JourneyTypeEvent {
    ACHIEVEMENT, MEMORIES, SPORT
}
