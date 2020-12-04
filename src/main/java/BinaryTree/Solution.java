package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 斐波那契数列
 * @author: heruihao
 * @create: 2020-11-15 16:51
 **/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> routes = new LinkedList();
        long startTimeMillis = System.currentTimeMillis();
        getRoutes(nums,routes);
        long endTimeMillis = System.currentTimeMillis();
        System.out.println(endTimeMillis-startTimeMillis);
        return res;
    }

    public List<Integer> getRoutes(int[] nums,LinkedList<Integer> routes){
        if (nums.length==routes.size()) {
            res.add(new LinkedList<>(routes));
            return routes;
        }
        for (int num : nums) {
            if (routes.contains(num)) {
                continue;
            }
            //做选择
            routes.add(num);
            //递归
            getRoutes(nums,routes);
            //撤销选择
            routes.removeLast();
        }
        return null;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        Solution solution = new Solution();
        for (List<Integer> integers : solution.permute(coins)) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
