package lab1.address

fun biggestIndex(addresses: MutableList<Address>) : Address {
    if (addresses.isEmpty()){
        throw IllegalArgumentException("Empty list of adresses")
    }
    var biggestIndex = addresses[0]
    for (adress in addresses){
        if (adress.index > biggestIndex.index){
            biggestIndex = adress
        }
    }
    return biggestIndex
}

fun smallestIndex(addresses: MutableList<Address>) : Address {
    if (addresses.isEmpty()){
        throw IllegalArgumentException("Empty list of adresses")
    }
    var smallestIndex = addresses[0]
    for (adress in addresses){
        if (adress.index < smallestIndex.index){
            smallestIndex = adress
        }
    }
    return smallestIndex
}

fun addressWithLongestStreet(addresses: MutableList<Address>) : Address {
    if (addresses.isEmpty()){
        throw IllegalArgumentException("Empty list of adresses")
    }
    var biggestStreet = addresses[0]
    for (adress in addresses){
        if (adress.street.length > biggestStreet.street.length) {
            biggestStreet = adress
        }
    }
    return biggestStreet
}

fun addressWithShortestStreet(addresses: MutableList<Address>) : Address {
    if (addresses.isEmpty()){
        throw IllegalArgumentException("Empty list of adresses")
    }
    var smallestStreet = addresses[0]
    for (adress in addresses){
        if (adress.street.length < smallestStreet.street.length) {
            smallestStreet = adress
        }
    }
    return smallestStreet
}


fun parseAddresses(addresses: String) : MutableList<Address> {
    if (addresses.isEmpty()){
        throw IllegalArgumentException("Empty string")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (index != other.index) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (building != other.building) return false

        return true
    }

    override fun hashCode(): Int {
        var result = index
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + building
        return result
    }
}