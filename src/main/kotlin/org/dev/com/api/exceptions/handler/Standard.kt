package org.dev.com.api.exceptions.handler

class Standard(
    val msg: String?,
    val status: Int,
    val uri: String,
    val timestamp: Long = System.currentTimeMillis()
)