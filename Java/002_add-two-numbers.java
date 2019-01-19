/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      int sum = l1.val + l2.val;
      if (sum > 9) {
        sum = sum % 10;
        carry = 1;
      }

      ListNode root = new ListNode(sum);
      ListNode current = root;

      l1 = l1.next;
      l2 = l2.next;

      while ((l1 != null) || (l2 != null)) {
        sum = carry;

        if ((l1 != null)) {
          sum += l1.val;
          l1 = l1.next;
        }

        if ((l2 != null)) {
          sum += l2.val;
          l2 = l2.next;
        }

        if (sum > 9) {
          current.next = new ListNode(sum % 10);
          carry = 1;
        } else {
          current.next = new ListNode(sum);
          carry = 0;
        }

        current = current.next;
      }

      if (carry != 0) 
        current.next = new ListNode(carry);

      return root;
    }
}
