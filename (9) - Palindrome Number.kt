// I originally started writing the solution to this the second way, however to
// begin with, I wasn't returning false if the x % 10 == 0, causing logic errors.
// I then decided to implement it the *obvious* way which is the first
// implementation, before then figuring out what was going wrong in the second.
// I have pushed both solutions because they offer different things:

// 1st solution:
//      Beats 49.91% of submissions for execution time.
//      Beats 95.25% of submissions for memory usage.
// 2nd solution:
//      Beats 98.94% of submissions for execution time.
//      Beats 56.54% of submissions for memory usage.

class Solution {
    private fun Boolean.toInt(): Int = when (this) {
        false -> 0
        true -> 1
    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val stringX: String = x.toString()
        if (stringX.length % 2 == 0 && x % 11 != 0) return false
        var index1: Int = stringX.length / 2 - 1
        // I.e. if odd length then pointers before and after the midpoint;
        // if even length, pointers around the midpoint
        var index2: Int = stringX.length / 2 + (stringX.length % 2 != 0).toInt()
        while (index1 >= 0) {
            if (stringX[index1] != stringX[index2]) return false
            index1--
            index2++
        }
        return true
    }
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false
        if (x == 0) return true
        var num1: Int = x
        var num2: Int = 0
        while (num1 > 0) {
            num2 *= 10
            num2 += num1 % 10
            if (num2 == num1 || num2 == num1 / 10) return true
            num1 /= 10
        }
        return false
    }
}
