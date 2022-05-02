package lab5.ShapeCollectorWithGenerics

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d

interface ShapeCollectorWithGenerics<T : ColoredShape2d> {

    fun addShape(shape: T)
    fun getShapeWithMaxArea(): T?
    fun getShapeWithMinArea(): T?
    fun sumAllShapesArea(): Double
    fun getShapesByBorderColor(borderColor: ColorRGB): List<T>
    fun getShapesByFillColor(fillColor: ColorRGB): List<T>
    fun getAllShapes(): List<T>
    fun getCountShapes(): Int
    fun getShapesGroupedByBorderColor(): Map<ColorRGB, List<T>>
    fun getShapesGroupedByFillColor(): Map<ColorRGB, List<T>>
    fun <Ttype : T> getShapesByType(type: Class<Ttype>): List<Ttype>

    fun addAll(collection: Collection<T>)
    fun getSorted(comparator: Comparator<T>): List<T>
}