import java.util.Stack;

public class powerSetVerNum {
    private static int n = 5;

    public static void main(String[] args) {
        final Stack<Integer> stack = new Stack<>();
        search(stack, 1);
    }

    private static void search(Stack<Integer> stack, int k) {
        if (k >= n + 1) {
            System.out.println(stack.toString()); // 부분 집합을 출력한다.
        } else {
            // 1. k를 부분집합에 포함한다.
            stack.add(k);
            search(stack, k + 1);

            // 2. k를 부분집합에 포함하지 않는다.
            stack.pop();
            search(stack, k + 1);
        }
    }
}
