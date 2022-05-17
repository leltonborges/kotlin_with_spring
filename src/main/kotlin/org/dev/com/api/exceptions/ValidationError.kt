package org.dev.com.api.exceptions

class ValidationError(
    val msg: String?,
    val status: Int,
    val uri: String,
    val timestamp: Long = System.currentTimeMillis(),
    var errors: List<FieldError> = ArrayList()
) {

    fun addErrorField(field: String, message: String?) {
        this.errors = this.errors.plus(FieldError(field, message))
    }
}