package com.henriquericcio.contacts

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Contact(
        @Id
        val id: String = UUID.randomUUID().toString(),
        var firstName: String,
        var lastName: String,
        var phoneNumber: String)