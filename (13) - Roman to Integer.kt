// Beats 72.42% of submissions for execution time.
// Beats 82.01% of submissions for memory usage.

class Solution {
    // Pre-condition: s is a valid Roman numeral formed with only the letters in `numerals`.
    fun romanToInt(s: String): Int {
        val numerals: HashMap<Char, Int> = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )
        var result: Int = 0
        var pointer: Int = 0
        while (pointer < s.length) {
            if (pointer < s.length - 1 && numerals[s[pointer]]!! < numerals[s[pointer + 1]]!!) {
                result += numerals[s[pointer + 1]]!! - numerals[s[pointer]]!!
                pointer++
            } else {
                result += numerals[s[pointer]]!!
            }
            pointer++
        }

        return result
    }
}
