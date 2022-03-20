package lab1.address

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AddressKtTest {

    @Test
    fun parseAddressesNotEmptyList() {
        val addresses = """
            1. 11111, Москва, ул. Московская, д. 1
            2. 22222, Санкт-Петербург, ул. Питерская, д. 2
            3. 33333, Анапа, ул. Анапская, д. 3
        """.trimIndent()
        val listAddresses = parseAddresses(addresses)

        val rightListAddresses: List<Address> = listOf(
            Address(11111, "Москва", "Московская", 1),
            Address(22222, "Санкт-Петербург", "Питерская", 2),
            Address(33333, "Анапа", "Анапская", 3)
        )

        assertEquals(listAddresses, rightListAddresses)
    }

    @Test
    fun parseAddressesEmptyList() {
        val addresses = ""
        assertEquals(parseAddresses(addresses), emptyList<Address>())
    }

    @Test
    fun biggestIndexNotNull() {
        val listAddresses: List<Address> = listOf(
            Address(11111, "Москва", "Московская", 1),
            Address(22222, "Санкт-Петербург", "Питерская", 2),
            Address(33333, "Анапа", "Анапская", 3)
        )
        assertNotNull(biggestIndex(listAddresses))
        assertEquals(biggestIndex(listAddresses), listAddresses[2])
    }

    @Test
    fun biggestIndexNull() {
        val listAddresses: List<Address> = emptyList()
        assertNull(biggestIndex(listAddresses))
    }

    @Test
    fun smallestIndexNotNull() {
        val listAddresses: List<Address> = listOf(
            Address(11111, "Москва", "Московская", 1),
            Address(22222, "Санкт-Петербург", "Питерская", 2),
            Address(33333, "Анапа", "Анапская", 3)
        )
        assertNotNull(smallestIndex(listAddresses))
        assertEquals(smallestIndex(listAddresses), listAddresses[0])
    }

    @Test
    fun smallestIndexNull() {
        val listAddresses: List<Address> = emptyList()
        assertNull(smallestIndex(listAddresses))
    }

    @Test
    fun addressWithLongestStreetNotNull() {
        val listAddresses: List<Address> = listOf(
            Address(11111, "Москва", "Московская", 1),
            Address(22222, "Санкт-Петербург", "Питерская", 2),
            Address(33333, "Анапа", "Анапская", 3)
        )
        assertNotNull(addressWithLongestStreet(listAddresses))
        assertEquals(addressWithLongestStreet(listAddresses), listAddresses[0])
    }

    @Test
    fun addressWithLongestStreetNull() {
        val listAddresses: List<Address> = emptyList()
        assertNull(addressWithLongestStreet(listAddresses))
    }

    @Test
    fun addressWithShortestStreetNotNull() {
        val listAddresses: List<Address> = listOf(
            Address(11111, "Москва", "Московская", 1),
            Address(22222, "Санкт-Петербург", "Питерская", 2),
            Address(33333, "Анапа", "Анапская", 3)
        )
        assertNotNull(addressWithShortestStreet(listAddresses))
        assertEquals(addressWithShortestStreet(listAddresses), listAddresses[2])
    }

    @Test
    fun addressWithShortestStreetNull() {
        val listAddresses: List<Address> = emptyList()
        assertNull(addressWithShortestStreet(listAddresses))
    }
}