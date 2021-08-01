class Solver {
    fun solve(numbers: Array<Array<Int>>): Array<Array<Int>> {
        return numbers
    }

    private fun existEmpty(numbers: Array<Array<Int>>): Boolean {
        numbers.forEach {
            if (it.any { i -> i == 0 }) return true
        }
        return false
    }

    private fun isCorrectBlock(vararg line: Int): Boolean {
        if (line.toSet().size != 9) return false
        if (line.any { it == 0 }) return false
        return true
    }
}