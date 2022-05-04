
package challengeOne

class ResolutionCodeOne {
    private var number = 0
    private val numbersStorage = mutableListOf<Int>()
    private var counter = 0
    private val limiter = 1000000

    //funcao para executar o codigo atravez do menu principal
    fun run() = println(
        """
        "Quantidade de numeros no intervalo '0' .. '$limiter': $counter"
        ${oddNumBellowOneMill()}
        """.trimIndent()
    )
    // funcao para checar todos os numeros no range 0..1000000, que satisfazem as condicoes impostas
    private fun oddNumBellowOneMill(): MutableList<Int> {
        while (number < limiter) {
            val reverseNumber = number.toString().reversed()
            if (number > 0 && !reverseNumber.startsWith("0") && isAllOdd(
                    number,
                    reverseNumber.toInt())
            ) {
                numbersStorage.add(number)
                counter++
            }
            number++
        }
        return numbersStorage
    }

    /*
     funcao para checar se todos os numeros de n + reverso(n) sao impares.
     Separando o Int atravez da utilizacao do %, coloco todos em uma lista
     verificando cada elemento separadamente
     */
    private fun isAllOdd(number: Int, reverseNumber: Int): Boolean {
        var allOdd = true
        val checkEvenList = mutableListOf<Int>()
        var digits = number + reverseNumber
        while (digits > 0) {
            checkEvenList.add(digits % 10)
            digits /= 10
        }
        for (n in checkEvenList) if (n % 2 == 0) allOdd = false
        return allOdd
    }
}

