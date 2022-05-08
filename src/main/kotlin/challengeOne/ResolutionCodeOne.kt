
package challengeOne

class ResolutionCodeOne {
    private var number = 0
    private val numbersStorage = mutableListOf<Int>()
    private var counter = 0
    private val limiter = 1000000
    /*
    funcao para executar o codigo atravez do menu principal.
    Retornando a quantidade de numeros no range 0..1000000
    como tambem a lista dos numeros nesse range atravez da funcao oddNumBellowOneMill()
    onde checa todos os numeros no range 0..1000000, que satisfazem as condicoes impostas no desafio
    */
    fun run() = println(
        """
        "Quantidade de numeros no intervalo '0' .. '$limiter': $counter"
        ${oddNumBellowOneMill()}
        """.trimIndent()
    )

    private fun oddNumBellowOneMill(): MutableList<Int> {
        while (number < limiter) {
            /*
            utilizo das funcoes toString() e reversed() para gerar o reverso(n)
             */
            val reverseNumber = number.toString().reversed()
            /*
            verifica se n > 0, reverso inicia com '0' e todos sao impares.
            adiciona 'n' na lista caso positivo, incrimentando  'n' ate o limite imposto,
            retornando a lista ao final
             */
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

    private fun isAllOdd(number: Int, reverseNumber: Int): Boolean {
        var allOdd = true
        val checkEvenList = mutableListOf<Int>()
        var digits = number + reverseNumber
        // Separacao do Int atravez da utilizacao do resto(%), colocando todos em uma lista
        while (digits > 0) {
            checkEvenList.add(digits % 10)
            digits /= 10
        }
        //Recebe a lista e checa se todos os elementos sao impares
        for (n in checkEvenList) if (n % 2 == 0) allOdd = false
        return allOdd
    }
}

