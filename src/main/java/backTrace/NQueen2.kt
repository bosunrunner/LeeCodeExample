package backTrace

class NQueen2 {
    val result: MutableList<List<String>> = ArrayList();

    fun backTrace(n: Int, row: Int, chessboard: Array<CharArray>) {
        // 终止条件
        if (row == n) {
            result.add(array2List(chessboard))
        }
        // 单层循环
        for (col in 0 until n) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q'
                backTrace(n, row + 1, chessboard)
                chessboard[row][col] = '.'
            }
        }

    }

    private fun isValid(row: Int, col: Int, n: Int, chessboard: Array<CharArray>): Boolean {
        // 检查列
        for (i in 0 until n) {
            if (chessboard[i][col] == 'Q') {
                return false
            }
        }
        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (chessboard[i][j] == 'Q') {
                return false
            }
            i -= 1
            j -= 1
        }

        var m = row - 1
        var k = col + 1
        while (m >= 0 && k <= n - 1) {
            if (chessboard[m][k] == 'Q') {
                return false
            }
            m--
            k++
        }
        return true
    }

    private fun array2List(chessboard: Array<CharArray>): List<String> {
        val list = mutableListOf<String>()
        for (c in chessboard) {
            list.add(String(c))
        }
        return list
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val chessboard = Array(n) { CharArray(n) }
        for (c in chessboard) {
            c.fill('.')
        }
        backTrace(n, 0, chessboard)
        return result
    }
}