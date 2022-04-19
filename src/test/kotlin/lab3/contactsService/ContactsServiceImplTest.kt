package lab3.contactsService

import lab3.contact.Contact
import lab3.contact.ContactImpl
import lab3.contact.PhoneType
import lab3.person.PersonImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ContactsServiceImplTest {

    private lateinit var contactService: ContactsService

    @BeforeEach
    fun setUp() {
        contactService = ContactsServiceImpl()
        contactService.addContact(PersonImpl("Ilia", "Muromec"), ContactImpl.Email("ilia@mail.ru"))
        contactService.addContact(PersonImpl("Alesha", "Popovich"), ContactImpl.Email("alesha@mail.ru"))
    }

    @Test
    fun addContact() {
        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun addPhone() {
        contactService.addPhone(PersonImpl("Ilia", "Muromec"), 1234, PhoneType.HOME)
        contactService.addPhone(PersonImpl("Alesha", "Popovich"), 5678, PhoneType.MOBILE)

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.Phone(1234, PhoneType.HOME)),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.Phone(5678, PhoneType.MOBILE)),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun addEmail() {
        contactService.addEmail(PersonImpl("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(PersonImpl("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.Email("dadad@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.Email("netnet@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun addAddress() {
        contactService.addAddress(PersonImpl("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(PersonImpl("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.Address("Tutove", "Tuta", 1, 1)),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.Address("Sudova", "Suda", 2, 2)),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun addLinkToSocialNetwork() {
        contactService.addLinkToSocialNetwork(PersonImpl("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(PersonImpl("Alesha", "Popovich"), "Gulub", "https://Gulub/456")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.LinkToSocialNetwork("Gulub", "https://Golub/123")),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.LinkToSocialNetwork("Gulub", "https://Gulub/456")),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun removeContact() {
        contactService.removeContact(PersonImpl("Ilia", "Muromec"), ContactImpl.Email("ilia@mail.ru"))
        contactService.removeContact(PersonImpl("Alesha", "Popovich"), ContactImpl.Email("alesha@mail.ru"))

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun removeAllPersonData() {
        contactService.addLinkToSocialNetwork(PersonImpl("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(PersonImpl("Alesha", "Popovich"), "Gulub", "https://Gulub/456")

        contactService.addAddress(PersonImpl("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(PersonImpl("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)

        contactService.removeAllPersonData(PersonImpl("Ilia", "Muromec"))
        contactService.removeAllPersonData(PersonImpl("Alesha", "Popovich"))

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonContacts() {
        contactService.addEmail(PersonImpl("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(PersonImpl("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.Email("dadad@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.Email("netnet@mail.ru")),
            contactService.getPersonContacts(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonPhones() {
        contactService.addPhone(PersonImpl("Ilia", "Muromec"), 1234, PhoneType.HOME)
        contactService.addPhone(PersonImpl("Alesha", "Popovich"), 5678, PhoneType.MOBILE)

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Phone(1234, PhoneType.HOME)),
            contactService.getPersonPhones(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Phone(5678, PhoneType.MOBILE)),
            contactService.getPersonPhones(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonEmails() {
        contactService.addEmail(PersonImpl("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(PersonImpl("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Email("ilia@mail.ru"), ContactImpl.Email("dadad@mail.ru")),
            contactService.getPersonEmails(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Email("alesha@mail.ru"), ContactImpl.Email("netnet@mail.ru")),
            contactService.getPersonEmails(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonAddresses() {
        contactService.addAddress(PersonImpl("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(PersonImpl("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.Address("Tutove", "Tuta", 1, 1)),
            contactService.getPersonAddresses(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.Address("Sudova", "Suda", 2, 2)),
            contactService.getPersonAddresses(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonLinksToSocialNetwork() {
        contactService.addLinkToSocialNetwork(PersonImpl("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(PersonImpl("Alesha", "Popovich"), "Gulub", "https://Gulub/456")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(ContactImpl.LinkToSocialNetwork("Gulub", "https://Golub/123")),
            contactService.getPersonLinksToSocialNetwork(PersonImpl("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(ContactImpl.LinkToSocialNetwork("Gulub", "https://Gulub/456")),
            contactService.getPersonLinksToSocialNetwork(PersonImpl("Alesha", "Popovich"))
        )
    }

    @Test
    fun getAllPersons() {
        assertEquals(
            listOf(PersonImpl("Ilia", "Muromec"), PersonImpl("Alesha", "Popovich")),
            contactService.getAllPersons()
        )
    }

    @Test
    fun getAllContacts() {
        assertEquals(
            mapOf(
                PersonImpl("Ilia", "Muromec") to listOf<Contact>(ContactImpl.Email("ilia@mail.ru")),
                PersonImpl("Alesha", "Popovich") to listOf<Contact>(ContactImpl.Email("alesha@mail.ru"))
            ), contactService.getAllContacts()
        )
    }


    @Test
    fun findPersons() {
        assertEquals(
            listOf(PersonImpl("Alesha", "Popovich")),
            contactService.findPersons("Alesha", "Popovich")
        )
        assertEquals(
            listOf(PersonImpl("Ilia", "Muromec")),
            contactService.findPersons(subStringOfFirstName = null, "uro")
        )
    }
}