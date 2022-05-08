package challengeThree
import readLineInt
import java.util.ArrayList

class ResolutionCodeThree {
    private lateinit var vectorArray: IntArray
    private var vectorList: MutableList<Int> = mutableListOf()
    private var target = 0

    //funcao para executar o codigo atravez do menu principal
    fun run() {
        readUserData()
        combinationSum(vectorArray, target)
        println(
            """
        Dado o vetor com os valores: $vectorList
        E o target sendo: $target
        Resultado esperado com o menor numero de elementos:
        ${combinationSum(vectorArray, target)}
    """.trimIndent()
        )
        vectorList.clear()
    }


    private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        //chamada a funcao backtrack
        backtrack(candidates, 0, target, ArrayList(), result)
        //retorna a lista dos resultado filtrados apenas com os de menor numero de elementos
        return result.filter { it.size <= lowestSize(result) }
    }
    //aqui recebo, o array, target o inicio do index, uma lista para funcionamento da funcao
    //e uma lista vazia para armazenar os resultados.
    private fun backtrack(
        vector: IntArray,
        start: Int,
        target: Int,
        list: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        //Se a soma dos elementos no vetor for menor que 0 ele retorna um no de repeticao
        if (target < 0) return
        // Sempre que o resultado da soma dos elementos no vetor corresponder ao 'n',
        // o numero sera adicionado a lista de resultados corretos
        if (target == 0) result.add(ArrayList(list))
        /*
        Aqui foi utilizado uma chamada recursiva, onde testo todos os valores
        possíveis em determinado índex do vetor, adicionando o valor do index repetidamente
        até entrar em uma das condicionais, caso o número seja negativo, ira retornar um nó
        e deletar o último valor adicionado, seguindo para o próximo index,
        caso o target se iguale a 0 ira adicionar o vetor dentro de uma lista, sendo esse o target
        desejado, seguindo para o próximo índex, tentando achar novas combinações até esgotar
        todas as possibilidades
        */
        for (i in start until vector.size) {
            list.add(vector[i])
            backtrack(vector, i, target - vector[i], list, result)
            list.removeAt(list.size - 1)
        }
    }

    //define os resultados com a menor quantidade de elementos
    private fun lowestSize(result: List<List<Int>>): Int {
        val sizeList = mutableListOf<Int>()
        var minimum = Integer.MAX_VALUE
        //passa por toda a lista e guarda o size das respectivas posicoes
        for (n in result.indices) {
            sizeList.add(result[n].size)
        }
        //percorre a lista dos sizes e guarda o menor valor em minimum
        for (min in sizeList) {
            if (min < minimum) {
                minimum = min
            }
        }
        return minimum
    }

    //coleta de dados do usuario, a atribuicao dos valores ao array que sera utilizado no backtracking
    private fun readUserData() {
        var continueAdd: Boolean = true
        println("Digite um valor target: ")
        //No input utilizo uma funcao criada no Main para receber apenas numeros
        var input = readLineInt()
        target = input
        /*
        recebe um boolean true, caso usuario nao queira mais adicionar valores o torna false
        assim saindo do loop
         */
        while (continueAdd) {
            println("Digite um valor para o vetor: ")
            input = readLineInt()
            vectorList.add(input)
            println(
                """
                Deseja adicionar um novo valor?
                1. Sim
                2. Nao
                """.trimIndent()
            )
            input = readLineInt()
            if (input == 2) {
                continueAdd = false
            }
        }
        vectorArray = vectorList.toIntArray() //
    }
}





