package lab6.serialization

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab6.shape2d.quadrilateral.square.NotColoredSquare
import lab6.shape2d.ColoredShape2d
import lab6.shape2d.Shape2d
import lab6.shape2d.circle.ColoredCircle
import lab6.shape2d.circle.NotColoredCircle
import lab6.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab6.shape2d.quadrilateral.rectangle.NotColoredRectangle
import lab6.shape2d.quadrilateral.square.ColoredSquare
import lab6.shape2d.triangle.ColoredTriangle
import lab6.shape2d.triangle.NotColoredTriangle
import lab6.shapeCollector.ShapeCollector
import lab6.shapeCollector.ShapeCollectorImpl
import java.io.File

class Serialization {

    val module = SerializersModule {
        polymorphic(ColoredShape2d::class) {
            subclass(ColoredCircle::class)
            subclass(ColoredSquare::class)
            subclass(ColoredRectangle::class)
            subclass(ColoredTriangle::class)
        }
        polymorphic(Shape2d::class) {
            subclass(NotColoredCircle::class)
            subclass(NotColoredSquare::class)
            subclass(NotColoredRectangle::class)
            subclass(NotColoredTriangle::class)
        }
    }

    private val json = Json {
        prettyPrint = true
        serializersModule = module
    }


    fun serialize(shapecCollector: ShapeCollector) = json.encodeToString(shapecCollector.getAllShapes())

    fun deserialize(encodedString: String): ShapeCollector {
        val shapeCollector = ShapeCollectorImpl()
        val shapesList = json.decodeFromString<List<ColoredShape2d>>(encodedString)
        shapesList.forEach { shapeCollector.addShape(it) }
        return shapeCollector
    }

    fun serializeToFile(shapeCollector: ShapeCollector, file: File) {
        file.writeText(serialize(shapeCollector))
    }

    fun deserializeFromFile(file: File): ShapeCollector? {
        return if (file.exists()) {
            deserialize(file.readText())
        } else {
            null
        }
    }
}