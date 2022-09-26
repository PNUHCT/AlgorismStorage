import java.util.*;

public class radixSort {
    public static void main(String[] args) {
        int[] output = radixSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));
    }


    public static int[] radixSort(int[] arr) {
		/* TODO:
    1. counting sort로 배열생성 및 sort
    2. counting sort에 따른 인자를 queue에 집어넣음
    3. queue에 넣은 숫자를 차례로 Array에 대입 및 리턴
    */
        //max값 구하기
        int max = 0;
        for (int i=0 ; i<arr.length ; i++) {
            if(arr[i]>=max) max = arr[i];
        }

        // max+1 길이의 새 배열 만들어서 count
        int [] arr2 = new int[max+1];
        for(int j=0 ; j<arr.length ; j++) {
            arr2[arr[j]] += 1;
        }

        // arr2에 분류해놓은 인덱스 값을 queue에 순차적으로 저장
        Queue<Integer> que = new LinkedList<>();
        for (int k=0 ; k<arr2.length ; k++) {
            Integer temp = k;
            if(arr2[k]!=0) {
                for(int l=1 ; l<=arr2[k] ; l++) {
                    que.add(temp);
                }
            }
        }

        // queue에 저장한 인덱스당 갯수만큼 array에 추가d
        int[] output = new int[que.size()];
        for(int m=0 ; m<arr.length; m++) {
            output[m] = que.poll();
        }

        return output;
    }
}
