package lab4

import lab4.controller.Controller
import lab4.model.Model
import lab4.view.ConsoleUi

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

}