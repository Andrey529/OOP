package lab2.colorRGB

data class ColorRGB(val red_: Int, val green_: Int, val blue_: Int, val clarity_: Int) {
    init {
        require(red_ >= 0 && red_ < 256) { "Incorrect value of the red component of the color" }
        require(green_ >= 0 && green_ < 256) { "Incorrect value of the green component of the color" }
        require(blue_ >= 0 && blue_ < 256) { "Incorrect value of the blue component of the color" }
        require(clarity_ >= 0 && clarity_ <= 100) { "Incorrect value of the clarity component of the color" }
    }
}