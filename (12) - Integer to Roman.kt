// Beats 71.05% of submissions for execution time.
// Beats 99.01% of submissions for memory usage.

// Personally, I don't like the idea here of hard-coding values for 4, 9, 40, 90 ...
// because it feels like cheating, albeit I accept that it does allow for a large
// performance gain.

class Solution {
    // Pre-condition: 1 ≤ num ≤ 3999
    fun intToRoman(num: Int): String {
        // Thanks to the pre-condition, we get the invariant that pointer < numerals.size
        val numerals: Array<Char> = arrayOf('I', 'V', 'X', 'L', 'C', 'D', 'M')
        var result: String = ""
        var value: Int = num
        var pointer: Int = 0

        while (value > 0) {
            if (value % 5 == 4) {
                result = "${numerals[pointer]}${numerals[pointer + ((value % 10) / 4)]}$result"
            } else {
                // Although I could use Kotlin's String `repeat` function, this actually doubled the execution time.
                while (value % 5 != 0) {
                    result = "${numerals[pointer]}$result"
                    value--
                }
                if (value % 10 == 5) {
                    result = "${numerals[pointer + 1]}$result"
                }
            }
            value /= 10
            pointer += 2
        }

        return result
    }
}
