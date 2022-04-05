package lab2

import lab2.colorRGB.ColorRGB
import lab2.shape.ColoredShape2d
import lab2.shape.circle

fun main(args: Array<String>) {
    val shape: ColoredShape2d = circle(
        5.0,
        ColorRGB(1, 2, 3, 4),
        ColorRGB(1, 2, 3, 4)
    )
    println(shape.fillColor)
}