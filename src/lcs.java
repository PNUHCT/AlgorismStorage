import java.util.*;

public class lcs {
    public static void main(String[] args) {
        int output = LCS("abcd", "aceb");
        System.out.println(output); // --> 2 ("ab" or "ac")

        output = LCS("acaykp", "capcak");
        System.out.println(output); // --> 4 ("acak")
    }

    public static int LCS(String str1, String str2) {
    /* TODO:
	1. 두 str에서 모든 부분 문자열을 구한다(멱집합)
	2. 각 문자열을 비교해서 일치하고, 문자열의 길이가 max값보다 크거나 같으면 => max에 그 길이를 할당
	3. 최종max 리턴
	*/
        // 각 문자열을 Arraylist로 변환
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(str1.split("")));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(str2.split("")));

//        System.out.println(list1);
//        System.out.println(list2);

        // search를 돌리기 위해 필요한 변수들 선언
        ArrayList<String> result1 = new ArrayList<>();
        ArrayList<String> result2 = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        search(stack, 0, result1, list1); // list1의 모든 부분집합(경우의수)을 result1에 담은 상태
        search(stack, 0, result2, list2); // list2의 모든 부분집합(경우의수)을 result2에 담은 상태
        // 모든 부분집합은 다 구한 상태

//        System.out.println(result1);
//        System.out.println(result2);

        // 최대 길이 구하기
        int max = 0;
        for (int i = 0; i < result1.size(); i++) {
            for (int j = 0; j < result2.size(); j++) {
                if(result1.get(i).equals(result2.get(j)) && result1.get(i).length()>=max) {
                    max = result1.get(i).length();
                }
            }
        }

        // result1의 부분집합 문자열 중 result2의 부분집합 문자열과 동일한 값이면서, 가장 긴 문자열의 길이를 받은 상태
        return max;
    }

    // input으로 들어오는 list라는 Arraylist의 인자의 모든 부분집합을 문자열로 구해서 result라는 Arraylist에 담아주는 void형 메서드
    private static void search(Stack<String> stack, int k, ArrayList<String> result, ArrayList<String> list) {
        if(k >= list.size()) {
            String temp = "";
            Stack<String> stack2 = new Stack<>();
            Stack<String> stack3 = new Stack<>();
            while(stack.size()!=0) {
                stack3.push(stack.peek());
                stack2.push(stack.pop());
            }
            while(stack3.size()!=0) stack.push(stack3.pop());
            while(stack2.size()!=0) temp += stack2.pop();

            result.add(temp);

        } else {
            stack.push(list.get(k));
            search(stack, k+1, result, list);

            stack.pop();
            search(stack, k+1, result, list);
        }
    }
}
