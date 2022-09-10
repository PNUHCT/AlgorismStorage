import java.util.*;
import java.util.stream.Collectors;

public class powerSet {

    // IntelliJ에서 돌려보기위한 엔트리 포인트. str은 임의로 넣었다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("아무 문자열을 입력하고, Enter를 누르시오.");
        String str = scanner.nextLine();

        // 결과값 확인용 출력
        System.out.println(powerSet(str));
    }

    // 재귀를 돌리기 위한 준비단계 함수. 멱집합을 ArrayList형태로 받을 것이다
    public static ArrayList<String> powerSet(String str) {
        // 결과값인 멱집합 경우의 수 전체를 담을 ArrayList<String>
        ArrayList<String> result = new ArrayList<String>();

        // 입력받은 str을 한 글자씩 나누어 중복제거 및 sort해줄 과정
        String [] arr = str.split("");
        List<String> strList = Arrays.asList(arr);
        ArrayList<String> list = (ArrayList<String>) strList.stream().distinct().sorted()
                .collect(Collectors.toList());

        // 재귀문에서 나눠진 문자열을 부분집합의 요소로 담아줄 stack(바구니)
        final Stack<String> stack = new Stack<>();

        // 재귀 시작. 파라미터 : str을 담아줄 stack, list의 0번째 인덱스부터 시작할것이므로 0, result.add()로 부분집합을 받아줘야 하므로 넣음, 요소를 뽑아낼 목록인 list도 필요
        search(stack, 0, result, list);
        // search로 반환된 ArrayList는 긴것부터 뒤죽박죽으로 반환되므로, sort 필요
        Collections.sort(result);

        // 최종반환이라 봐도 됨(여기선 main메서드에 전달하고, main에서 최종 출력)
        return result;
    }

    // 리턴이 필요하지 않으므로 void 타입 (어차피 result에 add로 다 보낼것이므로)
    private static void search(Stack<String> stack1, int k, ArrayList<String> result, ArrayList<String> list) {
        // base case. 즉, 요소의 index는 list의 길이 -1까지이므로, 거기까지 반복.
        if(k >= list.size()) {
            // 임시 string. 한 글자씩 떼어진 stack안의 요소를 하나로 합쳐주기 위한 임시 string
            String temp = "";
            // stack으로 작업치기위해 stack 두개 더 필요함
            Stack<String> stack2 = new Stack<>(); // 거꾸로 된 순서의 배열을 반듯하게 저장하기위해 담는 stack
            Stack<String> stack3 = new Stack<>(); // stack1에서 stack2로 보내기만 하면 재귀가 안되므로, stack2에 보내고 나서, 다시 stack1에 채워주기 위해 요소를 임시로 담는 stack
            // stack1의 요소를 순서대로 만들기 위한 반복작업. 그렇다고 stack1의 순서가 훼손되면 안되므로, 일단 stack3에도 임시저장
            while(stack1.size()!=0) {
                stack3.push(stack1.peek()); // 임시저장(값의 복제라고 봐도 된다)
                stack2.push(stack1.pop()); // stack1을 비움과 동시에 stack2에 다시 쌓는 과정
            }
            while(stack3.size()!=0) stack1.push(stack3.pop()); // stack3에 임시저장한거 다시 stack1에 넣어주는 작업
            while(stack2.size()!=0) temp += stack2.pop(); // stack2에 바르게 쌓아놓은 것을 문자열로 바꿔주는 작업

            result.add(temp); // 바른 순서로 만든 문자열(하나의 경우의 수)을 result에 저장하는 작업

        } else {
            // k번째 인덱스에 해당하는 값을 포함한 경우의 수를 구하는 과정
            stack1.push(list.get(k));
            search(stack1, k+1, result, list);

            // k번째 인덱스에 해당하는 값을 제외한 경우의 수를 구하는 과정
            stack1.pop();
            search(stack1, k+1, result, list);
        }
    }
}
