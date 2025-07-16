// Beats 79.64% of submissions for execution time.
// Beats 58.66% of submissions for memory usage.
/*
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
*/