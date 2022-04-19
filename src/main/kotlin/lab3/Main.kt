package lab3

import lab3.contact.*
import lab3.contactsService.*
import lab3.person.*

fun main(args: Array<String>) {

    val contactService = ContactsServiceImpl()
    val person = PersonImpl("Andrey", "Bludin")
    val email = ContactImpl.Email("andr755234@mail.ru")

    contactService.addContact(person, email)
    contactService.addContact(PersonImpl("Danil", "Khromenko"), ContactImpl.Email("dadad@mail.ru"))
    contactService.addContact(person, ContactImpl.Email("1232435@mail.ru"))

    println(contactService.getSize())
}