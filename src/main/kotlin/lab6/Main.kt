package lab6

//import kotlinx.serialization.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab6.colorRGB.ColorRGB
import lab6.shape2d.circle.ColoredCircle
import lab6.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab6.shape2d.quadrilateral.square.ColoredSquare
import lab6.serialization.Serialization
import lab6.shape2d.ColoredShape2d
import lab6.shape2d.Shape2d
import lab6.shape2d.circle.NotColoredCircle
import lab6.shape2d.quadrilateral.rectangle.NotColoredRectangle
import lab6.shape2d.quadrilateral.square.NotColoredSquare
import lab6.shape2d.triangle.ColoredTriangle
import lab6.shape2d.triangle.NotColoredTriangle
import lab6.shapeCollector.ShapeCollector
import lab6.shapeCollector.ShapeCollectorImpl
import java.io.File


fun main(args: Array<String>) {

    val serializer = Serialization()

    val shapeCollector = serializer.deserializeFromFile(File("src/main/kotlin/lab6/serializeFrom.json"))

    val shape1 = ColoredTriangle(5.0, 4.0, 3.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
    val shape2 = ColoredTriangle(5.0, 6.0, 7.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))

    if (shapeCollector != null) {
        val encodedString = serializer.serialize(shapeCollector)
        println(encodedString)

        shapeCollector.addShape(shape1)
        shapeCollector.addShape(shape2)

        serializer.serializeToFile(shapeCollector, File("src/main/kotlin/lab6/serializeTo.json"))

        val newShapeCollector = serializer.deserializeFromFile(File("src/main/kotlin/lab6/serializeTo.json"))
        if (newShapeCollector != null) {
            println(serializer.serialize(newShapeCollector))
        }
    }

}