import java.util.*;

public class reference {
    public static void main(String[] args) {
        int[] stuffArr = { 1, 11, 101, 1001, 10001 };
        int choiceNum = 2;
        System.out.println(newChickenRecipe(stuffArr, choiceNum));

    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        //사용 가능한 재료만 넣을 변수를 선언합니다
        ArrayList<Integer> freshArr = new ArrayList<>();

        //stuffArr를 순회하며 사용 가능한 재료만 freshArr리스트에 추가합니다
        for(int i = 0; i < stuffArr.length; i++) {
            //stuffArr[i]를 String타입으로 변환한 이후
            String str = String.valueOf(stuffArr[i]);
            //해당 값을 char타입의 배열로 바꾼 이후, 0이 들어간 갯수만큼 element 배열에 추가합니다.
            int[] element = str.chars().filter(c -> c == '0').toArray();
            //element 배열의 숫자가 2 이하인 경우('0'이 2번 이하인 재료의 경우)
            if(element.length <= 2) {
                //freshArr에 해당 재료를 넣어줍니다.
                freshArr.add(stuffArr[i]);
            }
        }
        //재료가 들어간 List를 오름차순으로 정렬합니다.
        Collections.sort(freshArr);

        //사용할 수 있는 재료가 없거나, 재료의 양보다 사용해야 할 갯수가 더 많은 경우 null을 반환합니다.
        if (freshArr.size() == 0 || freshArr.size() < choiceNum) return null;

        //결과를 담을 리스트를 선언합니다.
        ArrayList<Integer[]> result = new ArrayList<>();

        //해당 재료의 사용 여부를 확인할 배열을 선언합니다.
        boolean[] visited = new boolean[freshArr.size()];

        //순열 메소드를 사용하여 모든 경우의 수를 구하고, 해당 자료를 반환합니다.
        return permutation(choiceNum, new Integer[]{}, result, freshArr, visited, 0);
    }

    public static ArrayList<Integer[]> permutation(int choiceNum, Integer[] bucket, ArrayList<Integer[]> result, ArrayList<Integer> freshArr, boolean[] visited, int depth) {
        //사용한 재료의 숫자가 choiceNum에 도달한다면(재귀의 종료)
        if(depth == choiceNum) {
            //result에 재료가 저장된 bucket 배열을 넣어준 이후
            result.add(bucket);
            //해당 result를 반환합니다.
            return result;
        }

        //사용할 수 있는 신선한 재료의 수만큼 반복합니다.
        for(int i = 0; i < freshArr.size(); i++) {
            //해당 재료를 사용하지 않았다면
            if(!visited[i]) {
                //해당 재료의 사용 여부를 체크하고
                visited[i] = true;
                //bucket에 사용한 재료를 넣어줍니다. (새로운 배열 선언)
                Integer[] concatArray = Arrays.copyOf(bucket, bucket.length + 1);
                concatArray[concatArray.length - 1] = freshArr.get(i);

                //다시 재귀를 사용합니다.
                result = permutation(choiceNum, concatArray, result, freshArr, visited, depth + 1);
                //한번 재귀를 순회한 이후, 반복문을 다시 시작하기 위해 첫 시작재료의 사용여부를 false로 변경합니다.
                visited[i] = false;
            }
        }
        return result;
    }
}
