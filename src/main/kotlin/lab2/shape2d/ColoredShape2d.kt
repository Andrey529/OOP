package lab2.shape2d

import lab2.colorRGB.ColorRGB

interface ColoredShape2d : Shape2d {
    val borderColor: ColorRGB
    val fillColor: ColorRGB
}