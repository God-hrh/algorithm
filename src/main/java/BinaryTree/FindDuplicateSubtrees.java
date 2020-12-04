package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 652. Find Duplicate Subtrees
 * @author: heruihao
 * @create: 2020-12-03 19:11
 **/
public class FindDuplicateSubtrees {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    private Map<String, Integer> counter = new HashMap<>();

    private List<TreeNode> collectors = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializerTree(root);
        return collectors;
    }

    private String serializerTree(TreeNode root) {
        if (null == root) {
            return " ";
        }
        String left = serializerTree(root.left);
        String right = serializerTree(root.right);
        String key = root.val + "," + left + "," + right;
        counter.put(key, counter.getOrDefault(key, 0) + 1);
        // 此处注意不能用>=2只加一次不能加多次
        if (counter.get(key) == 2) {
            collectors.add(root);
        }
        return key;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        TreeNode treeNode = new TreeNode(0,new TreeNode(0,new TreeNode(0),null),new TreeNode(0,null,new TreeNode(0)));
        findDuplicateSubtrees.findDuplicateSubtrees(treeNode);
    }
}
