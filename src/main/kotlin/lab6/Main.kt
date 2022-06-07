package lab6

import lab2.colorRGB.ColorRGB
import lab2.shape2d.triangle.ColoredTriangle
import lab2.shapeCollector.*
import lab6.serialization.Serialization
import lab6.serializationWithFiles.SerializationWithFiles
import java.io.File


fun main(args: Array<String>) {

    val serializer = Serialization()
    val serializerWithFiles = SerializationWithFiles()

    val shapeCollector = ShapeCollectorImpl()

    val listShapes = serializerWithFiles.deserializeFromFile(File("src/main/kotlin/lab6/serializeFrom.json"))
    listShapes?.forEach { shapeCollector.addShape(it) }


    val shape1 = ColoredTriangle(5.0, 4.0, 3.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))
    val shape2 = ColoredTriangle(5.0, 6.0, 7.0, ColorRGB(1, 2, 3, 4), ColorRGB(5, 6, 7, 8))

    val encodedString = serializer.serialize(shapeCollector.getAllShapes())
    println(encodedString)

    shapeCollector.addShape(shape1)
    shapeCollector.addShape(shape2)

    serializerWithFiles.serializeToFile(shapeCollector.getAllShapes(), File("src/main/kotlin/lab6/serializeTo.json"))

    val newShapesList = serializerWithFiles.deserializeFromFile(File("src/main/kotlin/lab6/serializeTo.json"))
    if (newShapesList != null) {
        println(serializer.serialize(newShapesList))
    }

}