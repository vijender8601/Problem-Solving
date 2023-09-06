 
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head==null)
        {
            return ans;
        }
        int cnt = 0;
        ListNode curr = head;
        while(curr!=null)
        {
            cnt+=1;
            curr = curr.next;
        }

        int mod = cnt%k;
        cnt/=k;


        curr = head;
        int temp = 0,j = 0;
        while(curr!=null)
        {
            temp+=1;
            if(temp==cnt+(mod>0?1:0))
            {
                ListNode next = curr.next;
                curr.next = null;
                ans[j++] = head;
                curr = next;
                head = curr;
                mod--;
                temp = 0;
            } else {
                curr = curr.next;
            }
        }

        return ans;
    }
}