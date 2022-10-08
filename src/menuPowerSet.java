import java.util.*;

public class menuPowerSet {
    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);

        output = missHouseMeal(new String[]{"pasta", "oysterSoup", "beefRibs", "tteokbokki"});
        System.out.println(output);
    }

    public static ArrayList<String[]> missHouseMeal(String[] arr) {
        ArrayList<String[]> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Arrays.sort(arr);

        search(arr, stack, 0, list);

        return list;
    }

    private static void search(String[] arr, Stack<String> stack, int k, ArrayList<String[]> list) {
        if(k >= arr.length) {
            System.out.println(stack.toString());
            String[] tempArr = stack.toArray(new String[]{});
            list.add(tempArr);
        } else {
            // 1. k를 부분집합에 포함한다.
            stack.add(arr[k]);
            search(arr, stack, k + 1, list);

            // 2. k를 부분집합에 포함하지 않는다.
            stack.pop();
            search(arr, stack, k + 1, list);
        }
    }
}
