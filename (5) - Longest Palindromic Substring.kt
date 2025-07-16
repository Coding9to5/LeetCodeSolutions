// Beats 46.50% of submissions for execution time.
// Beats 20% of submissions for memory usage.

/*
This is the solution I am unhappiest with currently - I am unhappy with the amount of time it takes
to execute, and likewise the amount of memory it takes up.  I will return to this to improve it at
a later point, however I've been struggling with it for too long at this point and need a break
in order that I can look back at this with a fresh pair of eyes.  I'll look to see if I can implement
the O(n) algorithm.
*/
/*
import kotlin.math.min

class Solution {
    // Given the second half of the palindrome, e.g. 'car' of 'racecar', and an optional
    // middle character, `createPalindrome` reconstructs the entire palindrome.
    private fun createPalindrome(builder: StringBuilder, c: Char?): String? =
        if (builder.isEmpty()) {
            null
        } else {
            val secondHalf: String = builder.toString()
            builder.reverse().toString() + (c?.toString() ?: "") + secondHalf
        }

    // Given two substrings, s1 and s2, `checkAtChar` will check if there are any start characters
    // of s2 that are equal to the end characters of s1 - i.e. checking if part of s1 and part of s2
    // form a palindrome, returning this palindrome if so.
    private fun checkAtChar(s1: String?, s2: String?, c: Char? = null): String? {
        if (s1 == null || s2 == null) return null
        val builder: StringBuilder = StringBuilder()
        for (i in 0..<min(s1.length, s2.length)) {
            if (s1[s1.length - i - 1] != s2[i]) {
                return createPalindrome(builder, c)
            } else {
                builder.append(s2[i])
            }
        }
        return createPalindrome(builder, c)
    }

    // Returns the longer string
    private fun getLonger(s1: String, s2: String?): String = if (s2 != null && s2.length > s1.length) s2 else s1

    // This will iterate over all 'middle' positions of possible palindromes in the string provided,
    // calling `checkAtChar` on them.
    // Pre-condition: s.length >= 0
    fun longestPalindrome(s: String): String {
        var maxString: String = s.substring(0, 1)
        for (i in 1..<s.length) {
            if (maxString.length > 2 * i + 1) {
                // We can short-circuit as there can be no greater palindrome left
                break
            }
            val palindrome1: String? = checkAtChar(s.substring(0,i), s.substring(i))
            val palindrome2: String? = checkAtChar(s.substring(0, i), s.substring(i+1), s[i])
            maxString = getLonger(getLonger(maxString, palindrome1), palindrome2)
        }
        return maxString
    }
}
*/