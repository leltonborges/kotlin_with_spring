package org.dev.com.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class ApiForumAluraApplication

fun main(args: Array<String>) {
    runApplication<ApiForumAluraApplication>(*args)
}
