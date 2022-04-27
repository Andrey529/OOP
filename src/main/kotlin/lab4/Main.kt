package lab4

import lab4.controller.Controller
import lab4.model.Model
import lab4.model.Move
import lab4.view.ConsoleUi
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
    ConsoleUi(model)
    Controller(model)


//    model.doMove(Move.RIGHT)
//    model.doMove(Move.DOWN)
//    model.doMove(Move.RIGHT)
//    model.doMove(Move.RIGHT)
//    model.doMove(Move.UP)
//    model.doMove(Move.UP)
//    model.doMove(Move.RIGHT)
//    model.doMove(Move.RIGHT)
//    model.doMove(Move.RIGHT)
//    model.doMove(Move.DOWN)
//    model.doMove(Move.DOWN)
//    model.doMove(Move.RIGHT)
////    model.doMove(Move.RIGHT)

}