import java.util.*;

public class balancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("괄호를 입력해 주세요.");
        String n = sc.nextLine();

        System.out.println(String.format("결과는 %b입니다.",balancedBrackets(n)));
    }

    public static boolean balancedBrackets(String str) {
        // 스택을 사용
        // HashMap.containsKey(키값) = 키값이 해쉬맵에 키값으로 있는지 확인
        // 괄호의 뒷 부분을 따로 문자열로 선언
        // str을 순회
        // 1. 현재 순서가 여는 괄호일 경우 (=해쉬맵에 현재문자열값이 key로 존재할 경우)
        // 스택에 현재 문자열 push
        // 2. 현재 문자열이 닫는 괄호일 경우(닫는괄호 문자열의 인덱스값이 012중 하나일경우) + 스택이 비어있지 않을 경우(stack.size()>0)
        // 현재 문자열과 스택에서 pop한 값의 value값을 비교
        // 2-1. 비교한 값이 다르면 return false
        // 3. 현재 문자열이 닫는 괄호일 경우 + 스택이 비어있을 경우
        // return false

        // 다 처리하고난 후, 스택이 남아있지 않으면 true. 남아있으면 false

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> open = new HashMap<>();
        open.put('(',')'); open.put('{','}'); open.put('[',']');
        String close = ")}]";

        for (int i=0 ; i<str.length() ; i++) {
            if(open.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            }
            else if (close.indexOf(str.charAt(i)) != 3 && stack.size() > 0) {
                char pop = open.get(stack.pop());

                if(pop != str.charAt(i)) return false;
            }
            else if (close.indexOf(str.charAt(i)) != 3 && stack.size() == 0) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
