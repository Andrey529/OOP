package lab2.shape

import lab2.colorRGB.ColorRGB
import kotlin.math.PI

class circle(
    val semidiameter: Double,
    override val fillColor: ColorRGB,
    override val borderColor: ColorRGB
) : ColoredShape2d {

    init {
        require(semidiameter > 0) { "Incorrect semidiameter" }
    }

    override fun calcArea(): Double = semidiameter * semidiameter * PI
}
