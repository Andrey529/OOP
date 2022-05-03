package lab6.colorRGB

@kotlinx.serialization.Serializable
data class ColorRGB(val red: Int, val green: Int, val blue: Int, val clarity: Int) {
    init {
        require(red in 0..255) { "Incorrect value of the red component of the color" }
        require(green in 0..255) { "Incorrect value of the green component of the color" }
        require(blue in 0..255) { "Incorrect value of the blue component of the color" }
        require(clarity in 0..100) { "Incorrect value of the clarity component of the color" }
    }
}
