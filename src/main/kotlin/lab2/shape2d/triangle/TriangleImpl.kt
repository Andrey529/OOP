package lab2.shape2d.triangle

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d
import kotlin.math.sqrt

@kotlinx.serialization.Serializable
data class NotColoredTriangle(
    override val side1: Double,
    override val side2: Double,
    override val side3: Double,
) : Triangle, Shape2d {
    init {
        require(side1 > 0) { "Incorrect length of side1 in Not Colored Triangle" }
        require(side2 > 0) { "Incorrect length of side2 in Not Colored Triangle" }
        require(side3 > 0) { "Incorrect length of side3 in Not Colored Triangle" }
    }

    val semiperimeter = (side1 + side2 + side3) / 3
    override fun calcArea(): Double {
        return sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3))
    }
}

@kotlinx.serialization.Serializable
data class ColoredTriangle(
    override val side1: Double,
    override val side2: Double,
    override val side3: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB,
) : Triangle, ColoredShape2d {
    init {
        require(side1 > 0) { "Incorrect length of side1 in Colored Triangle" }
        require(side2 > 0) { "Incorrect length of side2 in Colored Triangle" }
        require(side3 > 0) { "Incorrect length of side3 in Colored Triangle" }
    }

    val semiperimeter = (side1 + side2 + side3) / 3
    override fun calcArea(): Double {
        return sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3))
    }
}