package lab6.serialization

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab2.shape2d.ColoredShape2d
import lab2.shape2d.Shape2d
import lab2.shape2d.circle.ColoredCircle
import lab2.shape2d.circle.NotColoredCircle
import lab2.shape2d.quadrilateral.rectangle.ColoredRectangle
import lab2.shape2d.quadrilateral.rectangle.NotColoredRectangle
import lab2.shape2d.quadrilateral.square.ColoredSquare
import lab2.shape2d.quadrilateral.square.NotColoredSquare
import lab2.shape2d.triangle.ColoredTriangle
import lab2.shape2d.triangle.NotColoredTriangle
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


    fun serialize(shapes: List<ColoredShape2d>): String = json.encodeToString(shapes)

    fun deserialize(encodedString: String): List<ColoredShape2d> = json.decodeFromString(encodedString)
}