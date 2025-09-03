// Beats 69.20% of submissions for execution time.
// Beats 68.93% of submissions for memory usage.

import java.util.Deque
import java.util.LinkedList


class Solution {
    fun isValid(s: String): Boolean {
        val stack: Deque<Char> = LinkedList()
        val brackets: HashMap<Char, Char> = hashMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '[',
        )
        for (char in s) {
            if (char in brackets.keys) {
                if (stack.isEmpty() || stack.pop() != brackets[char]) {
                    return false
                }
            } else {
                stack.push(char)
            }
        }
        return stack.isEmpty()
    }
}