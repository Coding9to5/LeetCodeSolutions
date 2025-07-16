// Beats 81.99% of submissions for execution time.
// Beats 86.01% of submissions for memory usage.

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val getNextLetter1: (Int) -> Int = { 2 * (numRows - it - 1) }
        val getNextLetter2: (Int) -> Int = { 2 * it }
        val builder: StringBuilder = StringBuilder(s[0].toString())

        for (currRowIndex in 0..<numRows) {
            var index: Int = currRowIndex
            var got1: Boolean = false
            while (index < s.length) {
                if (got1 || (currRowIndex != 0 && currRowIndex != numRows - 1)) {
                    builder.append(s[index])
                }
                index += if (got1) getNextLetter2(currRowIndex) else getNextLetter1(currRowIndex)
                got1 = !got1
            }
        }

        return builder.toString()
    }
}

fun main() {
    val phrase: String = "AB"
    val numRows: Int = 1
    val solution: Solution = Solution()
    println("Result: ${solution.convert(phrase, numRows)}")
}