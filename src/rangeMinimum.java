import java.util.Arrays;

// 단순하게 배열로 구하는 방법
public class rangeMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 7, 9, 11};
        int[][] ranges = new int[][]{
                {1, 4},
                {0, 3}
        };
        System.out.println(rangeMinimum(arr, ranges)[0]);
        System.out.println(rangeMinimum(arr, ranges)[1]);
    }

    public static int[] rangeMinimum(int[] arr, int[][] ranges) {
        int[] result = new int[ranges.length];

        for(int i = 0; i < ranges.length; i++) {
            int min = Arrays.stream(arr).max().getAsInt();
            for(int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                if(min>=arr[j]) min = arr[j];
            }
            result[i] = min;
        }
        return result;
    }
}
