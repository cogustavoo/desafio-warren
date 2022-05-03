package menuScreen


class Menu {

    private fun errorMessage() = println("Por favor digite uma opcao valida (Apenas numeros)")

    fun showMainMenu (){
        val menuText = """
        Selecione a opcao desejada para acessar a resolucao de cada desafio.
        1. Desafio 1
        2. Desafio 2  
        3. Desafio 3 
        0. FINALIZAR
        
        Opcao: 
    """.trimIndent()

        println(menuText)
    }

    fun stateSelector(): Any {
        var input = readLine()

        val state = when (input) {
            "1" ->  "1"
            "2" ->  "2"
            "3" ->  "3"
            "0" ->  "0"
            else -> println(errorMessage())
        }
        return state
    }
}