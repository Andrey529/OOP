package lab6.serialization

import lab2.shapeCollector.ShapeCollector
import lab2.shapeCollector.ShapeCollectorImpl
import lab2.colorRGB.ColorRGB
import lab2.shape2d.circle.ColoredCircle
import lab2.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab2.shape2d.quadrilateral.square.ColoredSquare
import lab6.serializationWithFiles.SerializationWithFiles
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class SerializationTest {

    private lateinit var shapeCollector: ShapeCollector
    private val serializer: Serialization = Serialization()
    private val serializerWithFiles = SerializationWithFiles()
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
        val encodedString = serializer.serialize(shapeCollector.getAllShapes())
        assertEquals(fileFrom.readText(), encodedString)
    }

    @Test
    fun deserialize() {
        val encodedString = serializer.serialize(shapeCollector.getAllShapes())
        val newShapesList = serializer.deserialize(encodedString)
        assertEquals(shapeCollector.getAllShapes(), newShapesList)
    }

    @Test
    fun serializeToFile() {
        serializerWithFiles.serializeToFile(shapeCollector.getAllShapes(), fileTo)
        assertEquals(serializer.serialize(shapeCollector.getAllShapes()), fileTo.readText())
    }

    @Test
    fun deserializeFromFile() {
        val newShapesList = serializerWithFiles.deserializeFromFile(fileFrom)
        assertEquals(shapeCollector.getAllShapes(), newShapesList)
    }
}