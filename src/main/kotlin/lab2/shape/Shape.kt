package lab2.shape

import lab2.colorRGB.ColorRGB

interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: ColorRGB
    val fillColor: ColorRGB
}