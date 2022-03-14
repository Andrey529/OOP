package lab1

import lab1.address.*

fun main(args: Array<String>) {

    val adresses = """
            1. 111111, Москва, ул. Московская проспект проспектный, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()

    val listAdresses: List<Address>? = parseAddresses(adresses)

    if (listAdresses != null) {
        for (adress in listAdresses) {
            println(adress)
        }

        val addressWithBiggestIndex = biggestIndex(listAdresses)
        if (addressWithBiggestIndex != null)
            println("Adress with the biggest index; index = ${addressWithBiggestIndex.index}")
        else println("Empty list of adresses")

        val addressWithSmallestIndex = smallestIndex(listAdresses)
        if (addressWithSmallestIndex != null)
            println("Adress with the smallest index; index = ${addressWithSmallestIndex.index}")
        else println("Empty list of adresses")

        val addressWithLongestStreet = addressWithLongestStreet(listAdresses)
        if (addressWithLongestStreet != null)
            println("Adress with the longest street; street = ${addressWithLongestStreet.street}")
        else println("Empty list of adresses")

        val addressWithShortestStreet = addressWithShortestStreet(listAdresses)
        if (addressWithShortestStreet != null)
            println("Adress with the shortest street; street = ${addressWithShortestStreet.street}")
        else println("Empty list of adresses")
    } else {
        println("Empty string with adresses")
    }
}