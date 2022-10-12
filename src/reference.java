import java.util.*;

// 트리구조로 구하는 방법
public class reference {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 7, 9, 11};
        int[][] ranges = new int[][]{
                {1, 4},
                {0, 3}
        };
        System.out.println(rangeMinimum(arr, ranges)[0]);
        System.out.println(rangeMinimum(arr, ranges)[1]);
    }

    static int[] tree;

    public static int[] rangeMinimum(int[] arr, int[][] ranges) {
        double log2 = Math.log(arr.length) / Math.log(2);
        double height = Math.ceil(log2);
        double size = Math.pow(2, height + 1) - 1;
        tree = new int[(int)size];
        Arrays.fill(tree, 0);
        createMinTree(arr, 0, arr.length - 1, tree, 0);
        return mins(ranges, arr);
    }

    public static int findMin(int ts, int te, int rs, int re, int idx) {
        if (rs <= ts && te <= re) {
            return tree[idx];
        }

        if (te < rs || re < ts) {
            return Integer.MAX_VALUE;
        }

        int mid = (ts + te) / 2;
        return Math.min(
                findMin(ts, mid, rs, re, 2 * idx + 1),
                findMin(mid + 1, te, rs, re, 2 * idx + 2)
        );
    }

    public static int[] mins(int[][] range, int[] arr) {
        int[] result = new int[range.length];
        for(int i = 0; i < range.length; i++) {
            int start = range[i][0];
            int end = range[i][1];
            result[i] = (findMin(0, arr.length - 1, start, end, 0));
        }
        return result;
    }

    public static int createMinTree(int[] arr, int ts, int te, int[] tree, int idx) {
        if(ts == te) {
            tree[idx] = arr[ts];
            return arr[ts];
        }
        int mid = (ts + te) / 2;
        tree[idx] = Math.min(
                createMinTree(arr, ts, mid, tree, (idx * 2) + 1),
                createMinTree(arr, mid + 1, te, tree, (idx * 2) + 2)
        );
        return tree[idx];
    }
}