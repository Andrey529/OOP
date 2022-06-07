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
    private val _board: MutableMap<Position, Cell> = readBoardFromFile(fileWithLabyrinth)
    val board: MutableMap<Position, Cell>
        get() = _board

    private val _startPosition = Position(
        _board.filter { it.value == Cell.START }.keys.first().y,
        _board.filter { it.value == Cell.START }.keys.first().x
    )

    private val _finishPosition = Position(
        _board.filter { it.value == Cell.FINISH }.keys.first().y,
        _board.filter { it.value == Cell.FINISH }.keys.first().x
    )

    private var _currentPosition = _startPosition

    var state: State = State.NOT_YET_WIN
    private val _boardHeight = _board.keys.maxOf { it.x }
    private val _boardWidth = _board.keys.maxOf { it.y }

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
            (move == Move.LEFT && (_board[Position(_currentPosition.y, _currentPosition.x - 1)] == Cell.WAY ||
                    _board[Position(_currentPosition.y, _currentPosition.x - 1)] == Cell.START ||
                    _board[Position(_currentPosition.y, _currentPosition.x - 1)] == Cell.FINISH)
                    ) ||
                    (move == Move.RIGHT && (_board[Position(_currentPosition.y, _currentPosition.x + 1)] == Cell.WAY ||
                            _board[Position(_currentPosition.y, _currentPosition.x + 1)] == Cell.START ||
                            _board[Position(_currentPosition.y, _currentPosition.x + 1)] == Cell.FINISH)
                            ) ||
                    (move == Move.UP && (_board[Position(_currentPosition.y - 1, _currentPosition.x)] == Cell.WAY ||
                            _board[Position(_currentPosition.y - 1, _currentPosition.x)] == Cell.START ||
                            _board[Position(_currentPosition.y - 1, _currentPosition.x)] == Cell.FINISH)
                            ) ||
                    (move == Move.DOWN && (_board[Position(_currentPosition.y + 1, _currentPosition.x)] == Cell.WAY ||
                            _board[Position(_currentPosition.y + 1, _currentPosition.x)] == Cell.START ||
                            _board[Position(_currentPosition.y + 1, _currentPosition.x)] == Cell.FINISH)
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


    fun readBoardFromFile(file: File): MutableMap<Position, Cell> {
        val board = mutableMapOf<Position, Cell>()
        file.useLines { lines ->
            lines.withIndex().forEach { line ->
                line.value.withIndex().forEach { sumbols ->
                    board.put(Position(line.index, sumbols.index), when(sumbols.value) {
                        'S' -> Cell.START
                        'F' -> Cell.FINISH
                        '#' -> Cell.WALL
                        '-' -> Cell.WAY
                        else -> Cell.WALL
                    })
                }
            }
        }
        return board
    }

    override fun toString(): String {
        return buildString {
            append(state).appendLine()

            for (i in 0.._boardHeight) {
                for (j in 0.._boardWidth) {
                    if (i == _currentPosition.y && j == _currentPosition.x)
                        append('P')
                    else
                        append(_board[Position(i, j)])
                }
                appendLine()
            }

        }
    }
}