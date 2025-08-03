// Beats 98.82% of submissions for execution time.
// Beats 98.52% of submissions for memory usage.

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var pointer: Int = 0
        while (pointer < strs[0].length) {
            // Interestingly, using Kotlin's `Collections.all` function doubles the execution time,
            // even though it leads to slightly neater code.
            if (!strs.fold(true) { acc, item -> acc && pointer < item.length && item[pointer] == strs[0][pointer] }) {
                break
            }
            pointer++
        }
        return strs[0].substring(0, pointer)
    }
}