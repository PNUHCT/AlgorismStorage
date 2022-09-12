import java.util.*;

/*
1. 1부터 N까지 n개의 수 중에서, r개를 뽑아 나열하는 경우를 모두 배열로 만듦
2. 찾은 배열중 지정한 배열과 일치하는 경우가 몇번째로 나온 경우인지 순서를 출력
 */

public class permutation {
    // 엔트리 포인트
    public static void main(String[] args) {
        int N = 3;
        int[] K = {2,3,1};

        // 결과 출력부분
        System.out.println(orderOfPresentation(N,K));
    }

    // 팩토리얼 메서드
    public static int factorial (int n) {
        if (n <= 1) return n; // 재귀 base 케이스. 즉, 1까지만 곱한단 소리
        else return factorial(n-1) * n; // 지금 수*하나 작은 수. 하나 작은 수는 다시 재귀로 하나 더 작은수로 곱을 반복
    }

    // permutation(순열) 메서드
    public static ArrayList<int[]> perm (ArrayList<int[]> list,boolean[] visited, int depth, int n, int r, int[] arr, int[] base) {
        // r개 뽑았을 때, list에 추가
        if(depth == r) {
            list.add(arr);
            return list;
        }

        // 재귀로 순열의 경우 모두 검색
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // arr는 특성상 추가가 안되므로, 새로 만들고 복붙해줘야함
                int[] tempArr = Arrays.copyOf(arr, arr.length+1);
                tempArr[tempArr.length - 1] = base[i];
                list = perm(list, visited, depth+1, n, r, tempArr, base);
                visited[i] = false;
            }
        }

        // 최종 완성된 list 반환
        return list;
    }

    // 조건을 정하고, 지정배열과 순열로 나온 배열을 비교하는 메서드
    public static int orderOfPresentation(int N, int[] K) {
        // 총 순열 경우의 수
        int total = factorial(N);

        // 변수 선언부
        ArrayList<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[K.length];

        // 임의의 숫자 N까지의 숫자를 배열로 만듦
        int[] base = new int[N];
        for(int i=0 ; i<N ; i++) {
            base[i] = i+1;
        }

        // 순열로 된 ArrayList를 뽑아냄
        list = perm(list, visited, 0, N, K.length, new int[]{}, base);

        // 몇번쨰 순서인지 찾는 곳
        int num = 0;
        for (int i = 0; i < total; i++) {
            // 여기가 핵심. arr는 같은 형태라도 주소값이 서로다른 참조변수. 그냥 비교하면 주소값이 다르므로, Arrays.toString(arr)형식을 써야 안의 진짜 값을 비교할 수 있다.
            if(Arrays.toString(list.get(i)).equals(Arrays.toString(K))) num = i;
        }

        // 결과를 엔트리 포인트에 전달
        return num;
    }
}