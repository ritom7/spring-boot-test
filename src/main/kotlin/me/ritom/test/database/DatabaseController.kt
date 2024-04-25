package me.ritom.test.database

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DatabaseController {
    private val logger: Logger = LoggerFactory.getLogger(DatabaseController::class.java)
    @Autowired
    private lateinit var repo:CustomerRepo
    @PostMapping("/savecust")
    fun saveCustomer(@RequestBody cust:Customer):String {
        logger.info("Saving customer ${cust.username}")
        repo.save(cust)
        return "Success"
    }
}