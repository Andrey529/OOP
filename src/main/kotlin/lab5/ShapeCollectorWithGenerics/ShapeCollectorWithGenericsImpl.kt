package lab5.ShapeCollectorWithGenerics

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d

class ShapeCollectorWithGenericsImpl<T : ColoredShape2d> : ShapeCollectorWithGenerics<T> {
    private val shapeList = mutableListOf<T>()

    override fun addShape(shape: T) {
        shapeList.add(shape)
    }

    override fun getShapeWithMaxArea(): T? {
        return shapeList.maxByOrNull { it.calcArea() }
    }

    override fun getShapeWithMinArea(): T? {
        return shapeList.minByOrNull { it.calcArea() }
    }

    override fun sumAllShapesArea(): Double {
        return shapeList.sumOf { it.calcArea() }
    }

    override fun getShapesByBorderColor(borderColor: ColorRGB): List<T> {
        return shapeList.filter { it.borderColor == borderColor }
    }

    override fun getShapesByFillColor(fillColor: ColorRGB): List<T> {
        return shapeList.filter { it.fillColor == fillColor }
    }

    override fun getAllShapes(): List<T> {
        return shapeList
    }

    override fun getCountShapes(): Int {
        return shapeList.size
    }

    override fun getShapesGroupedByBorderColor(): Map<ColorRGB, List<T>> {
        return shapeList.groupBy { it.borderColor }
    }

    override fun getShapesGroupedByFillColor(): Map<ColorRGB, List<T>> {
        return shapeList.groupBy { it.fillColor }
    }

    override fun <Ttype : T> getShapesByType(type: Class<Ttype>): List<Ttype> {
        @Suppress("UNCHECKED_CAST")
        return shapeList.filter { type.isInstance(it) } as List<Ttype>
    }

    override fun addAll(collection: Collection<T>) {
        shapeList.addAll(collection)
    }

    override fun getSorted(comparator: Comparator<T>): List<T> {
        return shapeList.sortedWith(comparator)
    }

}