package lab2.colorRGB

data class ColorRGB(val red_: Int, val green_: Int, val blue_: Int, val clarity_: Int) {
    init {
        require(red_ in 0..255) { "Incorrect value of the red component of the color" }
        require(green_ in 0..255) { "Incorrect value of the green component of the color" }
        require(blue_ in 0..255) { "Incorrect value of the blue component of the color" }
        require(clarity_ in 0..100) { "Incorrect value of the clarity component of the color" }
    }
}