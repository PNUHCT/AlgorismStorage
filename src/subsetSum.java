import java.util.*;

public class subsetSum {
    public static void main(String[] args) {
        int output = subsetSum(new int[]{20, 80, 99, 27, 35}, 100);
        System.out.println(output); // --> 100 (= 20 + 80)

        int output2 = subsetSum(new int[]{1, 8, 3, 15}, 10);
        System.out.println(output2); // --> 9 (= 1 + 8)
    }

    public static int subsetSum(int[] set, int bound) {
        Arrays.sort(set);
        int temp1 = 0;
        int temp2 = 0;

        for (int i = 0; i < set.length; i++) {
            if (set[i] <= bound) temp1 = set[i];
            else if(set[i] > bound) break;
        }

        for (int i = 0; i < set.length; i++) {
            for (int j = set.length-1 ; j >= 0 ; j--) {
                int num = set[i] + set[j];
                if(num>temp2 && num<=bound) temp2 = num;
                if(temp2==bound) break;
            }
        }

        if(temp1<=temp2) return temp2;
        return temp1;
    }
}
