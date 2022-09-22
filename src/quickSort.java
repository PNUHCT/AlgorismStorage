import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.time.Duration;
import java.time.Instant;


public class quickSort {
    // TODO:
    // I : 중첩없는 1차원 정수 배열, O : 정수 배열
    // arr.sort사용 금지
    // arr.length <= 100000
    public static void main(String[] args) {

        Instant start = Instant.now();

//        int [] arr = {3,1,21};
//        int[] arr = {1, 2, 43, 100, 21};
        int[] arr = {20,-10,-11,2,29};
        int [] arr2 = quickSort(arr);
        System.out.println(Arrays.toString(arr2));

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("elapsedTime(ms) : " + elapsedTime);
    }

    public static int[] quickSort(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        int[] output = new int[arr.length];

        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        while(!list.isEmpty()) {
            Integer a = list.get(0);
            for( int j=0 ; j < list.size() ; j++ ) {
                if(list.get(j)<a) {
                    list.remove(a);
                    list.add(a);
                    break;
                }
            }
            if(a<list.get(list.size()-1)) {
                q.add(a);
                list.remove(a);
            }
            if(list.size()==1) {
                q.add(list.get(0));
                list.remove(a);
            }
        }

        for( int k=0 ; k<arr.length ; k++ ) {
            output[k] = q.poll();
        }

        return output;
    }
}
