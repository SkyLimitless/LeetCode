/**
 * Created by achaurasia on 8/30/16.
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 **/
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class Problem2_AddTwoNumbers_Medium {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            ListNode p = l1;
            ListNode q = l2;
            ListNode pp = l1;
            ListNode pq = l2;
            int carry = 0;
            while (p != null && q != null) {
                int sum = p.val + q.val + carry;
                p.val = sum % 10;
                carry = sum / 10;
                pp = p;
                pq = q;
                p = p.next;
                q = q.next;
            }
            if (q != null) {
                int sum =
                q.val = q.val + carry;
                pp.next = q;
                pq.next = null;
                p = q;
            } else if (p != null) {
                p.val = p.val + carry;
            } else if (carry == 1) {
                pp.next = new ListNode(carry);
            }

            //test case for [9,9,9,9] and [1]
            if( p!= null  && p.val/10 > 0) {
                carry = p.val/10;
                p.val = p.val%10;
                while(p.next != null && carry == 1) {
                    pp = p;
                    p = p.next;
                    int sum = p.val + carry;
                    p.val = sum%10;
                    carry = sum/10;
                }

                if (carry == 1) {
                    p.next = new ListNode(carry);
                }
            }
            return l1;
        }
    }

    public static void main(String args[]) {
        Problem2_AddTwoNumbers_Medium problem2_addTwoNumbers_medium = new Problem2_AddTwoNumbers_Medium();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = problem2_addTwoNumbers_medium.addTwoNumbers(l1, l2);
        while(l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}

