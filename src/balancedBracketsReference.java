import java.util.*;

/*
    1. 괄호가 짝이 맞는지
    2. 여는 괄호 다음에 닫느 괄호가 나오는지
    3. 최근에 연 괄호가 닫히기 전에 다른 괄호가 닫히는건 아닌지 확인
 */



public class balancedBracketsReference {
    public class balancedBrackets {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("괄호를 입력해 주세요.");
            String n = sc.nextLine();

            System.out.println(String.format("결과는 %b입니다.",balancedBrackets(n)));
        }


    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> opener = new HashMap<>();
        opener.put('{', '}'); opener.put('[', ']'); opener.put('(', ')');
        String closer = "}])";

        for(int i = 0; i < str.length(); i++) {
            // 여는 괄호 => 스택에 추가
            if(opener.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            }
            // 닫는 괄호 + 스택에 여는 괄호가 존재
            else if(closer.indexOf(str.charAt(i)) != -1 && stack.size() > 0) {
                char top = stack.pop();
                char pair = opener.get(top);
                if(pair != str.charAt(i)) {
                    return false;
                }
            }
            // 그 외의 경우 == 닫는 괄호 && 스택이 비어있음
            else return false;
        }

        return stack.size() == 0;  // 불린값으로 리턴된다
    }
}
