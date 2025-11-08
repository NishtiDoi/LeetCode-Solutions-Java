/* 
Approach:
1. Use a dummy node to simplify result list construction.
2. Maintain a 'tail' pointer to build the new list as we add digits.
3. Keep a 'carry' variable to handle sums greater than 9.
4. Traverse both linked lists until both are fully processed:
   - Extract the current digit from each list (use 0 if one list is shorter).
   - Add the digits and the carry.
   - Compute new carry as sum / 10.
   - Create a new node with value sum % 10 and link it to the result.
5. After the loop, if carry remains, append a new node for it.
6. Return dummy.next as the head of the final linked list.
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0)
            tail.next = new ListNode(carry);

        return dummy.next;
    }
}
