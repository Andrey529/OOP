package lab2

import lab2.shape2d.circle.*
import lab2.colorRGB.*
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d

fun main(args: Array<String>) {
    val circle: Shape2d = ColoredCircle(
        12.0,
        ColorRGB(1, 2, 3, 4),
        ColorRGB(1, 2, 3, 4)
    )
    circle.calcArea()
//    circle.semidiameter
//    circle.fillColor
//    circle.borderColor


    val circle2: ColoredShape2d = ColoredCircle(
        13.0,
        ColorRGB(1, 2, 3, 4),
        ColorRGB(1, 2, 3, 4)
    )
    circle2.calcArea()
//    circle2.semidiameter
    circle2.fillColor
    circle2.borderColor

    val circle3: Circle = NotColoredCircle(
        14.0
    )
//    circle3.calcArea()
    circle3.semidiameter
//    circle3.fillColor
//    circle3.borderColor

}