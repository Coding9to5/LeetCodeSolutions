// Beats 100.00% of submissions for runtime.
// Beats 98.27% of submissions for memory usage.

class Solution {
    fun addTwoNodes(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null
            } else {
                val node: ListNode = ListNode(carry)
                node.next = null
                return node
            }
        } else {
            val value1: Int = l1?.`val` ?: 0
            val value2: Int = l2?.`val` ?: 0
            val nextNode: ListNode? = addTwoNodes(l1?.next, l2?.next, (value1 + value2 + carry) / 10)
            val currentNode: ListNode = ListNode((value1 + value2 + carry) % 10)
            currentNode.next = nextNode
            return currentNode
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNodes(l1, l2, 0)
    }
}
