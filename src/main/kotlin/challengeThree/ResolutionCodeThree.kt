package challengeThree
import menuScreen.readLineInt
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

    /*
    passagem parametros para o algoritimo de backtracking e filtragem dos resultados com
    o menor numero de elementos
     */
    private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        backtrack(candidates, 0, target, ArrayList(), result)
        return result.filter { it.size <= lowestSize(result) }
    }

    // implementacao do algoritimo de backtracking
    private fun backtrack(
        vector: IntArray,
        start: Int,
        target: Int,
        list: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target < 0) return
        if (target == 0) result.add(ArrayList(list))
        for (i in start until vector.size) {
            list.add(vector[i])
            backtrack(vector, i, target - vector[i], list, result)
            list.removeAt(list.size - 1)
        }
    }

    //funcao para checar os resultados com o menor numero de elementos
    private fun lowestSize(result: List<List<Int>>): Int {
        val sizeList = mutableListOf<Int>()
        var minimum = Integer.MAX_VALUE
        for (n in result.indices) {
            sizeList.add(result[n].size)
        }
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
        var input = readLineInt()
        target = input
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
        vectorArray = vectorList.toIntArray()
    }
}





