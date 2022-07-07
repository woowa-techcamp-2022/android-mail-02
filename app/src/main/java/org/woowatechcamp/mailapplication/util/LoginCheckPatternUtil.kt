package org.woowatechcamp.mailapplication.util

import android.util.Patterns
import java.util.regex.Pattern

object LoginCheckPatternUtil {
    fun isNotValidName(name: String): Boolean {
        val namePattern: Pattern = Pattern.compile("[ㄱ-ㅎ가-힣ㅏ-ㅣa-zA-Z0-9]{4,12}")
        return !namePattern.matcher(name).matches()
    }

    fun isNotValidEmail(email: String): Boolean = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
