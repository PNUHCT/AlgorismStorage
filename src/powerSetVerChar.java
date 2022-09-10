import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class powerSetVerChar {
    private static final char[] characters = {'A', 'B', 'C', 'D', 'E'};

    public static void main(String[] args) {
        final Stack<Character> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        search(stack, 0, result);

        Collections.sort(result);
        System.out.println(result);
    }

    private static void search(Stack<Character> stack, int k, ArrayList<String> result) {
        if(k >= characters.length) {
            String temp = "";
            Stack<Character> stack2 = new Stack<>();
            Stack<Character> stack3 = new Stack<>();
            while(stack.size()!=0) {
                stack3.push(stack.peek());
                stack2.push(stack.pop());
            }
            while(stack3.size()!=0) stack.push(stack3.pop());
            while(stack2.size()!=0) temp += stack2.pop();

            result.add(temp);

        } else {
            stack.push(characters[k]);
            search(stack, k+1, result);

            stack.pop();
            search(stack, k+1, result);
        }
    }
}