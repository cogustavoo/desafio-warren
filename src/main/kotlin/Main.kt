
import challengeOne.ResolutionCodeOne
import challengeTwo.ResolutionCodeTwo
import menuScreen.Menu
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val challengeOne = ResolutionCodeOne()
    val challengeTwo = ResolutionCodeTwo()
    var endProgram = false
    var stateMenu = Menu()

    while (!endProgram) {
        stateMenu.showMainMenu()
        when (stateMenu.stateSelector()) {
            "0" -> endProgram = true
            "1" -> challengeOne.print()
            "2" -> challengeTwo.print()
        }
    }
    println("Applicacao finalizada")
    exitProcess(0)
}







