package com.henriquericcio.contacts

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/contacts")
class ContactController(val contactRepository: ContactRepository) {
    @PostMapping
    fun save(@RequestBody contact: Contact): ResponseEntity<*> {
        contactRepository.save(contact)

        return ResponseEntity.created(URI.create("/" + contact.id)).build<Any>()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Contact {
        return contactRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    @GetMapping
    fun getAll(): Iterable<Contact> {
        return contactRepository.findAll()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody contact: Contact): ResponseEntity<*> {
        val currentContact = contactRepository.findByIdOrNull(id) ?: throw NotFoundException()

        currentContact.firstName = contact.firstName
        currentContact.lastName = contact.lastName
        currentContact.phoneNumber = contact.phoneNumber

        contactRepository.save(currentContact)

        return ResponseEntity.noContent().build<Any>()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<*> {
        val contact = contactRepository.findByIdOrNull(id) ?: throw NotFoundException()

        contactRepository.delete(contact)

        return ResponseEntity.noContent().build<Any>()
    }
}