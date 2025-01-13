// Beats 79.64% of submissions for execution time.
// Beats 58.66% of submissions for memory usage.

/*
This is the solution I am unhappiest with currently - I am unhappy with the amount of time it takes
to execute, and likewise the amount of memory it takes up.  I will return to this to improve it at
a later point, however I've been struggling with it for too long at this point and need a break
to make further imrpovement.
*/

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var right: Int = 0
        var left: Int = 0
        val hashMap: HashMap<Char, Int> = hashMapOf()
        var longest: Int = 0
        while (right < s.length) {
            if (hashMap.containsKey(s[right]) && hashMap[s[right]]!! >= left) {
                if (right - left > longest) {
                    longest = right - left
                }
                // If `keyValue.first` is true, we know `keyValue.second` cannot be null
                left++
            } else {
                hashMap.put(s[right], right)
                right++
            }
        }
        return if (right - left > longest) (right - left) else longest
    }
}
