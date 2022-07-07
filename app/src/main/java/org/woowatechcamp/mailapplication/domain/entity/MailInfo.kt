package org.woowatechcamp.mailapplication.domain.entity

data class MailInfo(
    val name : String,
    val title : String,
    val content : String,
    val profileColor : Int? = null,
    val category : Int
)
