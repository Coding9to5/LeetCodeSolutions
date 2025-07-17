// Beats 80.56% of submissions for execution time.
// Beats 46.08% of submissions for memory usage.

class Solution {
    fun reverse(x: Int): Int {
        var xCopy: Int = x
        var reversed: Int = 0
        while (xCopy != 0) {
            if ((reversed > Int.MAX_VALUE / 10) || (reversed < Int.MIN_VALUE / 10)) {
                return 0
            }
            reversed *= 10
            reversed += xCopy % 10
            xCopy /= 10
        }
        return reversed
    }
}
