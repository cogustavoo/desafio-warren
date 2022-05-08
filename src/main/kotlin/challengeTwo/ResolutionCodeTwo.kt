package challengeTwo

import readLineInt

class ResolutionCodeTwo {
    private var onTimeStudents = 0
    private var onTimeStudentsQuantity = 0
    private var continueAdd: Boolean = true
    private var studentsTimeCheck: MutableList<Int> = mutableListOf()
    /*
    funcao para executar o codigo atravez do menu principal
     e tambem definir a aula como normal ou cancelada caso a quantidade de alunos presentes
     seja menor que o limite
     */
    fun run() {
        readUserData()
        println(
            "Tempo chegada alunos $studentsTimeCheck \n" +
            "Quantidade de alunos presentes: $onTimeStudentsQuantity\n" +
            "Quantidade minima de alunos presentes: $onTimeStudents \n"
        )
        if (onTimeStudentsQuantity >= onTimeStudents) println("Aula normal.")
            else println("Aula cancelada.\n")
        studentsTimeCheck.clear()
    }

    private fun readUserData() {
        println("digite a quantidade limite de atrasos: ")
        //No input utilizo uma funcao criada no Main para receber apenas numeros
        var input = readLineInt()
        onTimeStudents = input
        /*
       loop para o usuario continuar adicionando o tempo de chegada dos alunos
       ate o limite definido pelo usuario
        */
        while (continueAdd) {
            println("Digite o tempo de chegada do aluno: ")
            input = readLineInt()
            //adiciona as entradas a lista contendo os tempos de chegada
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
        //percorre a lista de alunos verificando o horario de chegada
        //definindo quantos estao presentes no inicio da aula
        for (present in studentsTimeCheck) {
            if (present <= 0) {
                onTimeStudentsQuantity++
            }
        }
    }
}
