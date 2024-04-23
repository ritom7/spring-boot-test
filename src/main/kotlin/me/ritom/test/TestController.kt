package me.ritom.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {

    @GetMapping("/get")
    fun getMapping():String {
        return "This is a error"
    }
}