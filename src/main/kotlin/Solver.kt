class Solver(private val numbers: Array<Array<Int>>) {
    fun solve(): Boolean {
        return findEmpty().let {
            if (it == null) false
            else calc(it.first, it.second)
        }
    }

    private fun calc(x: Int, y: Int): Boolean {
        numbers[x][y] = -1
        if (existEmpty()) {
            val (i, j) = findEmpty()!!
            searchUnusedNumbers(x, y).forEach {
                numbers[x][y] = it
                if (calc(i, j)) return true
            }
        } else {
            searchUnusedNumbers(x, y).forEach {
                numbers[x][y] = it
                if (isCorrect()) return true
            }
        }
        numbers[x][y] = 0
        return false
    }

    private fun existEmpty(): Boolean {
        numbers.forEach {
            if (it.any { i -> i == 0 }) return true
        }
        return false
    }

    private fun searchUnusedNumbers(x: Int, y: Int): Set<Int> {
        val set = (1..9).toMutableSet()
        for (i in 0..8) {
            if (numbers[x][i] != 0) set.remove(numbers[x][i])
            if (numbers[i][y] != 0) set.remove(numbers[i][y])

            val p = x / 3
            val q = y / 3
            for (n in 0..2)
                for (m in 0..2)
                    if (numbers[p * 3 + n][q * 3 + m] != 0) set.remove(numbers[p * 3 + n][q * 3 + m])
        }
        return set
    }

    private fun findEmpty(): Pair<Int, Int>? {
        for (i in 0..8) {
            for (j in 0..8) {
                if (numbers[i][j] == 0) {
                    return Pair(i, j)
                }
            }
        }
        return null
    }

    private fun isCorrect(): Boolean {
        for (i in 0 until 9) {
            if (isCorrectBlock(
                    numbers[i][0],
                    numbers[i][1],
                    numbers[i][2],
                    numbers[i][3],
                    numbers[i][4],
                    numbers[i][5],
                    numbers[i][6],
                    numbers[i][7],
                    numbers[i][8]
                ).not()
            ) return false
            if (isCorrectBlock(
                    numbers[0][i],
                    numbers[1][i],
                    numbers[2][i],
                    numbers[3][i],
                    numbers[4][i],
                    numbers[5][i],
                    numbers[6][i],
                    numbers[7][i],
                    numbers[8][i]
                ).not()
            ) return false

            val x = (i / 3) * 3
            val y = (i % 3) * 3
            if (isCorrectBlock(
                    numbers[x][y],
                    numbers[x][y + 1],
                    numbers[x][y + 2],
                    numbers[x + 1][y],
                    numbers[x + 1][y + 1],
                    numbers[x + 1][y + 2],
                    numbers[x + 2][y],
                    numbers[x + 2][y + 1],
                    numbers[x + 2][y + 2],
                ).not()
            ) return false
        }
        return true
    }

    private fun isCorrectBlock(vararg line: Int): Boolean {
        if (line.toSet().size != 9) return false
        if (line.any { it == 0 }) return false
        return true
    }
}