package challengeOne

class ResolutionCodeOne {

    public fun run() = println("${oddNumBellowOneMill()} \n")

    private fun oddNumBellowOneMill(): MutableList<Int> {
        var number= 0
        val numbersStorage = mutableListOf<Int>()
        val tests = mutableListOf<Array<Int>>()
        var counter = 0
        val limiter = 1000000

        while (number < limiter) {
            val reverseNumber = number.toString().reversed()
            if (number > 0 && !reverseNumber.startsWith("0") && isAllOdd(number, reverseNumber.toInt())) {
                numbersStorage.add(number)
                counter ++
            }
            number++
        }
        println("Quantidade de numeros no intervalo '0' .. '$limiter': $counter")
        return numbersStorage
    }

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

