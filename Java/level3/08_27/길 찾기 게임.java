import java.util.*;

class Solution {

  static class Node {
    int x;
    int y;
    int num;

    Node left;
    Node right;

    Node(int x, int y , int num){
      this.x=x;
      this.y=y;
      this.num=num;
    }
  }

    public int[][] solution(int[][] nodeinfo) {
        // 
        int n = nodeinfo.length;
        //노드 생성
        Node [] nodes = new Node [n];

        for(int i=0; i<n; i++){
          int x= nodeinfo[i][0];
          int y =nodeinfo[i][1];

          //노드 번호는 1부터 시작
          nodes[i] = new Node(x,y,i+1);
        }

        //y는 내림차순, y가 같으면 x 오름차순
        Arrays.sort(nodes, (a,b)-> {
          if(a.y != b.y){
            return Integer.compare(b.y, a.y);
          }
          return Integer.compare(a.x, b.x);
        });

        //첫번째 노드가 루트
        Node root = nodes[0];

        for(int i=1; i<n; i++){
          insert(root, nodes[i]);
        }

        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder =new ArrayList<>();

        preorder(root, preorder);
        postorder(root, postorder);
        
        int [][] answer = new int[2][n];

        for(int i=0; i<n; i++){
          answer[0][i] = preorder.get(i);
          answer[1][i] = postorder.get(i);
        }
        return answer;
    }

    //BST 방식으로 노드 삽입
    public void insert(Node parent, Node child){
      if(child.x < parent.x){
        if(parent.left == null){
          parent.left = child;
        }
        else{
          insert(parent.left, child);
        }
      }
      else{
        if(parent.right ==null){
          parent.right =child;
        }
        else{
          insert(parent.right, child);
        }
      }
    }

    public void preorder(Node node, List<Integer> result){
      if(node == null)
        return;

      result.add(node.num);

      preorder(node.left, result);
      preorder(node.right, result);
    }

    public void postorder(Node node, List<Integer> result) {

        if (node == null) 
            return;

        postorder(node.left, result);
        postorder(node.right, result);

        result.add(node.num);
    }
}