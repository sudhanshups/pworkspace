package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InterviewbitLinkList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitLinkList ibit = new InterviewbitLinkList();

/*        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        System.out.println(ibit.lPalin(head));*/

/*        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        System.out.println(ibit.deleteDuplicates(head));*/
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(2);
        System.out.println(ibit.mergeTwoLists(head,head2));*/

/*        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        System.out.println(ibit.removeNthFromEnd(head, 2));*/

       /* ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        ibit.printL(ibit.rotateRight(head, 5));*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
       // ibit.printL(ibit.reverseBetween(head, 5,4));

    }

   /* public ListNode reverseBetween(ListNode A, int B, int C) {
        if(B==C){
            return  A;
        }
        C=C-B;
        ListNode pre = null;
        ListNode cur = A;
        B--;
        while(B-->0){
            pre = cur;
            cur= cur.next;
        }
        while(C-->0){
            cur = cur.next;
        }
        ListNode cuNext = cur.next;
        if(pre==null){
            A.next = cur.next;
            cur.next = A;
        }else{//reverse from pre->next to curr.
            ListNode pre1 = pre;
            ListNode head = pre.next;
            ListNode next = pre.next.next;
            while (head.next != cuNext) {
                head.next = pre1;
                pre1 = head;
                head = next;
                if (next != null)
                    next = next.next;
            }
            pre.next = head;


        }



    }*/

    public ListNode rotateRight(ListNode A, int B) {
        ListNode cur = A;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (count == 0 || B % count == 0 ) {
            return A;
        }
        B = B % count;

        ListNode pre = null;
        cur = A;
        B = count - B;
        while (B > 0) {
            pre = cur;
            cur = cur.next;
            B--;
        }
        ListNode newHead = cur;
        pre.next = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = A;

        return newHead;
    }

    public void printL(ListNode a) {
        while (a != null) {
            System.out.print(a.val + " -> ");
            a = a.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode end = A;
        while (end != null && B > 0) {
            end = end.next;
            B--;
        }
        if (end == null) {
            return A.next;
        }
        ListNode pre = A;
        while (end.next != null) {
            end = end.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return A;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null)
            return B;
        else if (B == null) {
            return A;
        }
        ListNode head = null;
        if (A.val <= B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }
        ListNode cur = head;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                cur.next = A;
                A = A.next;
            } else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }
        if (A != null) {
            cur.next = A;
        } else {
            cur.next = B;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode A) {
        /*
        ListNode current = a;
	    while (current.next != null) {
	        if (current.val == current.next.val) {
	            current.next = current.next.next;
	        }
	        else {
	            current = current.next;
	        }
	    }
         */
        ListNode head = A;
        ListNode next = A.next;
        while (next != null) {
            if (head.val == next.val) {
                head.next = next.next;
            } else {
                head = head.next;
            }
            next = next.next;
        }
        return A;
    }


    public int lPalin(ListNode A) {
        ListNode head = A;
        ListNode mid = A;
        ListNode pre = null;
        boolean even = false;
        while (mid != null) {
            pre = head;
            head = head.next;
            mid = mid.next;
            even = false;
            if (mid != null) {
                mid = mid.next;
                even = true;
            }
        }

        //pre is now middle.
        mid = head;//mid +1 if odd
        pre.next = null;

        //reverse the A till pre. and compare.

        pre = null;
        head = A;
        ListNode next = A.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = next;
            if (next != null)
                next = next.next;
        }
        head = pre;
        if (!even && head.next != null) {
            head = head.next;
        }


        while (mid != null) {
            if (mid.val != head.val)
                return 0;
            mid = mid.next;
            head = head.next;
        }

        return 1;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }


}
