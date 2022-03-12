package address

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertDoesNotThrow

internal class AddressKtTest {

    @Test
    fun parseAddresses() {
        val adresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAdresses = parseAddresses(adresses)

        assertDoesNotThrow { parseAddresses(adresses) }

        assertEquals(listAdresses[0].index, 11111)
        assertEquals(listAdresses[0].city, "Москва")
        assertEquals(listAdresses[0].street, "Московская")
        assertEquals(listAdresses[0].building, 1)

        assertEquals(listAdresses[1].index, 22222)
        assertEquals(listAdresses[1].city, "Санкт-Петербург")
        assertEquals(listAdresses[1].street, "Питерская")
        assertEquals(listAdresses[1].building, 2)

        assertEquals(listAdresses[2].index, 33333)
        assertEquals(listAdresses[2].city, "Анапа")
        assertEquals(listAdresses[2].street, "Анапская")
        assertEquals(listAdresses[2].building, 3)

    }

    @Test
    fun biggestIndex() {
        val adresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAdresses = parseAddresses(adresses)

        assertDoesNotThrow { biggestIndex(listAdresses) }
        assertEquals(biggestIndex(listAdresses).index, 33333)
    }

    @Test
    fun smallestIndex() {
        val adresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAdresses = parseAddresses(adresses)

        assertDoesNotThrow { smallestIndex(listAdresses) }
        assertEquals(smallestIndex(listAdresses).index, 11111)
    }

    @Test
    fun addressWithLongestStreet() {
        val adresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAdresses = parseAddresses(adresses)

        assertDoesNotThrow { addressWithLongestStreet(listAdresses) }
        assertEquals(addressWithLongestStreet(listAdresses).street, "Московская")
    }

    @Test
    fun addressWithShortestStreet() {
        val adresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAdresses = parseAddresses(adresses)

        assertDoesNotThrow { addressWithShortestStreet(listAdresses) }
        assertEquals(addressWithShortestStreet(listAdresses).street, "Анапская")
    }

}