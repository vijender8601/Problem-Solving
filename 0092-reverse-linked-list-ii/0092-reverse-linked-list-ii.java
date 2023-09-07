/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head,prev = null;
        int i=1;

        while(i<left)
        {
            prev = curr;
            curr = curr.next;
            i+=1;
        }
        if(prev!=null) prev.next = null;

        ListNode temp = curr,prev2 = null,last = curr;
        while(i<=right)
        {
            ListNode next = temp.next;
            temp.next = prev2;
            prev2 = temp;
            temp = next;
            i+=1;
        }
        System.out.println(prev2.val);
        if(prev!=null)
        prev.next = prev2;
        else head =prev2;
        last.next = temp;

        return head;
    }
}

// 1-> 2-> 3-> 4-> 5-> 6-> 7
//