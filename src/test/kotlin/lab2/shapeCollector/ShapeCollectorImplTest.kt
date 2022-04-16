package lab2.shapeCollector

import lab2.colorRGB.ColorRGB
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.circle.ColoredCircle
import lab2.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab2.shape2d.quadrilateral.square.ColoredSquare
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorImplTest {

    private lateinit var shapeCollector: ShapeCollector

    @BeforeEach
    fun setUp() {
        shapeCollector = ShapeCollectorImpl()
    }

    @Test
    fun addShape() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredCircle(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        assertEquals(3, shapeCollector.getCountShapes())
    }

    @Test
    fun getShapeWithMaxAreaInEmptyShapeCollector() {
        assertNull(shapeCollector.getShapeWithMaxArea())
    }

    @Test
    fun getShapeWithMaxAreaInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        assertNotNull(shapeCollector.getShapeWithMaxArea())
        assertEquals(
            ColoredSquare(
                3.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapeCollector.getAllShapes()[2]
        )
    }

    @Test
    fun getShapeWithMinAreaInEmptyShapeCollector() {
        assertNull(shapeCollector.getShapeWithMinArea())
    }

    @Test
    fun getShapeWithMinAreaInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        assertNotNull(shapeCollector.getShapeWithMinArea())
        assertEquals(
            ColoredSquare(
                1.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapeCollector.getAllShapes()[0]
        )
    }

    @Test
    fun sumAllShapesAreaInEmptyShapeCollector() {
        assertEquals(0.0, shapeCollector.sumAllShapesArea())
    }

    @Test
    fun sumAllShapesAreaInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        assertEquals(14.0, shapeCollector.sumAllShapesArea())
    }

    @Test
    fun getShapesByBorderColorInEmptyShapeCollector() {
        val shapesWithUniqueBorderColor = shapeCollector.getShapesByBorderColor(ColorRGB(1, 2, 3, 4))
        assertEquals(0, shapesWithUniqueBorderColor.size)
    }

    @Test
    fun getShapesByBorderColorInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        val shapesWithUniqueBorderColor = shapeCollector.getShapesByBorderColor(ColorRGB(5, 6, 7, 8))
        assertEquals(3, shapesWithUniqueBorderColor.size)
        assertEquals(
            ColoredSquare(
                1.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueBorderColor[0]
        )
        assertEquals(
            ColoredSquare(
                2.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueBorderColor[1]
        )
        assertEquals(
            ColoredSquare(
                3.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueBorderColor[2]
        )

    }

    @Test
    fun getShapesByFillColorInEmptyShapeCollector() {
        val shapesWithUniqueFillColor = shapeCollector.getShapesByFillColor(ColorRGB(1, 2, 3, 4))
        assertEquals(0, shapesWithUniqueFillColor.size)
    }

    @Test
    fun getShapesByFillColorInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        val shapesWithUniqueFillColor = shapeCollector.getShapesByFillColor(ColorRGB(1, 2, 3, 4))
        assertEquals(3, shapesWithUniqueFillColor.size)
        assertEquals(
            ColoredSquare(
                1.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueFillColor[0]
        )
        assertEquals(
            ColoredSquare(
                2.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueFillColor[1]
        )
        assertEquals(
            ColoredSquare(
                3.0,
                ColorRGB(1, 2, 3, 4),
                ColorRGB(5, 6, 7, 8)
            ), shapesWithUniqueFillColor[2]
        )
    }

    @Test
    fun getAllShapesInEmptyShapeCollector() {
        val allShapes = shapeCollector.getAllShapes()
        assertEquals(0, allShapes.size)
    }

    @Test
    fun getAllShapesInNotEmptyShapeCollector() {
        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        val listForTest = listOf<ColoredShape2d>(
            ColoredSquare(1.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8)),
            ColoredSquare(2.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8)),
            ColoredSquare(3.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        )

        assertEquals(listForTest, shapeCollector.getAllShapes())
    }

    @Test
    fun getCountShapes() {
        assertEquals(0, shapeCollector.getCountShapes())

        for (i in 1..3) {
            shapeCollector.addShape(
                ColoredSquare(
                    i.toDouble(),
                    ColorRGB(1, 2, 3, 4),
                    ColorRGB(5, 6, 7, 8)
                )
            )
        }

        assertEquals(3, shapeCollector.getCountShapes())
    }

    @Test
    fun getShapesGroupedByBorderColorInEmptyShapeCollector() {
        val mapShapes = shapeCollector.getShapesGroupedByBorderColor()
        assertEquals(0, mapShapes.size)
    }

    @Test
    fun getShapesGroupedByBorderColorInNotEmptyShapeCollector() {
        val shape1 = ColoredCircle(5.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        val shape2 = ColoredRectangle(4.0, 5.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        val shape3 = ColoredSquare(4.0, ColorRGB(1, 2, 3, 4), ColorRGB(9, 10, 11, 12))
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        val mapShapes = shapeCollector.getShapesGroupedByBorderColor()
        assertEquals(2, mapShapes.size)

        assertEquals(listOf(shape1, shape2), mapShapes[ColorRGB(5, 6, 7, 8)])
        assertEquals(listOf(shape3), mapShapes[ColorRGB(9, 10, 11, 12)])
    }

    @Test
    fun getShapesGroupedByFillColorInEmptyShapeCollector() {
        val mapShapes = shapeCollector.getShapesGroupedByFillColor()
        assertEquals(0, mapShapes.size)
    }

    @Test
    fun getShapesGroupedByFillColorInNotEmptyShapeCollector() {
        val shape1 = ColoredCircle(5.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        val shape2 = ColoredRectangle(4.0, 5.0, ColorRGB(50, 50, 50, 50), ColorRGB(5, 6, 7, 8))
        val shape3 = ColoredSquare(4.0, ColorRGB(100, 100, 100, 100), ColorRGB(9, 10, 11, 12))
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

        val mapShapes = shapeCollector.getShapesGroupedByFillColor()
        assertEquals(3, mapShapes.size)

        assertEquals(listOf(shape1), mapShapes[ColorRGB(1, 2, 3, 4)])
        assertEquals(listOf(shape2), mapShapes[ColorRGB(50, 50, 50, 50)])
        assertEquals(listOf(shape3), mapShapes[ColorRGB(100, 100, 100, 100)])
    }

    @Test
    fun getShapesByTypeInEmptyShapeCollector() {
        assertEquals(0, shapeCollector.getShapesByType(ColoredCircle::class.java).size)
    }

    @Test
    fun getShapesByTypeInNotEmptyShapeCollector() {
        val shape1 = ColoredCircle(5.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        val shape2 = ColoredRectangle(4.0, 5.0, ColorRGB(50, 50, 50, 50), ColorRGB(5, 6, 7, 8))
        val shape3 = ColoredSquare(4.0, ColorRGB(100, 100, 100, 100), ColorRGB(9, 10, 11, 12))
        val shape4 = ColoredSquare(4.0, ColorRGB(100, 100, 100, 100), ColorRGB(9, 10, 11, 12))


        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)
        shapeCollector.addShape(shape4)

        assertEquals(listOf(shape1), shapeCollector.getShapesByType(ColoredCircle::class.java))
        assertEquals(listOf(shape2), shapeCollector.getShapesByType(ColoredRectangle::class.java))
        assertEquals(listOf(shape3, shape4), shapeCollector.getShapesByType(ColoredSquare::class.java))
    }
}