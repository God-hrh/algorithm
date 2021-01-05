package LinkedList;

/**
 * @program: algorithm
 * @description: 25. Reverse Nodes in k-Group
 * @author: heruihao
 * @create: 2020-12-08 14:21
 **/
public class ReverseNodesInKGroup {

    ListNode reverse (ListNode head,ListNode res){
        if (head.next == res) return head;
        ListNode last = reverse(head.next,res);
        //颠倒指向
        head.next.next = head;
        head.next = res;
        return last;
    }
    //定义一个数记录当前递归的次数
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a,b;
        a= b = head;
        for (int i = 0; i < k; i++) {
            if (b==null)return head;
            b = b.next;
        }
        ListNode reverse = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return reverse;
    }

    public static  void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
//        ListNode reverse = reverseNodesInKGroup.reverseKGroup(head,2);
//        while (reverse!=null){
//            System.out.print(reverse.val+"--->");
//            reverse = reverse.next;
//        }
    }
}
