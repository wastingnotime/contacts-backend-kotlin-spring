package com.henriquericcio.contacts

import org.springframework.data.repository.CrudRepository

interface ContactRepository : CrudRepository<Contact, String> {
}