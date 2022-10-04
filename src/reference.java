import java.util.*;

public class reference {
    public static void main(String[] args) {
        int output = subsetSum(new int[]{20, 80, 99, 27, 35}, 100);
        System.out.println(output); // --> 100 (= 20 + 80)

        int output2 = subsetSum(new int[]{1, 8, 3, 15}, 10);
        System.out.println(output2); // --> 9 (= 1 + 8)
    }

    public static int subsetSum(int[] set, int bound) {
        int max = 0;

        boolean[] cached = new boolean[301];
        for(int member : set) {
            ArrayList<Integer> reachables = new ArrayList<>();
            for(int wanted = 1; wanted <= bound - member; wanted++) {
                if(cached[wanted]) {
                    int reached = wanted + member;
                    reachables.add(reached);
                    if(reached > max) max = reached;
                }
            }

            for(int data : reachables) cached[data] = true;

            if (member <= bound) {
                cached[member] = true;
                if (member > max) max = member;
            }
        }
        return max;
    }
}
