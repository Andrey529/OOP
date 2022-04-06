package lab2.shape2d.quadrilateral.rectangle

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d

class NotColoredRectangle(override val length: Double, override val width: Double) : Rectangle, Shape2d {
    init {
        require(length > 0) { "Incorrect length in Not Colored Square" }
        require(width > 0) { "Incorrect width in Not Colored Square" }
    }

    override fun calcArea(): Double = length * width
}

class ColoredRectangle(
    override val length: Double,
    override val width: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB,
) : Rectangle, ColoredShape2d {
    init {
        require(length > 0) { "Incorrect length in Colored Square" }
        require(width > 0) { "Incorrect width in Colored Square" }
    }

    override fun calcArea(): Double = length * width
}
