package org.woowatechcamp.mailapplication.data.repository

import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.datasource.MailDatasource
import org.woowatechcamp.mailapplication.domain.MailRepository
import org.woowatechcamp.mailapplication.domain.entity.MailInfo
import javax.inject.Inject
import kotlin.random.Random

class MailRepositoryImpl @Inject constructor(
    private val mailDatasource: MailDatasource
) : MailRepository {
    private val colorList = listOf(
        R.color.green_200,
        R.color.red_100,
        R.color.red_200,
        R.color.orange_200,
        R.color.grey_300,
        R.color.teal_200,
        R.color.teal_700
    )

    private fun getRandomColor() = colorList[Random.nextInt(7)]

    override fun getMail() = mailDatasource.getMailData().map {
        if (it.name[0] in 'A'..'z')
            MailInfo(it.name, it.title, it.content, getRandomColor(), it.category)
        else
            MailInfo(it.name, it.title, it.content, category = it.category)
    }
}
