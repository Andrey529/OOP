package lab2.shapeCollector

import lab2.shape2d.Shape2d

interface ShapeCollector {
    fun addShape(shape: Shape2d)
    fun getShapeWithMaxArea() : Shape2d
    fun sumAllShapesArea() : Double
    fun getAllShapes() : List<Shape2d>
    fun getCountShapes() : Int
}

