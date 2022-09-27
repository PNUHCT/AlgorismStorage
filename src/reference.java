public class reference {
    public static void main(String[] args) {
//        int output = LSCS(new int[]{1, 2, 3, -4, 5});
//        int output2 = LSCS(new int[]{1,7,8,-10,100});
        int output3 = LSCS(new int[]{-10,-11,-12,-100});
//        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])
//        System.out.println(output2); // --> 7 ([1, 2, 3, -4, 5])
        System.out.println(output3); // --> 7 ([1, 2, 3, -4, 5])
    }

    public static int LSCS(int[] arr) {
        // 이중 저장 구조
        // 연속 배열의 합은 순차적으로 구하고, 최대값은 따로저장.
        // 최대값과 연속배열의 합을 비교하며 큰값만 교체해주는 구조
        // 만약, 모두 음수인 배열이면, 어차피 가장 큰 음수값 하나만 있는게 max임. 음수면 curSum을 0으로 초기화 하면 됨(더 더할필요 없으니까)
        int curSum = 0;
        int max = Integer.MIN_VALUE; // 음수를 포함하기 때문에 사용 가능한 최저 음수를 할당 : -2147483648이 최저값
        for(int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if(curSum > max) max = curSum;

            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }
}