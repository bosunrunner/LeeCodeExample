package backTrace

class SolveSudoKu {
    private fun backTrace(board: Array<CharArray>): Boolean {

        // 不需要终止条件，题目仅有一个解析解
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                if (board[i][j] != '.') continue
                for (k in '1' until ':') {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k
                        if (backTrace(board)) return true
                        board[i][j] = '.'
                    }
                }
                return false

            }
        }
        return true

    }

    private fun isValid(row: Int, col: Int, value: Char, board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            if (board[i][col] == value) {
                return false
            }
        }
        for (i in 0 until 9) {
            if (board[row][i] == value) {
                return false
            }
        }
        val startRow: Int = (row / 3) * 3
        val startCol: Int = (col / 3) * 3
        for (r in startRow until startRow + 3) {
            for (c in startCol until startCol + 3) {
                if (board[r][c] == value) {
                    return false
                }
            }
        }
        return true
    }

    fun solveSudoku(board: Array<CharArray>): Unit {

        backTrace(board)
    }
}