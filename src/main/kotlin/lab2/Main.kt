package lab2

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Circle

fun main(args: Array<String>) {
    val shape: ColoredShape2d = Circle(
        5.0,
        ColorRGB(1, 2, 3, 4),
        ColorRGB(1, 2, 3, 4)
    )
    println(shape.fillColor)
}