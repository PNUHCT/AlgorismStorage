import java.util.*;

// 배열 합쳐버리는 방법
import static java.util.Arrays.copyOf;

public class getItemFromTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result);
    }

    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        // TODO:
        int[] arr3 = copyOf(arr1,arr1.length+arr2.length);
        for(int i=0 ; i<arr2.length ; i++) {
            arr3[i+arr1.length] = arr2[i];
        }
        Arrays.sort(arr3);
        return arr3[k-1];
    }
}
