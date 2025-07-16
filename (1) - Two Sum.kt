// Beats 88.11% of submissions for execution time.
// Beats 71.87% of submissions for memory usage.
/*
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap: HashMap<Int, Int> = hashMapOf()
        var count: Int = -1
        while (count < nums.size) {
            count++
            if (hashMap.containsKey(target - nums[count])) {
                return intArrayOf(hashMap[target - nums[count]]!!, count)
            } else {
                if (!hashMap.containsKey(nums[count])) {
                    hashMap.put(nums[count], count)
                }
            }
        }
        // Returns the empty array if no two numbers sum to the target value.
        return intArrayOf()
    }
}
*/