package org.dev.com.api.mapper

interface Mapper<T, U> {
    fun map(source: T): U;
}
