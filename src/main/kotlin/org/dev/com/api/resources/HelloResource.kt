package org.dev.com.api.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloResource {
    @GetMapping
    fun hello(): String = "Hello Word"

    @GetMapping("/abc")
    fun hello3(): String = "Num sei"
}