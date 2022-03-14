package lab1.address

fun biggestIndex(addresses: List<Address>): Address? = addresses.maxByOrNull { it.index }
fun smallestIndex(addresses: List<Address>): Address? = addresses.minByOrNull { it.index }
fun addressWithLongestStreet(addresses: List<Address>): Address? = addresses.maxByOrNull { it.street.length }
fun addressWithShortestStreet(addresses: List<Address>): Address? = addresses.minByOrNull { it.street.length }

fun parseAddresses(addresses: String): List<Address>? {
    if (addresses.isEmpty()) {
        return null
    }

    val listAddresses = mutableListOf<Address>()
    val strings = addresses.split('\n')

    for (str in strings) {
        val partString = str.split(',') // [N. ИндексN, Название города N, ул. Название улицы, д. Номер дома]

        val indexPart = partString[0].split('.') // [N, ИндексN]
        val index = indexPart[1].drop(1).toInt() // ИндексN

        val city = partString[1].drop(1)  // Название города N
        val street = partString[2].drop(5) // Название улицы
        val buildingNumber = partString[3].drop(4).toInt() // Номер дома

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