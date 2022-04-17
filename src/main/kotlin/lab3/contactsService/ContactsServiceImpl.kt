package lab3.contactsService

import lab3.contact.Contact
import lab3.contact.ContactImpl
import lab3.contact.PhoneType
import lab3.person.Person
import org.apache.logging.log4j.LogManager

private val LOG = LogManager.getLogger(ContactsServiceImpl::class.java)

class ContactsServiceImpl : ContactsService {
    private val peopleData: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(contact)
        }
        LOG.info("Added contact: $contact to person: $person")
    }

    override fun addPhone(person: Person, phone: Int, phoneType: PhoneType) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(ContactImpl.Phone(phone, phoneType))
        }
        LOG.info("Added phone contact with phone number: $phone and phone type: $phoneType to person: $person")
    }

    override fun addEmail(person: Person, email: String) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(ContactImpl.Email(email))
        }
        LOG.info("Added email contact with email: $email to person: $person")
    }

    override fun addAddress(person: Person, city: String, street: String, house: Int, flat: Int) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(ContactImpl.Address(city, street, house, flat))
        }
        LOG.info("Added adress contact with city: $city, street: $street, house: $house and flat: $flat to person: $person")
    }

    override fun addLinkToSocialNetwork(person: Person, title: String, link: String) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(ContactImpl.LinkToSocialNetwork(title, link))
        }
        LOG.info("Added link to social network contact with title: $title and link: $link to person: $person")
    }

    override fun removeContact(person: Person, contact: Contact) {
        peopleData[person]?.remove(contact)
        LOG.info("Removed contact: $contact to person: $person")
    }

    override fun removeAllPersonData(person: Person) {
        peopleData[person]?.clear()
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        return peopleData[person]?.toList() ?: emptyList()
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        return buildList {
            peopleData[person]?.filter { it is ContactImpl.Phone }
        }
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        TODO("Not yet implemented")
    }

    override fun getPersonAddresses(person: Person): List<Contact.Address> {
        TODO("Not yet implemented")
    }

    override fun getPersonLinksToSocialNetwork(person: Person): List<Contact.LinkToSocialNetwork> {
        TODO("Not yet implemented")
    }

    override fun getAllPersons(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        TODO("Not yet implemented")
    }

    override fun findPersons(subStringOfFirstName: String?, subStringOfLastName: String?): List<Person> {
        TODO("Not yet implemented")
    }

    fun getSize() = peopleData.size

}