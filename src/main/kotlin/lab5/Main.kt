package lab5

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.circle.ColoredCircle
import lab2.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab5.ShapeCollectorWithGenerics.ShapeCollectorWithGenerics
import lab5.ShapeCollectorWithGenerics.ShapeCollectorWithGenericsImpl

fun main(args: Array<String>) {
    val color1 = ColorRGB(1, 2, 3, 4)
    val color2 = ColorRGB(5, 6, 7, 8)

    val collector: ShapeCollectorWithGenerics<ColoredShape2d> = ShapeCollectorWithGenericsImpl()
    collector.addAll(
        listOf(
            ColoredCircle(2.0, color1, color2),
            ColoredRectangle(3.0, 2.0, color1, color2),
        )
    )
    println(collector.getAllShapes())

}