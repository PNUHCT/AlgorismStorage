import java.util.*;

public class tiling {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(tiling(num));
    }

    public static int tiling(int num) {
        // TODO: 모든 타일을 세로 나열을 하고, 가로 나열이 n개일때 한 칸씩 이동하는 조합의 수를 구하기
        // 무조건 1가지 이상의 경우의 수(num이 1이상의 자연수이므로)

        // num이 홀수일 때,
        // 반복은 num의 1/2보다 작은 자연수만큼
        // 세로방향타일 > 가로방향타일 일때, 세로방향타일개수+1 중 가로방향타일의 개수만큼 뽑는 경우의 수 => nCr = (세로방향타일개수+1)C(가로방향타일개수)
        // 세로방향타일 < 가로방향타일 일때, 가로방향타일개수+1 중 세로방향타일의 개수만큼 뽑는 경우의 수 => nCr = (가로방향타일개수+1)C(세로방향타일개수)
        // 세로방향타일 = 가로방향타일 일때, 위의 두가지 중 아무쪽이나 상관 없음

        // num이 짝수일 때,
        // 반복은 num의 1/2을 포함한 자연수만큼
        // 세로방향타일 > 가로방향타일 일때, 세로방향타일개수+1 중 가로방향타일의 개수만큼 뽑는 경우의 수 => nCr = (세로방향타일개수+1)C(가로방향타일개수)
        // 세로방향타일 < 가로방향타일 일때, 가로방향타일개수+1 중 세로방향타일의 개수만큼 뽑는 경우의 수 => nCr = (가로방향타일개수+1)C(세로방향타일개수)
        // 세로방향타일 = 가로방향타일 일때, 위의 두가지 중 아무쪽이나 상관 없음

        // num이 홀수 또는 짝수일 때, 반복으로 나온 경우의 수를 모두 더해서 반환

        // nCr = n!/(n-r)!

        int count = 1;
        if(num%2==0) {
            for(int i=1 ; i<=num/2 ; i++) {
                int hor = i*2; //가로타일이 차지하는 영역, 가로타일의 개수는 i
                int ver = num-hor; //세로타일의 개수
                if(ver>=i) {
                    // (ver+1) C i = (ver+1)! / ((ver+1)-i)!
                    count += fact(ver+1)/fact((ver+1)-i);
                }
                else if(ver<i) {
                    // (i+1) C ver
                    count += fact(i+1)/fact((i+1)-ver);
                }
            }
        }

        // num이 홀수일때
        if(num%2!=0) {
            for(int i=1 ; i<=num/2 ; i++) {
                int hor = i*2;
                int ver = num-hor;
                if(ver>=i) {
                    // (ver+1) C i = (ver+1)! / ((ver+1)-i)!
                    count += fact(ver+1)/fact((ver+1)-i);
                }
                else if(ver<i) {
                    // (i+1) C ver
                    count += fact(i+1)/fact((i+1)-ver);
                }
            }
        }
        return count;
    }

    // 팩토리얼 재귀 식
    public static int fact(int n) {
        if (n <= 1) return n; // 재귀 base 케이스. 즉, 1까지만 곱한단 소리
        else return fact(n-1) * n; // 지금 수*하나 작은 수. 하나 작은 수는 다시 재귀로 하나 더 작은수로 곱을 반복
    }
}
