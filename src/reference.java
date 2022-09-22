import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class reference {
    public static void main(String[] args) {

        Instant start = Instant.now();

//        int [] arr = {3,1,21};
//        int[] arr = {1, 2, 43, 100, 21};
        int[] arr = {20,-10,-11,2,29};
        int[] arr2 = quickSort(arr);
        System.out.println(Arrays.toString(arr2));

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("elapsedTime(ms) : " + elapsedTime);
    }

    public static int[] quickSort(int[] arr) {
        //빈 배열일 경우
        if (arr.length == 0) return arr;

        int left = 0;
        int right = arr.length - 1;

        return sort(arr, left, right);
    }

    //퀵 정렬 메서드
    private static int[] sort(int[] arr, int left, int right) {
        //partition 메서드를 활용하여 정렬
        int part = partition(arr, left, right);
        if (left < part - 1) arr = sort(arr, left, part - 1);
        if (right > part) arr = sort(arr, part, right);

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 배열의 중앙을 기준으로
        int pivot = arr[(left + right) / 2];
        //좌측이 우측보다 작을 경우, 즉 아직 모든 배열을 순회하지 않은 경우 반복
        while (left <= right) {
            //좌측의 수가 기준점보다 작다면
            while (arr[left] < pivot) left++;
            //우측의 수가 기준점보다 크다면
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
