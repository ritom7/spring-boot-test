package me.ritom.test.database

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepo : MongoRepository<Customer, Long> {
    fun findByUsername(username: String): Customer
}
