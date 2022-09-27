import java.util.ArrayList;

public class lscs {
    public static void main(String[] args) {
        int output = LSCS(new int[]{1, 2, 3, -4, 5});
        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])
    }

    // 그냥 모든 연속 배열 중 가장 큰값
    public static int LSCS(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int max = arr[i];
            list.add(max);
            for(int j = i+1; j < arr.length; j++) {
                max += arr[j];
                list.add(max);
            }
        }

        int output = list.get(0);
        for(int k=0; k < list.size(); k++) {
            if(output<=list.get(k)) output = list.get(k);
        }

        return output;
    }



    // 연속된 숫자가 나오는 연속 배열에서 합의 최대값을 구하는 방식
    public static int LSCS2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < arr.length; i++) {
            max += arr[i];
            for(int j = i+1 ; j < arr.length; j++) {
                if(arr[i]+1!=arr[j]) {
                    list.add(max);
                    max =0;
                    break;
                }
                max += arr[j];
            }
        }

        int output = list.get(0);
        for(int k=0 ; k < list.size() ; k++) {
            if(list.get(k)>=output) output = list.get(k);
        }

        return output;
    }
}
