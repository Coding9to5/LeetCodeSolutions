// Beats 79.74% of submissions for execution time.
// Beats 82.35% of submissions for memory usage.

// This solution tends to have more balanced statistics than the dynamic programming version.

class Solution {
    private fun isCharMatch(s: Char, p: Char): Boolean = (s == p || p == '.')

    // Returns null if s doesn't  match the chars of acceptable with final character: final
    // Otherwise, returns an int of the position of `final` in s
    // Also, returns null if there aren't `numToSee` `finalChar`s in s.
    private fun matchesAsterisks(s: String, start: Int, acceptable: List<Char>, finalChar: Char?, numToSee: Int): Int? {
        var numCharSeen: Int = 0
        var acceptIndex: Int = 0

        for (index in start..<s.length) {
            // Return the index of the `numToSee`th char in s which corresponds to `finalChar`.
            if (finalChar != null && isCharMatch(s[index], finalChar) && numCharSeen++ == numToSee) return index

            // Makes sure that any set of Kleene closures are matched in order.
            while (acceptIndex < acceptable.size && !isCharMatch(s[index], acceptable[acceptIndex])) {
                acceptIndex++
            }

            // This is true iff we have exhausted all possible Kleene closures, but have not reached
            // a valid char in s which corresponds to `finalChar`
            if (acceptIndex == acceptable.size) return null
        }

        return if (finalChar != null) null else -1
    }

    // Returns the list of characters between asterisks and the index of the first char without an asterisk after it.
    private fun skipAsterisks(startIndex: Int, p: String): Pair<List<Char>, Int> {
        var currentIndex: Int = startIndex
        val seenChars: MutableList<Char> = mutableListOf()

        while (currentIndex < p.length - 1) {
            if (p[currentIndex + 1] == '*') {
                seenChars.add(p[currentIndex])
                currentIndex += 2
            } else {
                break
            }
        }

        return Pair(seenChars, currentIndex)
    }

    // p is regex expression
    fun isMatch(s: String, p: String): Boolean {
        var sIndex: Int = 0
        var pIndex: Int = 0

        // Ensures that we can always examine the next char of p to check if it's an asterisk.
        while (sIndex < s.length && pIndex + 1 < p.length) {
            if (p[pIndex + 1] == '*') {
                val (seenChars: List<Char>, endIndex: Int) = skipAsterisks(pIndex, p)

                if (endIndex == p.length) {
                    // Condition is met iff we have only Kleene closures left in the regex.
                    // We need only to check that all characters in S appear in the order of those of seenChars.
                    return matchesAsterisks(s, sIndex, seenChars, null, 0) != null
                }

                // There might be multiple chars which are equal to the char at endIndex.  Any one of these
                // could be the first char AFTER the Kleene closure, so we test them in order, backtracking
                // if necessary.
                var numToSee: Int = 0
                var newSIndex: Int
                do {
                    // If there is no matching char after the Kleene closure, the regex cannot match
                    newSIndex = matchesAsterisks(s, sIndex, seenChars, p[endIndex], numToSee++) ?: return false
                } while (!isMatch(s.substring(newSIndex), p.substring(endIndex)))

                // Only reach this point if we have matched the Kleene closure and all subsequent regex.
                return true
            } else {
                if (isCharMatch(s[sIndex], p[pIndex])) {
                    sIndex++
                    pIndex++
                } else {
                    return false
                }
            }
        }

        if (pIndex < p.length) {
            // Two cases: either p ends in an asterisk, or it doesn't.
            // If it does, then pIndex + 1 < p.length, so s cannot have any chars left at the end - thus,
            //      we need to confirm that only Kleene closures are left at the end of p.
            // Otherwise, there can only be one char left in p, and we need to ensure that this char is
            //      equal to the final char of s.

            val (_, finalAsteriskIndex: Int) = skipAsterisks(pIndex, p)
            return ((sIndex == s.length && finalAsteriskIndex == p.length) ||
                    ((s.length - sIndex == p.length - finalAsteriskIndex)
                            && isCharMatch(s[sIndex], p[finalAsteriskIndex])))
        }

        return true
    }
}
