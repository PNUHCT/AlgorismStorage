import java.util.*;

public class treeDfs {
    public ArrayList<String> dfs(tree node) {
        // 최종 반환을 위한 ArrayList 생성
        ArrayList<String> currentList = new ArrayList<>();
        // 현재 노드의 value값 추가. 재귀를 통해 들어온 노드의 값이 추가된다
        currentList.add(node.getValue());

        // 자식노드가 있으면, 자식노드를 탐색
        if(node.getChildrenNode()!=null) {
            // 자식노드를 순차적으로 탐색
            for(int i=0 ; i<node.getChildrenNode().size() ; i++) {
                // 앞 순서의 자식노드를 재귀 돌리며, 재귀로 리턴되는 값은 자식노드의 값이 들어있는 ArrayList currentList가 된다(값추가는 currentList.add로 추가된 상태로 돌아오는 구조)
                // 반복문의 순서대로 자식노드가 들어있는 배열의 인덱스 0번째부터 순차적으로 값이 돌아온다
                ArrayList<String> recurList = dfs(node.getChildrenNode().get(i));
                // 재귀로 돌아온 자식노드의 ArrayList값을 현재 노드의 값 뒤에 전부 추가해주는 구조
                currentList.addAll(recurList);
            }
            // 1. 재귀를 통해 node값이 들어 올 때, 자식노드가 없는 경우 마지막 자식노드의 값이 반환되게 해준다.
            // 2. 최종 완성된 ArrayList를 반환해준다
        }
        return currentList;
    }

    // 트리구조 --------------
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }
        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }
        public String getValue() {  //현재 노드의 데이터를 반환 == node라는 키값에 대한 value값과 같은 느낌
            return value;
        }
        public ArrayList<tree> getChildrenNode() {  // 자식노드들이 있는 값 반환. 키값 같은것 반환
            return children;
        }
    }
}
