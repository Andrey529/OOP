package lab3.contact

sealed class ContactImpl : Contact {
    data class Phone(val number: Int, val phoneType: PhoneType) : ContactImpl()

    data class Email(val email: String) : ContactImpl()

    data class Address(val city: String, val street: String, val house: Int, val flat: Int) : ContactImpl()

    data class LinkToSocialNetwork(val title: String, val link: String) : ContactImpl()
}