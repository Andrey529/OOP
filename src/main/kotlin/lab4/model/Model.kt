package lab4.model

enum class Cell(private val textValue: String) {
    WALL("#"),
    WAY("-"),
    START("S"),
    FINISH("F");

    override fun toString(): String = textValue
}

enum class State(val textValue: String) {
    WIN("Labyrinth finished. Congrats!!!"),
    NOT_YET_WIN("Waiting for the move")
}

class Model {
//    private val _board: MutableMap =
}