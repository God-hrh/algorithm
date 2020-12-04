package BinaryTree;

/**
 * @program: algorithm
 * @description: 222. Count Complete Tree Nodes
 * @author: heruihao
 * @create: 2020-12-03 11:02
 **/
public class CountCompleteTreeNodes {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        //要先知道根的左子节点个数和根的右子节点个数，所以采用后序遍历
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int i = left + right + 1;
        return i;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode left1 = new TreeNode(4);
        left.left = left1;
        TreeNode right1 = new TreeNode(5);
        left.right = right1;
        right.left = new TreeNode(6);
        countCompleteTreeNodes.countNodes(root);
    }
}
