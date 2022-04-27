package lab4.controller

import lab4.model.State.NOT_YET_WIN
import lab4.model.Model
import lab4.model.Move

class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state == NOT_YET_WIN) {
            try {
                val input = readln().toCharArray()[0]
                val move = when(input) {
                    'a' -> Move.LEFT
                    'w' -> Move.UP
                    'd' -> Move.RIGHT
                    's' -> Move.DOWN
                    else -> Move.STOP
                }
                model.doMove(move)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}