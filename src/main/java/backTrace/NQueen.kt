package backTrace

import java.util.*


class NQueen {
    var res: MutableList<List<String>> = ArrayList()

    fun solveNQueens(n: Int): List<List<String>>? {
        val chessboard = Array(n) { CharArray(n) }
        for (c in chessboard) {
            Arrays.fill(c, '.')
        }
        backTrack(n, 0, chessboard)
        return res
    }


    fun backTrack(n: Int, row: Int, chessboard: Array<CharArray>) {
        if (row == n) {
            res.add(Array2List(chessboard))
            return
        }
        for (col in 0 until n) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q'
                backTrack(n, row + 1, chessboard)
                chessboard[row][col] = '.'
            }
        }
    }


    fun Array2List(chessboard: Array<CharArray>): List<String> {
        val list: MutableList<String> = ArrayList()
        for (c in chessboard) {
            list.add(String(c))
        }
        return list
    }


    fun isValid(row: Int, col: Int, n: Int, chessboard: Array<CharArray>): Boolean {
        // 检查列
        for (i in 0 until row) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false
            }
        }

        // 检查45度对角线
        run {
            var i = row - 1
            var j = col - 1
            while (i >= 0 && j >= 0) {
                if (chessboard[i][j] == 'Q') {
                    return false
                }
                i--
                j--
            }
        }

        // 检查135度对角线
        var i = row - 1
        var j = col + 1
        while (i >= 0 && j <= n - 1) {
            if (chessboard[i][j] == 'Q') {
                return false
            }
            i--
            j++
        }
        return true
    }
}