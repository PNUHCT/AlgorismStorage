import java.util.*;

public class LIS {
    public static void main(String[] args) {
        int output = LIS(new int[]{3, 2});
        System.out.println(output); // --> 1 (3 or 2)

        output = LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // --> 3 (3, 10, 20)
    }

    // 모든 부분 배열을 ArrayList에 받아 비교하는 부분
    public static int LIS(int[] input) {
        int max = 1;
        Stack<Integer> stack = new Stack<>();
        ArrayList<int[]> list = new ArrayList<>();

        search(stack, 0, input, list);

        for(int i = 0; i < list.size(); i++) {
            int[] tempArr = list.get(i);
            for(int j = 0; j < tempArr.length-1 ; j++) {
                if(tempArr[j]>=tempArr[j+1]) break;
                if(j==tempArr.length-2 && max<tempArr.length) max=tempArr.length;
            }
        }
        return max;
    }

    // 모든 부분 배열을 생성해서 ArrayList에 담아주는 부분
    private static void search(Stack<Integer> stack, int k, int[] input, ArrayList<int[]> list) {
        if(k >= input.length) {
            int[] temp = new int[stack.size()];
            Stack<Integer> stack2 = new Stack<>();
            for(int i = 0; i < temp.length; i++) {
                stack2.push(stack.pop());
            }
            for(int i = 0; i < temp.length; i++) {
                temp[i]=stack2.peek();
                stack.push(stack2.pop());
            }
            list.add(temp);
        }
        else {
            stack.add(input[k]);
            search(stack, k + 1, input, list);

            stack.pop();
            search(stack, k + 1, input, list);
        }
    }
}
