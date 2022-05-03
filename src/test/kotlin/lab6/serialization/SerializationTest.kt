package lab6.serialization

import lab6.shapeCollector.ShapeCollector
import lab6.shapeCollector.ShapeCollectorImpl
import lab6.colorRGB.ColorRGB
import lab6.shape2d.circle.ColoredCircle
import lab6.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab6.shape2d.quadrilateral.square.ColoredSquare
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class SerializationTest {

    private lateinit var shapeCollector: ShapeCollector
    private val serializer: Serialization = Serialization()
    private val fileFrom = File("src/test/kotlin/lab6/serialization/serializeFromTest.json")
    private val fileTo = File("src/test/kotlin/lab6/serialization/serializeToTest.json")


    @BeforeEach
    fun setUp() {
        shapeCollector = ShapeCollectorImpl()
        val shape1 = ColoredCircle(5.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
        val shape2 = ColoredRectangle(4.0, 5.0, ColorRGB(50, 50, 50, 50), ColorRGB(5, 6, 7, 8))
        val shape3 = ColoredSquare(4.0, ColorRGB(100, 100, 100, 100), ColorRGB(9, 10, 11, 12))
        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)
        shapeCollector.addShape(shape3)

    }

    @Test
    fun serialize() {
        val encodedString = serializer.serialize(shapeCollector)
        assertEquals(fileFrom.readText(), encodedString)
    }

    @Test
    fun deserialize() {
        val encodedString = serializer.serialize(shapeCollector)
        val newShapeCollector = serializer.deserialize(encodedString)
        assertEquals(shapeCollector.getAllShapes(), newShapeCollector.getAllShapes())
    }

    @Test
    fun serializeToFile() {
        serializer.serializeToFile(shapeCollector, fileTo)
        assertEquals(serializer.serialize(shapeCollector), fileTo.readText())
    }

    @Test
    fun deserializeFromFile() {
        val newShapeCollector = serializer.deserializeFromFile(fileFrom)
        assertEquals(shapeCollector.getAllShapes(), newShapeCollector!!.getAllShapes())
    }
}