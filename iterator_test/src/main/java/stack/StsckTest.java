package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 18:51
 */
public class StsckTest {
    public static void main(String[] args) {
/*        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());*/
        Queue<Integer> stack=new LinkedList<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
    }
}
