package lab6.shapeCollector

import lab6.colorRGB.ColorRGB
import lab6.shape2d.ColoredShape2d

interface ShapeCollector {
    fun addShape(shape: ColoredShape2d)
    fun getShapeWithMaxArea(): ColoredShape2d?
    fun getShapeWithMinArea(): ColoredShape2d?
    fun sumAllShapesArea(): Double
    fun getShapesByBorderColor(borderColor: ColorRGB): List<ColoredShape2d>
    fun getShapesByFillColor(fillColor: ColorRGB): List<ColoredShape2d>
    fun getAllShapes(): List<ColoredShape2d>
    fun getCountShapes(): Int
    fun getShapesGroupedByBorderColor(): Map<ColorRGB, List<ColoredShape2d>>
    fun getShapesGroupedByFillColor(): Map<ColorRGB, List<ColoredShape2d>>
    fun <T> getShapesByType(type: Class<T>): List<ColoredShape2d>
}