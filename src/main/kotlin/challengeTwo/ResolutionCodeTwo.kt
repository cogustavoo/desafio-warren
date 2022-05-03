package challengeTwo

class ResolutionCodeTwo {

    public fun print() = println("${readUserData()} \n")

    private fun readUserData(){
        var lateStudents = 0
        val classContinues = false
        var continueAdd: Boolean = true
        var studentsTimeCheck: MutableList<Int> = mutableListOf()

        println("digite a quantidade limite de atrasos: ")
        val lateStudentsLimit = readLineInt()
        while (continueAdd) {
            println("Digite o tempo de chegada do aluno: ")
            var input = readLineInt()
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
        val classResult = println("Tempo chegada alunos $studentsTimeCheck \n" +
                "Quantidade de alunos atrasados: $lateStudents\n" +
                "Limite de alunos atrasados: $lateStudentsLimit"
        )
        if (lateStudents < lateStudentsLimit) println("Aula normal.") else println("Aula cancelada.")

        return classResult
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
