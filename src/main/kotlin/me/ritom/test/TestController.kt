package me.ritom.test

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream




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
    @PostMapping("/upload",consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun postUpload(@RequestPart mFile:MultipartFile, @RequestPart(required = false) title:String?):String {
        val file = File("files/${title}.${mFile.originalFilename?.split(".")?.get(1)}")
        if (!file.exists()) file.createNewFile()
        val output = FileOutputStream(file)
        output.write(mFile.bytes)
        output.close()
        return "Data received"
    }
}