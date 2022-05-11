package lab3.contact

sealed class Contact {
    data class Phone(val number: Int, val phoneType: PhoneType) : Contact()

    data class Email(val email: String) : Contact()

    data class Address(val city: String, val street: String, val house: Int, val flat: Int) : Contact()

    data class LinkToSocialNetwork(val title: String, val link: String) : Contact()
}