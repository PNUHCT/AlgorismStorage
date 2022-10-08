import java.util.*;

// 모든 경우의 수를 구해서 비교하는 방식 (다 구하느라 시간복잡도가 오래걸림)
public class orderOfPresentation {
    public static void main(String[] args) {
        int[] N = {1, 2, 3};

        int a = orderOfPresentation(3, new int[]{2,3,1});
        System.out.println(a);
    }

    public static int orderOfPresentation(int N, int[] K) {
        // 조합뽑기용 메서드에 넣을 인자들 선언하는 부분
        int[] base = new int[N];
        for (int i = 1; i <= N; i++) base[i-1] = i;
        ArrayList<String> cases = new ArrayList<>();
        ArrayList<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[N];

        // 조합기 돌림
        perm(list, visited, 0, N, new int[]{},base, cases);

        // 조합 비교 부분
        String strK = Arrays.toString(K);
        int result = 0;
        for (int i = 0; i < cases.size(); i++) {
            if(cases.get(i).equals(strK)) {
                result = i;
                break;
            }
        }

        // 반환
        return result;
    }

    // 조합기 부분
    public static ArrayList<int[]> perm (ArrayList<int[]> list, boolean[] visited, int depth, int n, int[] arr, int[] base, ArrayList<String> cases) {
        // r개 뽑았을 때, list에 추가
        if(depth == n) {
            list.add(arr);
            cases.add(Arrays.toString(arr));
            return list;
        }

        // 재귀로 순열의 경우 모두 검색
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // arr는 특성상 추가가 안되므로, 새로 만들고 복붙해줘야함
                int[] tempArr = Arrays.copyOf(arr, arr.length+1);
                tempArr[tempArr.length - 1] = base[i];
                list = perm(list, visited, depth+1, n, tempArr, base, cases);
                visited[i] = false;
            }
        }
        return list;
    }
}
