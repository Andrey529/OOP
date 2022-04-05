package lab2.shape2d

import lab2.colorRGB.ColorRGB
import kotlin.math.PI

class Circle(
    val semidiameter: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB
) : ColoredShape2d {

    init {
        require(semidiameter > 0) { "Incorrect semidiameter" }
    }

    override fun calcArea(): Double = semidiameter * semidiameter * PI
}
