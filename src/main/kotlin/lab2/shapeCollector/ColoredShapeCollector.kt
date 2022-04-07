package lab2.shapeCollector

import lab2.colorRGB.ColorRGB

interface ColoredShapeCollector : ShapeCollector{
    fun getShapesByBorderColor(borderColor: ColorRGB)
    fun getShapeByFillColor(fillColor: ColorRGB)
    fun getShapesGroupedByBorderColor()
    fun getShapesGroupedByFillColor()
}