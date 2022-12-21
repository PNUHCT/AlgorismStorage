import java.io.*;
import java.util.*;

public class sejunsevi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        br.readLine();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken()); // 첫 번째 줄의 첫 숫자
            int num2 = Integer.parseInt(st.nextToken()); // 첫 번째 줄의 두번째 숫자
            String[] sejun = br.readLine().split( " ");
            String[] sevi = br.readLine().split( " ");
            int max1 = maximum(num1, sejun);
            int max2 = maximum(num2, sevi);

            if(max1>=max2) bw.write("S"+"\n");
            else if(max1<max2) bw.write("B"+"\n");
            else bw.write("C"+"\n");
            br.readLine();
        }
//        bw.flush(); // stream을 플러쉬 함
        bw.close();  // stream을 플러쉬 하고, stream을 닫음
    }

    private static int maximum(int num, String[] arr) {
        int max = 0;
        for(int i=0; i<num ; i++) {
            int b = Integer.parseInt(arr[i]);
            if(max<=b) max = b;
        }
        return max;
    }

}
