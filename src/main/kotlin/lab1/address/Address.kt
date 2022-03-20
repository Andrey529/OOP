package lab1.address

fun biggestIndex(addresses: List<Address>): Address? = addresses.maxByOrNull { it.index }
fun smallestIndex(addresses: List<Address>): Address? = addresses.minByOrNull { it.index }
fun addressWithLongestStreet(addresses: List<Address>): Address? = addresses.maxByOrNull { it.street.length }
fun addressWithShortestStreet(addresses: List<Address>): Address? = addresses.minByOrNull { it.street.length }

fun parseAddresses(addresses: String): List<Address> {
    if (addresses.isEmpty()) {
        return emptyList()
    }

    val listAddresses = mutableListOf<Address>()
    val strings = addresses.split('\n')

    for (str in strings) {
        val partString = str.split(',') // split the string by commas

        val indexPart = partString[0].split('.') // split first element of list strings by dot
        val index = indexPart[1].drop(1).toInt() // get index

        val city = partString[1].drop(1)  // get city from list strings
        val street = partString[2].drop(5) // get street from list strings
        val buildingNumber = partString[3].drop(4).toInt() // get building from list strings

        val address = Address(index, city, street, buildingNumber)
        listAddresses.add(address)
    }
    return listAddresses
}

data class Address(val index: Int, val city: String, val street: String, val building: Int) {
    override fun toString(): String {
        return "Address: index = $index, city = $city, street = $street, building number = $building"
    }
}