package lab3.contactsService

import lab3.contact.Contact
import lab3.contact.PhoneType
import lab3.person.Person
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ContactsServiceImplTest {

    private lateinit var contactService: ContactsService

    @BeforeEach
    fun setUp() {
        contactService = ContactsServiceImpl()
        contactService.addContact(Person("Ilia", "Muromec"), Contact.Email("ilia@mail.ru"))
        contactService.addContact(Person("Alesha", "Popovich"), Contact.Email("alesha@mail.ru"))
    }

    @Test
    fun addContact() {
        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru")),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru")),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun addPhone() {
        contactService.addPhone(Person("Ilia", "Muromec"), 1234, PhoneType.HOME)
        contactService.addPhone(Person("Alesha", "Popovich"), 5678, PhoneType.MOBILE)

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.Phone(1234, PhoneType.HOME)),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.Phone(5678, PhoneType.MOBILE)),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun addEmail() {
        contactService.addEmail(Person("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(Person("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.Email("dadad@mail.ru")),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.Email("netnet@mail.ru")),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun addAddress() {
        contactService.addAddress(Person("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(Person("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.Address("Tutove", "Tuta", 1, 1)),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.Address("Sudova", "Suda", 2, 2)),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun addLinkToSocialNetwork() {
        contactService.addLinkToSocialNetwork(Person("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(Person("Alesha", "Popovich"), "Gulub", "https://Gulub/456")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.LinkToSocialNetwork("Gulub", "https://Golub/123")),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.LinkToSocialNetwork("Gulub", "https://Gulub/456")),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun removeContact() {
        contactService.removeContact(Person("Ilia", "Muromec"), Contact.Email("ilia@mail.ru"))
        contactService.removeContact(Person("Alesha", "Popovich"), Contact.Email("alesha@mail.ru"))

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun removeAllPersonData() {
        contactService.addLinkToSocialNetwork(Person("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(Person("Alesha", "Popovich"), "Gulub", "https://Gulub/456")

        contactService.addAddress(Person("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(Person("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)

        contactService.removeAllPersonData(Person("Ilia", "Muromec"))
        contactService.removeAllPersonData(Person("Alesha", "Popovich"))

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf<Contact>(),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonContacts() {
        contactService.addEmail(Person("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(Person("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.Email("dadad@mail.ru")),
            contactService.getPersonContacts(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.Email("netnet@mail.ru")),
            contactService.getPersonContacts(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonPhones() {
        contactService.addPhone(Person("Ilia", "Muromec"), 1234, PhoneType.HOME)
        contactService.addPhone(Person("Alesha", "Popovich"), 5678, PhoneType.MOBILE)

        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Phone(1234, PhoneType.HOME)),
            contactService.getPersonPhones(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Phone(5678, PhoneType.MOBILE)),
            contactService.getPersonPhones(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonEmails() {
        contactService.addEmail(Person("Ilia", "Muromec"), "dadad@mail.ru")
        contactService.addEmail(Person("Alesha", "Popovich"), "netnet@mail.ru")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Email("ilia@mail.ru"), Contact.Email("dadad@mail.ru")),
            contactService.getPersonEmails(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Email("alesha@mail.ru"), Contact.Email("netnet@mail.ru")),
            contactService.getPersonEmails(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonAddresses() {
        contactService.addAddress(Person("Ilia", "Muromec"), "Tutove", "Tuta", 1, 1)
        contactService.addAddress(Person("Alesha", "Popovich"), "Sudova", "Suda", 2, 2)


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.Address("Tutove", "Tuta", 1, 1)),
            contactService.getPersonAddresses(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.Address("Sudova", "Suda", 2, 2)),
            contactService.getPersonAddresses(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getPersonLinksToSocialNetwork() {
        contactService.addLinkToSocialNetwork(Person("Ilia", "Muromec"), "Gulub", "https://Golub/123")
        contactService.addLinkToSocialNetwork(Person("Alesha", "Popovich"), "Gulub", "https://Gulub/456")


        assertEquals(2, contactService.getSize())
        assertEquals(
            listOf(Contact.LinkToSocialNetwork("Gulub", "https://Golub/123")),
            contactService.getPersonLinksToSocialNetwork(Person("Ilia", "Muromec"))
        )
        assertEquals(
            listOf(Contact.LinkToSocialNetwork("Gulub", "https://Gulub/456")),
            contactService.getPersonLinksToSocialNetwork(Person("Alesha", "Popovich"))
        )
    }

    @Test
    fun getAllPersons() {
        assertEquals(
            listOf(Person("Ilia", "Muromec"), Person("Alesha", "Popovich")),
            contactService.getAllPersons()
        )
    }

    @Test
    fun getAllContacts() {
        assertEquals(
            mapOf(
                Person("Ilia", "Muromec") to listOf<Contact>(Contact.Email("ilia@mail.ru")),
                Person("Alesha", "Popovich") to listOf<Contact>(Contact.Email("alesha@mail.ru"))
            ), contactService.getAllContacts()
        )
    }


    @Test
    fun findPersons() {
        assertEquals(
            listOf(Person("Alesha", "Popovich")),
            contactService.findPersons("Alesha", "Popovich")
        )
        assertEquals(
            listOf(Person("Ilia", "Muromec")),
            contactService.findPersons(subStringOfFirstName = null, "uro")
        )
    }
}