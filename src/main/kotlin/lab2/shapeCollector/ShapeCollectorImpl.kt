package lab2.shapeCollector

import lab2.shape2d.Shape2d

class NotColoredShapeCollectorImpl : ShapeCollector {
    private var shapeList  = emptyList<Shape2d>() as MutableList<Shape2d>

    override fun addShape(shape: Shape2d) {
        shapeList.add(shape)
    }

    override fun getShapeWithMaxArea(): Shape2d {
        TODO("Not yet implemented")
    }

    override fun sumAllShapesArea(): Double {
        TODO("Not yet implemented")
    }

    override fun getAllShapes(): List<Shape2d> {
        TODO("Not yet implemented")
    }

    override fun getCountShapes(): Int {
        TODO("Not yet implemented")
    }


}

//class NotColoredShapeCollectorImpl : ColoredShapeCollector