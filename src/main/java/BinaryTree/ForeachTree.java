package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: algorithm
 * @description:前序中序后序层次方式遍历二叉树
 * @author: heruihao
 * @create: 2020-11-16 16:25
 **/
public class ForeachTree {
    public static void preOrder(Node root){
        if (root == null) return;
        System.out.print(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    //非递归遍历方式
    public static void preOrder2(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right!=null) stack.add(node.right);
            if (node.left!=null) stack.push(node.left);
        }
    }

    public static void midOrder(Node root){
        if (root == null) return;
        midOrder(root.left);
        System.out.print(root.value);
        midOrder(root.right);
    }
    public static void midOrder2(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    }
    public static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value);
    }
    //层次遍历
    public static void bfs(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.right = nodeF;
        nodeE.left = nodeG;
        System.out.print("先序遍历：");
        preOrder(nodeA);
        System.out.println();
        System.out.print("先序遍历：");
        preOrder2(nodeA);
        System.out.println();
        System.out.print("中序遍历：");
        midOrder(nodeA);
        System.out.println();
        System.out.print("后序遍历：");
        postOrder(nodeA);
        System.out.println();
        System.out.print("层次遍历：");
        bfs(nodeA);
    }
    private static class Node{
        private String value;
        private Node left;
        private Node right;
        public Node(String value){
            this.value = value;
        }
    }
}
