package lab3.contactsService

import lab3.contact.*
import lab3.person.Person

interface ContactsService {

    /**
     * Add any type of contact details for each person
     */
    fun addContact(person: Person, contact: Contact)

    /**
     * Add a contact details of a specific type for each person
     */
    fun addPhone(person: Person, phone: Int, phoneType: PhoneType)
    fun addEmail(person: Person, email: String)
    fun addAddress(person: Person, city: String, street: String, house: Int, flat: Int)
    fun addLinkToSocialNetwork(person: Person, title: String, link: String)

    /**
     * Delete any type of contact information for each person
     */
    fun removeContact(person: Person, contact: Contact)

    /**
     * Delete all data about a person
      */
    fun removeAllPersonData(person: Person)

    /**
     * Get all contacts of a person
     */
    fun getPersonContacts(person: Person) : List<Contact>

    /**
     * Get a contact details of a specific type from a person
     */
    fun getPersonPhones(person: Person) : List<Contact.Phone>
    fun getPersonEmails(person: Person): List<Contact.Email>
    fun getPersonAddresses(person: Person) : List<Contact.Address>
    fun getPersonLinksToSocialNetwork(person: Person) : List<Contact.LinkToSocialNetwork>

    /**
     * Get all people who have contacts
     */
    fun getAllPersons(): List<Person>

    /**
     * Get all contacts from all people
     */
    fun getAllContacts(): Map<Person, List<Contact>>

    /**
     * Search for people by substring in first and last name
     */
    fun findPersons(subStringOfFirstName: String?, subStringOfLastName: String?) : List<Person>
}