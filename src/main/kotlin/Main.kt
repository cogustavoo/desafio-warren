
import challengeOne.ResolutionCodeOne
import challengeThree.ResolutionCodeThree
import challengeTwo.ResolutionCodeTwo
import menuScreen.Menu
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val challengeOne = ResolutionCodeOne()
    val challengeTwo = ResolutionCodeTwo()
    val challengeThree = ResolutionCodeThree()
    var endProgram = false
    var stateMenu = Menu()

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







