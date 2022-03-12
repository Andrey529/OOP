package address

fun main(args: Array<String>) {

    val adresses = """
            1. 111111, Москва, ул. Московская проспект проспектный, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()

    val listAdresses: MutableList<Address>
    try {
        listAdresses = parseAddresses(adresses)
    }
    catch (e: IllegalArgumentException) {
        println(e)
        return
    }

    for (adress in listAdresses){
        println(adress)
    }

    try {
        println("Adress with the biggest index; index = ${biggestIndex(listAdresses).index}")
        println("Adress with the smallest index; index = ${smallestIndex(listAdresses).index}")

        println("Adress with the longest street; street = ${addressWithLongestStreet(listAdresses).street}")
        println("Adress with the shortest street; street = ${addressWithShortestStreet(listAdresses).street}")
    }
    catch (e: IllegalArgumentException) {
        println(e)
        return
    }

}