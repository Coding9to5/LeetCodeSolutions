// Beats 81.36% of submissions for execution time.
// Beats 75.32% of submissions for memory usage.

import kotlin.math.min
import kotlin.math.max

class Solution {
    private fun area(array: IntArray, leftmark: Int, rightmark: Int): Int =
        (rightmark - leftmark) *  min(array[leftmark], array[rightmark])

    fun maxArea(height: IntArray): Int {
        var leftmark: Int = 0
        var rightmark: Int = height.size - 1
        var largestArea: Int = area(height, leftmark, rightmark)

        while (leftmark < rightmark) {
            if (height[leftmark] < height[rightmark]) {
                leftmark++
            } else {
                rightmark--
            }
            largestArea = max(largestArea, area(height, leftmark, rightmark))
        }

        return largestArea
    }
}
