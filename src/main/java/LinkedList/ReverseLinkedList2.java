package LinkedList;

/**
 * @program: algorithm
 * @description: 92. Reverse Linked List II
 * @author: heruihao
 * @create: 2020-12-04 11:27
 **/
public class ReverseLinkedList2 {
    //递归实现链表反转
    ListNode res = null;
    //反转链表前n个数，index是从1开始
    ListNode reverseN(ListNode head,int n) {
        if (n == 1){
            //暂存一下head。next，做最后结果的拼接使用
            res = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        //在这里对最后结果做拼接
        head.next = res;
        return last;
    }
    ListNode reserveBetweent(ListNode head ,int m ,int n){
        if (m == 1 ){
            return reverseN(head,n);
        }
        head.next = reserveBetweent(head.next,m-1,n-1);
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        ListNode listNode = reverseLinkedList.reserveBetweent(head, 2,3);
        //遍历输出链表
        while (listNode!=null){
            System.out.print(listNode.val+"--->");
            listNode = listNode.next;
        }
    }
}
