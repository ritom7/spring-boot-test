package me.ritom.test.database

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("customer")
data class Customer(
    @Id
    val id:Long,
    val username:String,
)