public class tilingDp {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(tiling(num));
    }

    public static int tiling(int num) {
        // 피보나치로 푸는 법 (=DP)
        if(num==1) return 1;
        int [] arr = new int[num];
        arr[0] = 1;
        arr[1] = 2;

        for(int i=2 ; i < num ; i++ ){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[num-1];
    }
}
