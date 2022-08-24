import java.util.*;

public class bfsTree {
        public ArrayList<String> bfs(tree node) {
        /* 예시트리구조
              1
             / \             queue = {1, 2, 3, 4, 5, 6, 7, 8}
            2   3            curNode = {1, 2, 3, 4, 5, 6, 7, 8}
           / \ / \           result = {1, 2, 3, 4, 5, 6, 7, 8}
          4  5 6  7
         /
        8
        */
        // 우선 Queue를 생성한다. queue에 node를 순차적으로 넣어준다.(즉, 일종의 key값이 대기열로 들어감)
        Queue <tree> queue = new LinkedList<>();
        // 결과로 리턴할 ArrayList. node라는 tree타입 key값에 대응되는 String타입의 value값이 차곡차곡 들어간다
        ArrayList<String> result = new ArrayList<>();
        // 첫 번째 노드값을 queue대기열에 넣어준다. 현재 queue.size() = 1
        queue.add(node);

        // queue안에 add되는 모든 값들에 대해 순차적으로 반복. queue가 빌때까지
        while(queue.size()>0) {
            // 지역변수 설정(반복 한번당 생성되고 사라질 변수). 대기열의 첫번째 값을 받는다.
            tree curNode = queue.poll();
            // 일단 현재 처리중인 노드의 value값을 결과값 맨 뒤에 넣어준다
            result.add(curNode.getValue());
            // 현재 처리중인 노드에 자식노드가 있는 경우,
            if(curNode.getChildrenNode()!=null) {
                // 모든 자식들을 queue에 넣어준다. 이 경우, 상위 노드의 모든 자식이 이미 queue에 들어가 있기 때문에, 하위 노드들은 그 뒤로 후순위 처리가 된다.(BFS)
                queue.addAll(curNode.getChildrenNode());
            }
        }
        return result;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
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

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}