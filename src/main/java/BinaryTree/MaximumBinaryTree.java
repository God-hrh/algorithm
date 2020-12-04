package BinaryTree;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:构建最大二叉树
 * @author: heruihao
 * @create: 2020-12-02 11:40
 **/
public class MaximumBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0)return null;
        if (getMaxIndex(nums)<0) return null;
        //获取数组中的最大值，把最大值作为根结点生成一个二叉树
        TreeNode root = new TreeNode(nums[getMaxIndex(nums)]);
        //递归原数组中最大值的左侧数据，找到最大值作为根结点的左子树
        int[] leftArray = Arrays.copyOfRange(nums,0,getMaxIndex(nums));
        root.left = constructMaximumBinaryTree(leftArray);
        //递归原数组中最大值的右侧数据，找到最大值作为根结点的右子树
        int[] righrArray = Arrays.copyOfRange(nums,getMaxIndex(nums)+1,nums.length);
        root.right = constructMaximumBinaryTree(righrArray);
        return root;
    }
    public int getMaxIndex(int[] nums){
        if(nums.length==0)return-1;
        int index = 0;
        for(int i = 1;i<=nums.length-1;i++){
            if(nums[i]>nums[index]){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] a = {3,2,1,6,0,5};
        maximumBinaryTree.constructMaximumBinaryTree(a);
    }
}
