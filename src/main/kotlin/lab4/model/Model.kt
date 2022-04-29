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
    LEFT("Left"),
    STOP("Stop");

    override fun toString(): String = textValue
}

interface ModelChangeListener {
    fun onModelChanged()
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

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    fun doMove(move: Move) {
        require(state == State.NOT_YET_WIN) { "Labyrinth finished" }

        // border collision test
        require(
            (move == Move.LEFT && _currentPosition.x != 0) ||
                    (move == Move.RIGHT && _currentPosition.x != _boardWidth) ||
                    (move == Move.UP && _currentPosition.y != 0) ||
                    (move == Move.DOWN && _currentPosition.y != _boardHeight)
        ) { "It is impossible to make such a move" }

        // wall collision test
        require(
            (move == Move.LEFT && (_board[Pair(_currentPosition.y, _currentPosition.x - 1)] == '-' ||
                    _board[Pair(_currentPosition.y, _currentPosition.x - 1)] == 'S' ||
                    _board[Pair(_currentPosition.y, _currentPosition.x - 1)] == 'F')
                    ) ||
                    (move == Move.RIGHT && (_board[Pair(_currentPosition.y, _currentPosition.x + 1)] == '-' ||
                            _board[Pair(_currentPosition.y, _currentPosition.x + 1)] == 'S' ||
                            _board[Pair(_currentPosition.y, _currentPosition.x + 1)] == 'F')
                            ) ||
                    (move == Move.UP && (_board[Pair(_currentPosition.y - 1, _currentPosition.x)] == '-' ||
                            _board[Pair(_currentPosition.y - 1, _currentPosition.x)] == 'S' ||
                            _board[Pair(_currentPosition.y - 1, _currentPosition.x)] == 'F')
                            ) ||
                    (move == Move.DOWN && (_board[Pair(_currentPosition.y + 1, _currentPosition.x)] == '-' ||
                            _board[Pair(_currentPosition.y + 1, _currentPosition.x)] == 'S' ||
                            _board[Pair(_currentPosition.y + 1, _currentPosition.x)] == 'F')
                            )
        ) { "It is impossible to make such a move" }

        // update board
        when (move) {
            Move.LEFT -> --_currentPosition.x
            Move.RIGHT -> ++_currentPosition.x
            Move.UP -> --_currentPosition.y
            Move.DOWN -> ++_currentPosition.y
            else -> return
        }

        // check win
        state = if (_currentPosition == _finishPosition) State.WIN else State.NOT_YET_WIN

        notifyListeners()
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

    override fun toString(): String {
        return buildString {
            append(state).appendLine()

            for (i in 0.._boardHeight) {
                for (j in 0.._boardWidth) {
                    if (i == _currentPosition.y && j == _currentPosition.x)
                        append('P')
                    else
                        append(_board[Pair(i, j)])
                }
                appendLine()
            }

        }
    }
}