package challengeThree

import java.util.ArrayList

class ResolutionCodeThree {
    private val test: IntArray= intArrayOf(4, 7, 6, 2, 5)
    private val target= 13
    private val uni = combinationSum(test, target)

    public fun run() = println("""
        Dado o vetor com os valores ${test.toList()}
        E o target sendo $target
        Resultado esperado com o menor numero de elementos:
        $uni
    """.trimIndent())

    private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        backtrack(candidates, 0, target, ArrayList(), result)
        return result.filter { it.size <= lowestSize(result) }
    }
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
    private fun lowestSize (result: List<List<Int>>): Int {
        var sizeList = mutableListOf<Int>()
        var minimum = Integer.MAX_VALUE
        for (n in result.indices){
            sizeList.add(result[n].size)
        }
        for (min in sizeList) {
            if (min < minimum) {
                minimum = min
            }
        }
        return minimum
    }
}





