package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: 297. Serialize and Deserialize Binary Tree
 * @author: heruihao
 * @create: 2020-12-03 14:52
 **/
public class SerializeAndDeserializeBinaryTree {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res = new StringBuilder();
        StringBuilder sb = toSerialize(root, res);
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public StringBuilder toSerialize(TreeNode root,StringBuilder res){
        if(root==null) {
            res.append("null").append(",");
            return null;
        }
        res.append(root.val).append(",");
        toSerialize(root.left,res);
        toSerialize(root.right,res);
        return res;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
         List<String> list = new ArrayList<>();
         list.addAll(Arrays.asList(data.split(",")));
         return toDeserialize(list);
    }

    public TreeNode toDeserialize(List<String> list) {
        if (list.isEmpty()) return null;
        String first = list.remove(0);
        if ("null".equals(first)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(first));
        root.left = toDeserialize(list);
        root.right = toDeserialize(list);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode left1 = new TreeNode(4);
        right.left = left1;
        TreeNode right1 = new TreeNode(5);
        right.right = right1;
        SerializeAndDeserializeBinaryTree serialize = new SerializeAndDeserializeBinaryTree();
        System.out.println(serialize.serialize(root));
    }
}
