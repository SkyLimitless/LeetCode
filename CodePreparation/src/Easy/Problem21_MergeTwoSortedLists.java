package Easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by achaurasia on 11/18/16.
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

public class Problem21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Problem21_MergeTwoSortedLists mergeTwoSortedLists = new Problem21_MergeTwoSortedLists();
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(25);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(9);
        //ListNode result = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        ListNode result = mergeTwoSortedLists.mergeKLists(new ListNode[]{head1, head2});
        while(result != null) {
            System.out.println("result.val = " + result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = result;
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                if(temp == null) {
                    temp = l1;
                    result = l1;
                } else {
                    ListNode prev = l1;
                    l1 = l1.next;
                    temp.next = prev;
                    temp = temp.next;
                }
            } else {
                if(temp == null) {
                    temp = l2;
                    result = l2;
                } else {
                    ListNode prev = l2;
                    l2 = l2.next;
                    temp.next = prev;
                    temp = temp.next;
                }
            }
        }

        if(l1 != null) {
            temp.next = l1;
        } else  {
            temp.next = l2;
        }
        return result;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        int mid = len/2;
        if(len == 0) {
            return null;
        }
        if(len == 1) {
            return lists[0];
        }
        ListNode[] a = Arrays.copyOfRange(lists, 0, mid);
        ListNode[] b = Arrays.copyOfRange(lists, mid, len);
        ListNode t1 = mergeKLists(a);
        ListNode t2 = mergeKLists(b);
        return merge(t1, t2);
    }

    public ListNode merge(ListNode l1,ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
