package lab2.shape2d.circle

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d
import kotlin.math.PI
import kotlin.math.pow

data class NotColoredCircle(override val semidiameter: Double) : Shape2d, Circle {
    init {
        require(semidiameter > 0) { "Incorrect semidiameter in Circle" }
    }

    override fun calcArea(): Double = semidiameter.pow(2) * PI
}

data class ColoredCircle(
    override val semidiameter: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB,
) : ColoredShape2d, Circle {

    init {
        require(semidiameter > 0) { "Incorrect semidiameter in Colored Circle" }
    }

    override fun calcArea(): Double = semidiameter.pow(2) * PI
}