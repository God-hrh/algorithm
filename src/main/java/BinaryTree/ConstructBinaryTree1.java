package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 106重构二叉树  这个解法比较强
 * @author: heruihao
 * @create: 2020-12-02 20:52
 **/
public class ConstructBinaryTree1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(0,inorder.length-1,0,postorder.length-1,inorder,postorder);
    }

    public TreeNode build(int il,int ir,int pl,int pr,int[] ino,int[] pos){
        if(il > ir) return null;
        TreeNode root = new TreeNode(pos[pr]);
        int i = map.get(root.val);
        int len = i - il - 1;

        root.left = build(il,i-1,pl,pl+len,ino,pos);
        root.right = build(i+1,ir,pl+len+1,pr-1,ino,pos);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree1 constructBinaryTree = new ConstructBinaryTree1();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        constructBinaryTree.buildTree(postorder,inorder);
    }
}
