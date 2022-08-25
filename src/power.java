import java.util.*;

public class power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("base와 exponent값을 입력해주세요.");
        int base = scanner.nextInt();
        int exponent = scanner.nextInt();
        Long power = power(base, exponent);
        System.out.println(String.format("결과값은 %d입니다.", power));
    }

    public static long power(int base, int exponent) {
        /* TODO: base의 exponent제곱 출력하기
        인자 1: base
        int 타입의 자연수 (base >= 2)
        인자 2: exponent
        int 타입의 정수 (exponent >= 0)
        출력
        long 타입을 리턴해야 합니다.
        Math.pow, 거듭제곱 연산자 사용은 금지
        시간복잡도 O(logN)을 만족
        나머지를 구하는 이유는 계산 결과가 컴퓨터로 나타낼 수 있는 수의 범위를 넘을 수 있기 때문입니다. 하지만 모든 연산이 끝난 뒤에 그 결과를 94,906,249로 나누려고 해서는 안 됩니다. 연산 중간에도 이 범위를 넘을 수 있기 때문에, 연산을 할 때마다 나머지를 구하고 그 결과에 연산을 이어가시기 바랍니다.
         */

        long result = 1L;  // 결과로 내보낼 객체 생성
        for (int i=1 ; i<=exponent ; i++) {   // 제곱의 횟수는 exponent이며, exponent가 0일경우, result에 base를 곱하지 않은 채 1L을 그대로 리턴해야 하기 때문에, 반복의 시작은 1로 시작(즉, i가 0일경우, 1보다 작으므로 for문이 돌지않고 바로 리턴)
            result=result*base;
            if(result>94906249) {  // 94906249가 넘으면, 그 뒤로 복잡한 거듭제곱을 단순화해줌
                result = result%94906249;
            }
        }
        // return result%94906249; // 위에서 if문 없이 최종 리턴 직전에 나누면, 모든 수를 곱한 뒤에나오는 수를 다시 일일이 나눠줘야함
        return result;
    }
}
