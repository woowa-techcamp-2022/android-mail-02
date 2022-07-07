package org.woowatechcamp.mailapplication.data.datasource

import org.woowatechcamp.mailapplication.data.model.MailData

interface MailDatasource {
    fun getMailData() : List<MailData>
}
