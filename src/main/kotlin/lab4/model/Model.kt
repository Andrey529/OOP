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
    NOT_YET_WIN("Waiting for the move");

    override fun toString(): String = textValue
}

data class Position(var x: Int, var y: Int)

enum class Move(val textValue: String) {
    UP("Up"),
    DOWN("Down"),
    RIGHT("Right"),
    LEFT("Left");

    override fun toString(): String = textValue
}


class Model(fileWithLabyrinth: File = File("src/main/resources/test.txt")) {
    private val _board: MutableMap<Pair<Int, Int>, Char> = readBoardFromFile(fileWithLabyrinth)
    val board: MutableMap<Pair<Int, Int>, Char>
        get() = _board

    private val _startPosition = Position(
        _board.filter { it.value == 'S' }.keys.first().second,
        _board.filter { it.value == 'S' }.keys.first().first
    )

    private val _finishPosition = Position(
        _board.filter { it.value == 'F' }.keys.first().second,
        _board.filter { it.value == 'F' }.keys.first().first
    )

    private var _currentPosition = _startPosition

    var state: State = State.NOT_YET_WIN
    private val _boardHeight = _board.keys.maxOf { it.first }
    private val _boardWidth = _board.keys.maxOf { it.second }

    fun doMove(move: Move) {
        require(state == State.NOT_YET_WIN) { "Labyrinth finished" }
        require((move == Move.LEFT && _currentPosition.x != 0) ||
                (move == Move.RIGHT && _currentPosition.x != _boardWidth) ||
                (move == Move.UP && _currentPosition.y != 0) ||
                (move == Move.DOWN && _currentPosition.y != _boardHeight)) { "It is impossible to make such a move" }

        // update board
        when(move) {
            Move.LEFT -> --_currentPosition.x
            Move.RIGHT -> ++_currentPosition.x
            Move.UP -> --_currentPosition.y
            Move.DOWN -> ++_currentPosition.y
        }

        // check win
        state = if (_currentPosition == _finishPosition) State.WIN else State.NOT_YET_WIN
    }


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
        println()
    }
}