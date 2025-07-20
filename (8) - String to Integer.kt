// Beats 69.00% of submissions for execution time.
// Beats 57.75% of submissions for memory usage.

// This is one of those challenges where I'm let down by the speed of execution of Kotlin.
// The solution here is *I think* pretty much as good as you'll ever get, but Kotlin
// introduces a lot of memory and speed overhead, which is really holding it back.  Shame.

class Solution {
    // Pre-condition: number in form of " *(+|-)[0-9]+"
    fun myAtoi(s: String): Int {
        var index: Int = 0
        var isPositive: Boolean = true

        // Removes arbitrary whitespace
        while (index < s.length && s[index].isWhitespace()) {
            index++
        }

        // We need to use an if statement so that we can optionally increment index
        if (index < s.length && (s[index] == '+' || s[index] == '-')) {
            isPositive = s[index++] != '-'
        }

        // Removes leading 0's
        while (index < s.length && s[index] == '0') {
            index++
        }

        var number: Long = 0
        while (index < s.length && s[index].isDigit()) {
            number *= 10

            // Relies on the fact that numbers are arranged in ascii in ascending order
            number += s[index++].code - '0'.code

            if (number > Int.MAX_VALUE) {
                return if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
            }
        }

        if (!isPositive) {
            number *= -1
        }

        return number.toInt()
    }
}
