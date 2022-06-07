package lab3

import lab3.contact.*
import lab3.contactsService.*
import lab3.person.*

fun main(args: Array<String>) {

    val contactService = ContactsServiceImpl()
    val person = Person("Andrey", "Bludin")
    val email = Contact.Email("andr755234@mail.ru")

    contactService.addContact(person, email)
    contactService.addContact(Person("Danil", "Khromenko"), Contact.Email("dadad@mail.ru"))
    contactService.addContact(person, Contact.Email("1232435@mail.ru"))
    contactService.addContact(person, Contact.Phone(12345, PhoneType.HOME))

    val listEmails = contactService.getPersonEmails(Person("Andrey", "Bludin"))
    val listPhones = contactService.getPersonPhones(Person("Andrey", "Bludin"))
    val listContacts = contactService.getPersonContacts(Person("Andrey", "Bludin"))
    println(listEmails)
    println(listPhones)
    println(listContacts)

    val find = contactService.findPersons("ndr", "ud")
    println(find)
    println(contactService.getSize())
}