package LinkedList;

/**
 * @program: algorithm
 * @description: 反转链表的前n个值
 * @author: heruihao
 * @create: 2020-12-04 11:27
 **/
public class ReverseLinkedList1 {
    //递归实现链表反转
    ListNode res = null;
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
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList1 reverseLinkedList = new ReverseLinkedList1();
        ListNode listNode = reverseLinkedList.reverseN(head, 3);
        //遍历输出链表
        while (listNode!=null){
            System.out.print(listNode.val+"--->");
            listNode = listNode.next;
        }
    }
}
