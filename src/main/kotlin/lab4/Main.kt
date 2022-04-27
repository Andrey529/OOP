package lab4

import lab4.model.Model
import lab4.model.Move
import java.io.File

/*
    ########
    ###----#
    S-#-##-#
    #---##-F
    ########
*/

fun main(args: Array<String>) {

    val model = Model()
    model.printBoard()

    model.doMove(Move.RIGHT)
    model.doMove(Move.DOWN)
    model.doMove(Move.RIGHT)
    model.doMove(Move.RIGHT)
    model.doMove(Move.UP)
    model.doMove(Move.UP)
    model.doMove(Move.RIGHT)
    model.doMove(Move.RIGHT)
    model.doMove(Move.RIGHT)
    model.doMove(Move.DOWN)
    model.doMove(Move.DOWN)
    model.doMove(Move.RIGHT)
//    model.doMove(Move.RIGHT)

}