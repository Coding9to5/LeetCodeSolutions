// Beats 90.96% of submissions for execution time.
// Beats 89.67% of submissions for memory usage.

class Solution {
    fun letterCombinations(digits: String): List<String> {
        var possible: MutableList<String> = mutableListOf()
        val addChars: (HashMap<String, String>, MutableList<String>, String, Char) -> Unit = {map, list, prefix, char ->
            for (letter in map[char.toString()]!!) {
                list.add(prefix + letter.toString())
            }
        }
        val mapping: HashMap<String, String> = hashMapOf(
            "2" to "abc",
            "3" to "def",
            "4" to "ghi",
            "5" to "jkl",
            "6" to "mno",
            "7" to "pqrs",
            "8" to "tuv",
            "9" to "wxyz",
        )
        for (digit in digits) {
            val currentList: MutableList<String> = mutableListOf()
            for (poss in possible) {
                addChars(mapping, currentList, poss, digit)
            }
            if (currentList.isEmpty()) {
                addChars(mapping, currentList, "", digit)
            }
            possible = currentList
        }
        return possible
    }
}