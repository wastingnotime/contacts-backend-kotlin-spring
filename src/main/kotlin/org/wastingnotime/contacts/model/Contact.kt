package org.wastingnotime.contacts.model

import java.util.*
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Contact(
        @Id
        val id: String = UUID.randomUUID().toString(),
        var firstName: String,
        var lastName: String,
        var phoneNumber: String)