package lab6.shape2d.quadrilateral.square

import lab6.colorRGB.ColorRGB
import lab6.shape2d.ColoredShape2d
import lab6.shape2d.Shape2d
import kotlin.math.pow

@kotlinx.serialization.Serializable
data class NotColoredSquare(override val length: Double) : Square, Shape2d {
    override val width: Double = length

    init {
        require(length > 0) { "Incorrect length in Not Colored Square" }
    }

    override fun calcArea(): Double = length.pow(2)
}

@kotlinx.serialization.Serializable
data class ColoredSquare(
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
