import java.util.*;
import java.io.*;

class removeNthNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class removeNthNode {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0);
        d.next = h;
        ListNode f = d, s = d;
        for (int i = 0; i <= n; i++) f = f.next;
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return d.next;
    }
}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 
 
 
 
 
