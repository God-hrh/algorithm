package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: 两个栈实现队列
 * @author: heruihao
 * @create: 2020-11-15 16:07
 **/
public class CQueue {
    static  List res = new ArrayList();
    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();
    public CQueue() {
        res.add(null);
    }

    public static void appendTail(int value) {
        stack1.push(value);
        res.add(null);
    }

    public static int deleteHead() {
        if (stack2.empty()){
            if (stack1.empty()) {
                res.add(-1);
                return 0;
            }
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            res.add(stack2.pop());
        }else {
            res.add(stack2.pop());
        }
        return 0;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        deleteHead();
        appendTail(5);
        appendTail(2);
        deleteHead();
        deleteHead();
        res.forEach(System.out::println);
    }
}
