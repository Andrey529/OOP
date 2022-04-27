package lab4.model

import java.io.File


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


class Model(fileWithLabyrinth: File = File("src/main/resources/test.txt")) {
    private val _board = readBoardFromFile(fileWithLabyrinth)

    fun readBoardFromFile(file: File): MutableMap<Pair<Int, Int>, Char> {
        val board = mutableMapOf<Pair<Int, Int>, Char>()
        file.useLines { lines ->
            lines.withIndex().forEach { line ->
                line.value.withIndex().forEach { sumbols ->
                    board.put(Pair(line.index, sumbols.index), sumbols.value)
                }
            }
        }
        return board
    }

    fun printBoard() {
        _board.forEach {
            if (it.key.second == 0 && it.key.first != 0) println()
            print(it.value)
        }
    }
}