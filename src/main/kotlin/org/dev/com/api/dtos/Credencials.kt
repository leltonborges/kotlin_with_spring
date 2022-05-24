package org.dev.com.api.dtos

import java.io.Serializable

data class Credencials(
    var username: String = "",
    var password: String = ""
): Serializable {

}
