class Solver {
    fun solve(numbers: Array<Array<Int>>): Pair<Boolean, Array<Array<Int>>> {
        if (existEmpty(numbers)) {
            for (i in 0..9) {
                for (j in 0..9) {
                    if (numbers[i][j] == 0) {
                        searchUnusedNumbers(numbers, i, j).forEach {
                            val nums = numbers.copyOf()
                            nums[i][j] = it
                            val res = solve(nums)
                            if (res.first) return res
                        }
                    }
                }
            }
        } else {
            if (isCorrect(numbers)) return Pair(true, numbers)
        }
        return Pair(false, numbers)
    }

    private fun existEmpty(numbers: Array<Array<Int>>): Boolean {
        numbers.forEach {
            if (it.any { i -> i == 0 }) return true
        }
        return false
    }

    private fun searchUnusedNumbers(numbers: Array<Array<Int>>, x: Int, y: Int): Set<Int> {
        val set = (1..9).toSet()
        return set
    }

    private fun isCorrect(numbers: Array<Array<Int>>): Boolean {
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