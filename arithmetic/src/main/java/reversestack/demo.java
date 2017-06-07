package reversestack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hechao on 2017/6/5.
 */
public class demo {
    public static void main(String[] args) {
        Stack<String> items = new Stack<String>();
        items.push("he");
        items.push("saw");
        items.push("saw1");
        items.push("saw2");
        items.push("saw3");


        reverseStack(items);

        while (items.size() > 0) System.out.println(items.pop());

    }

    public static void reverseStack(Stack<String> stack) {
        Queue<String> rev = new LinkedList<String>();
        while (stack.size() > 0) {
            rev.offer(stack.pop());
        }

        while (rev.size() > 0) {
            stack.push(rev.poll());
        }
    }
}
