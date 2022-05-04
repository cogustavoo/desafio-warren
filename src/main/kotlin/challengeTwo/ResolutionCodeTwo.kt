package challengeTwo

import menuScreen.readLineInt

class ResolutionCodeTwo {
    private var onTimeStudentsValue = 0
    private var onTimeStudents = 0
    private var continueAdd: Boolean = true
    private var studentsTimeCheck: MutableList<Int> = mutableListOf()
    /*
    funcao para executar o codigo atravez do menu principal
     e definir a aula como normal ou cancelada, atravez dos dados coletados
     */
    fun run() {
        readUserData()
        println(
            "Tempo chegada alunos $studentsTimeCheck \n" +
            "Quantidade de alunos presentes: $onTimeStudents\n" +
            "Quantidade minima de alunos presentes: $onTimeStudentsValue \n"
        )
        if (onTimeStudents >= onTimeStudentsValue) println("Aula normal.")
            else println("Aula cancelada.\n")
        studentsTimeCheck.clear()
    }

    private fun readUserData() {
        println("digite a quantidade limite de atrasos: ")
        var input = readLineInt()
        onTimeStudentsValue = input
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
            if (input == 2) {
                continueAdd = false
            } else continue
        }
        //checagem de quantos alunos estao presentes
        for (present in studentsTimeCheck) {
            if (present <= 0) {
                onTimeStudents++
            }
        }
    }
}
