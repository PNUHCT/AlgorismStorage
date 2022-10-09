import java.util.*;

public class lps {
    public static void main(String[] args) {
        int output = LPS("abbbcc");
        System.out.println(output); // --> 0

        output = LPS("aaaa");
        System.out.println(output); // --> 2

        output = LPS("aaaaa");
        System.out.println(output); // --> 2

        output = LPS("abccab");
        System.out.println(output); // --> 2

        String test = "aabfaac";
        String front = test.substring(0, test.length()/2);
        String back = test.substring(test.length()/2+1, test.length());
        System.out.println(front);
        System.out.println(back);
    }

    public static int LPS (String str) {
        /*
        1. 주어진 문자열을 반으로 나눈다
        2. 반쪽짜리 앞에서 prefix를 반쪽짜리 뒤에서 suffix를 arraylist로 구한다
        3. 두 arraylist를 비교해서 같고, 해당 요소의 길이가 max보다 크면, 길이를 max에 할당
        4. max return
         */

        // 문자열 준비 ------------------------------------------
        String front = "";
        String back = "";

        if (str.length()%2==1) { // str의 길이가 홀수일 때,
            front = str.substring(0, str.length()/2);
            back = str.substring(str.length()/2+1,str.length());
        }
        else if(str.length()%2==0) { // str의 길이가 짝수일 때,
            front = str.substring(0, str.length()/2);
            back = str.substring(str.length()/2, str.length());
        }
//
//        // 조건 만들기 1 : 접두어와 접미어를 모두 모아 비교하는 방법 ------------------------------------------
//        ArrayList<String> list1 = new ArrayList<>();
//        ArrayList<String> list2 = new ArrayList<>();
//        String temp1 = "";
//        String temp2 = "";
//        int max = 0;
//
//        for (int i=0 ; i<front.length() ; i++) {
//            temp1 += front.charAt(i);
//            list1.add(temp1);
//        }
//
//        for (int i=back.length()-1 ; i>=0 ; i--) {
//            temp2 = back.charAt(i) + temp2;
//            list2.add(temp2);
//        }
//
//        for (int j=0 ; j < list1.size() ; j++) {
//            if(list1.get(j).equals(list2.get(j)) && max<=list1.get(j).length()) {
//                max = list1.get(j).length();
//            }
//        }
//
//        return max;
//
        // 조건 만들기 2 : 접두어와 접미어 만드는 과정에서 비교하기
        String temp1 = "";
        String temp2 = "";
        int max = 0;

        for (int i = 0; i < front.length(); i++) {
            temp1 += front.charAt(i);
            temp2 = back.charAt(front.length()-1-i) + temp2;
            if (temp1.equals(temp2) && max <= temp1.length()) max = temp1.length();
        }

        return max;
    }
}
