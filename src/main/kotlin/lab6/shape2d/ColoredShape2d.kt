package lab6.shape2d

import lab6.colorRGB.ColorRGB

interface ColoredShape2d : Shape2d {
    val borderColor: ColorRGB
    val fillColor: ColorRGB
}