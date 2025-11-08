/*
Approach:
Create dummy node, used for storing the head tht we will return, since the order might be chnaged
Store nodes to save the previous group end
get  kth node, 
kth.next = next group beginning
group start =previous group end .next
curr and prev node for recversing,
after reversing 
            pGE.next = kth;
            pGE = gS;
*/






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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null)
            return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pGE=dummy;

        while(true){
            ListNode kth=getKth(pGE, k);
            if(kth==null) break;

            ListNode nGS=kth.next;
            ListNode gS=pGE.next;
            ListNode prev=nGS;
            ListNode curr=gS;

            //reverse
            while(curr != nGS){
                ListNode tmp= curr.next;
                curr.next=prev;
                prev=curr;
                curr=tmp;
            }
            pGE.next = kth;
            pGE = gS;
        }
        return dummy.next;

    }
    public ListNode getKth(ListNode node, int k){
        while(node!=null && k>0){
            node=node.next;
            k--;
        }
        return node;
    }
}
