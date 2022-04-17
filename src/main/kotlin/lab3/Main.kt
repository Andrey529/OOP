package lab3

import lab3.contact.*

//import org.slf4j.event.*

fun main(args: Array<String>) {

    var contact: Contact = ContactImpl.Phone(12345, PhoneType.HOME)
    contact = ContactImpl.Email("asgdkh")

    println(contact)
}