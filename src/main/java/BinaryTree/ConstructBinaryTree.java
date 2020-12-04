package BinaryTree;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 105重构二叉树
 * @author: heruihao
 * @create: 2020-12-02 20:52
 **/
public class ConstructBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)return null;
        //先序遍历：根左右
        //先根据先序遍历数组的第一个元素获取根元素
        TreeNode root = new TreeNode(preorder[0]);
        //然后在中序遍历数组里找到这个元素，左边的全是在根结点的左子树上，右边的全是在根结点的右子树上
        int inorderRootIndex = getIndex(preorder[0],inorder);
        //中序数组中从index=0到根是左子树的中序遍历顺序
        int[] inorderSubTreeLeft = Arrays.copyOfRange(inorder,0,inorderRootIndex);
        //先序数组中从根+1到左子树中序遍历的数量为左子树先序遍历的顺序
        int[] preorderSubTreeLeft = Arrays.copyOfRange(preorder,1,inorderSubTreeLeft.length+1);
        //递归左子树
        root.left = buildTree(preorderSubTreeLeft,inorderSubTreeLeft);
        //中序数组中从index=0到根是左子树的中序遍历顺序
        int[] inorderSubTreeRight = Arrays.copyOfRange(inorder,inorderRootIndex+1,inorder.length);
        //先序数组中从根+1到左子树中序遍历的数量为左子树先序遍历的顺序
        int[] preorderSubTreeRight = Arrays.copyOfRange(preorder,preorderSubTreeLeft.length+1,inorder.length);
        //递归右子树
        root.right = buildTree(preorderSubTreeRight,inorderSubTreeRight);
        return root;
    }
    public int getIndex(int root,int[] inorder){
        int index = -1;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == root){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};
        constructBinaryTree.buildTree(preorder,inorder);
    }
}
