
import challengeOne.ResolutionCodeOne
import challengeThree.ResolutionCodeThree
import challengeTwo.ResolutionCodeTwo
import menuScreen.Menu
import kotlin.system.exitProcess


// funcao global para ler as entradas do usuario e checar se e um inteiro
fun readLineInt(): Int {
    var input = readln()
    while (!input.removePrefix("-").all { it in '0'..'9' } || input.isEmpty() ) {
        println("Por favor digite uma opcao valida(apenas numeros)")
        input = readln()
    }
    return input.toInt()
}

fun main(args: Array<String>) {

    val challengeOne = ResolutionCodeOne()
    val challengeTwo = ResolutionCodeTwo()
    val challengeThree = ResolutionCodeThree()
    var endProgram = false
    var stateMenu = Menu()

    //aqui defino o estado do meu programa recebendo o valor de stateselector,
    //e define qual desafio deve ser acessado dado o valor recebido
    while (!endProgram) {
        stateMenu.showMainMenu()
        when (stateMenu.stateSelector()) {
            "0" -> endProgram = true
            "1" -> challengeOne.run()
            "2" -> challengeTwo.run()
            "3" -> challengeThree.run()
        }
    }
    println("Applicacao finalizada")
    exitProcess(0)
}








