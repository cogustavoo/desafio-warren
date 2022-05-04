package challengeTwo

class ResolutionCodeTwo {
    private var lateStudentsLimit = 0
    private var lateStudents = 0
    private var continueAdd: Boolean = true
    private var studentsTimeCheck: MutableList<Int> = mutableListOf()

    public fun run() {
        readUserData()
        println("Tempo chegada alunos $studentsTimeCheck \n" +
                "Quantidade de alunos atrasados: $lateStudents\n" +
                "Limite de alunos atrasados: $lateStudentsLimit")
        if (lateStudents < lateStudentsLimit) println("Aula normal.") else println("Aula cancelada.")
    }

    private fun readUserData(){
        println("digite a quantidade limite de atrasos: ")
        var input = readLineInt()
        lateStudentsLimit = input
        while (continueAdd) {
            println("Digite o tempo de chegada do aluno: ")
            input = readLineInt()
            studentsTimeCheck.add(input)
            println(
                """Deseja adicionar um novo aluno?"
            1. Sim
            2. Nao
            """.trimIndent()
            )
            input = readLineInt()
            if (input == 2){
                continueAdd = false
            } else continue
        }
        for (late in studentsTimeCheck) {
            if (late > 0) {
                lateStudents++
            }
        }
    }

    private fun readLineInt(): Int {
        var input = readln()
        while (!input.removePrefix("-").all { it in '0'..'9' } || input.isEmpty() ) {
            println("Por favor digite uma opcao valida(apenas numeros)")
            input = readln()
        }
        return input.toInt()
    }
}
