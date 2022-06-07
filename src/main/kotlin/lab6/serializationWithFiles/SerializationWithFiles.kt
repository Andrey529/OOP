package lab6.serializationWithFiles

import lab2.shape2d.ColoredShape2d
import lab6.serialization.*
import java.io.File

class SerializationWithFiles {

    private val serializer = Serialization()

    fun serializeToFile(shapes: List<ColoredShape2d>, file: File) {
        file.writeText(serializer.serialize(shapes))
    }

    fun deserializeFromFile(file: File): List<ColoredShape2d>? {
        return if (file.exists()) {
            serializer.deserialize(file.readText())
        } else {
            null
        }
    }
}