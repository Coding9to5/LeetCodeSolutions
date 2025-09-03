// Beats 100.00% of submissions for execution time.
// Beats 85.66r% of submissions for memory usage.

data class ListNode(var `val`: Int, var next: ListNode? = null)

class Solution {
    // Pre-condition: head != null
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val nodeList: MutableList<ListNode> = mutableListOf()
        var currentNode: ListNode? = head
        while (currentNode != null) {
            nodeList.add(currentNode)
            currentNode = currentNode.next
        }
        val nIndex: Int = nodeList.size - n
        if (nIndex > 0) {
            nodeList[nIndex - 1].next = nodeList[nIndex].next
            return head
        }
        return head!!.next
    }
}