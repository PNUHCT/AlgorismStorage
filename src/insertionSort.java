import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));
    }
    public static int[] insertionSort(int[] arr) {
        int[] output = new int[arr.length];

        for( int i= 0 ; i<arr.length ; i++) {
            int count= 0;
            for (int j= 0 ; j<arr.length ; j++) {
                if(arr[i]>arr[j]) count++;
            }
            output[count] = arr[i];
        }
        return output;
    }

}
