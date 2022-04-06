package lab2.shape2d.quadrilateral.square

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d
import kotlin.math.pow

class NotColoredSquare(override val length: Double) : Square, Shape2d {
    override val width: Double = length

    init {
        require(length > 0) { "Incorrect length in Not Colored Square" }
    }

    override fun calcArea(): Double = length.pow(2)
}

class ColoredSquare(
    override val length: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB,
) : Square, ColoredShape2d {
    override val width: Double = length

    init {
        require(length > 0) { "Incorrect length in Colored Square" }
    }

    override fun calcArea(): Double = length.pow(2)
}
