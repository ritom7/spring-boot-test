package me.ritom.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.io.File


@RestController
class TestController {

    @GetMapping("/get")
    fun getMapping():String {
        return "This is a error"
    }
    @PostMapping("/post")
    fun postMapping(@RequestBody body:String):String {
        val file = File("someFile.txt")
        if (!file.exists()) file.createNewFile()
        val text = file.readText()
        file.writeText("$text \n $body")
        return "You said \"$body\""
    }
}