package lab3.contactsService

import lab3.contact.Contact
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
            listContacts.add(Contact.Phone(phone, phoneType))
        }
        LOG.info("Added phone contact with phone number: $phone and phone type: $phoneType to person: $person")
    }

    override fun addEmail(person: Person, email: String) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(Contact.Email(email))
        }
        LOG.info("Added email contact with email: $email to person: $person")
    }

    override fun addAddress(person: Person, city: String, street: String, house: Int, flat: Int) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(Contact.Address(city, street, house, flat))
        }
        LOG.info("Added address contact with city: $city, street: $street, house: $house and flat: $flat to person: $person")
    }

    override fun addLinkToSocialNetwork(person: Person, title: String, link: String) {
        if (peopleData.get(person) == null) {
            peopleData.put(person, mutableListOf())
        }
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.add(Contact.LinkToSocialNetwork(title, link))
        }
        LOG.info("Added link to social network contact with title: $title and link: $link to person: $person")
    }

    override fun removeContact(person: Person, contact: Contact) {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.remove(contact)
            LOG.info("Removed contact: $contact to person: $person")
        } else {
            LOG.info("Not removed contact: $contact because does not have person: $person")
        }
    }

    override fun removeAllPersonData(person: Person) {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            listContacts.clear()
            LOG.info("Removed all contacts of a person: $person")
        } else {
            LOG.info("Not removed all contacts of a person: $person because they are not there")
        }
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            LOG.info("Returned all contacts of a person: $person")
            return listContacts
        } else {
            LOG.info("Not returned all contacts of a person: $person because they are not there. Returned empty list")
            return emptyList()
        }
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            LOG.info("Returned phone contacts of a person: $person")
            return listContacts.filterIsInstance<Contact.Phone>()
        } else {
            LOG.info("Not returned phone contacts of a person: $person because they are not there. Returned empty list")
            return emptyList()
        }
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            LOG.info("Returned email contacts of a person: $person")
            return listContacts.filterIsInstance<Contact.Email>()
        } else {
            LOG.info("Not returned email contacts of a person: $person because they are not there. Returned empty list")
            return emptyList()
        }
    }

    override fun getPersonAddresses(person: Person): List<Contact.Address> {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            LOG.info("Returned address contacts of a person: $person")
            return listContacts.filterIsInstance<Contact.Address>()
        } else {
            LOG.info("Not returned address contacts of a person: $person because they are not there. Returned empty list")
            return emptyList()
        }
    }

    override fun getPersonLinksToSocialNetwork(person: Person): List<Contact.LinkToSocialNetwork> {
        val listContacts = peopleData.get(person)
        if (listContacts != null) {
            LOG.info("Returned links to social network contacts of a person: $person")
            return listContacts.filterIsInstance<Contact.LinkToSocialNetwork>()
        } else {
            LOG.info("Not returned links to social network contacts of a person: $person because they are not there. Returned empty list")
            return emptyList()
        }
    }

    override fun getAllPersons(): List<Person> {
        LOG.info("Returned a list of people")
        return peopleData.keys.toList()
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        LOG.info("Returned all contacts of people")
        return peopleData
    }

    override fun findPersons(subStringOfFirstName: String?, subStringOfLastName: String?): List<Person> {
        if (subStringOfFirstName != null && subStringOfLastName != null) {
            return peopleData.keys.filter { subStringOfFirstName in it.firstName && subStringOfLastName in it.lastName }
        } else if (subStringOfFirstName != null) {
            return peopleData.keys.filter { subStringOfFirstName in it.firstName }
        } else if (subStringOfLastName != null) {
            return peopleData.keys.filter { subStringOfLastName in it.lastName }
        } else {
            return emptyList()
        }
    }

    override fun getSize() = peopleData.size

}