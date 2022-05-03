package lab6.shapeCollector

import lab6.colorRGB.ColorRGB
import lab6.shape2d.ColoredShape2d

class ShapeCollectorImpl : ShapeCollector {
    private val shapeList = mutableListOf<ColoredShape2d>()

    override fun addShape(shape: ColoredShape2d) {
        shapeList.add(shape)
    }

    override fun getShapeWithMaxArea(): ColoredShape2d? {
        return shapeList.maxByOrNull { it.calcArea() }
    }

    override fun getShapeWithMinArea(): ColoredShape2d? {
        return shapeList.minByOrNull { it.calcArea() }
    }

    override fun sumAllShapesArea(): Double {
        return shapeList.sumOf { it.calcArea() }
    }

    override fun getShapesByBorderColor(borderColor: ColorRGB): List<ColoredShape2d> {
        return shapeList.filter { it.borderColor == borderColor }
    }

    override fun getShapesByFillColor(fillColor: ColorRGB): List<ColoredShape2d> {
        return shapeList.filter { it.fillColor == fillColor }
    }

    override fun getAllShapes(): List<ColoredShape2d> {
        return shapeList
    }

    override fun getCountShapes(): Int {
        return shapeList.size
    }

    override fun getShapesGroupedByBorderColor(): Map<ColorRGB, List<ColoredShape2d>> {
        return shapeList.groupBy { it.borderColor }
    }

    override fun getShapesGroupedByFillColor(): Map<ColorRGB, List<ColoredShape2d>> {
        return shapeList.groupBy { it.fillColor }
    }

    override fun <T> getShapesByType(type: Class<T>): List<ColoredShape2d> {
        return shapeList.filter { type.isInstance(it) }
    }
}
