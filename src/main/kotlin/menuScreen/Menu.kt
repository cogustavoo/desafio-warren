package menuScreen

// funcao global para ler as entradas do usuario e checar se e um inteiro
fun readLineInt(): Int {
    var input = readln()
    while (!input.removePrefix("-").all { it in '0'..'9' } || input.isEmpty() ) {
        println("Por favor digite uma opcao valida(apenas numeros)")
        input = readln()
    }
    return input.toInt()
}

class Menu {

    private fun errorMessage() = println("Por favor digite uma opcao valida (Apenas numeros)")

    fun showMainMenu() {
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
        val state = when (readLine()) {
            "1" -> "1"
            "2" -> "2"
            "3" -> "3"
            "0" -> "0"
            else -> println(errorMessage())
        }
        return state
    }
}