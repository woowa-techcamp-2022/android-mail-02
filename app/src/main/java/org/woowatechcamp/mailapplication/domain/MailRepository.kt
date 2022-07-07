package org.woowatechcamp.mailapplication.domain

import org.woowatechcamp.mailapplication.domain.entity.MailInfo

interface MailRepository {
    fun getMail(): List<MailInfo>
}
