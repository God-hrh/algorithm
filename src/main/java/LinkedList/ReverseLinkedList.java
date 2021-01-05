package LinkedList;

/**
 * @program: algorithm
 * @description: 206. Reverse Linked List
 * @author: heruihao
 * @create: 2020-12-04 11:27
 **/
public class ReverseLinkedList {
    //迭代实现链表反转
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr!=null){
            //先改变head的指向
            head = curr.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        return prev;
    }
    //递归实现链表反转
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        //颠倒指向
        head.next.next = head;
        head.next = null;
        return last;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        ListNode listNode = reverseLinkedList.reverseList(head);
        reverseLinkedList.reverse(head);
        System.out.println(1);
    }
}
