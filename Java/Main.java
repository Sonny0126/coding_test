import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 각 번호 부여, 도로 부여
        // K시간 이하로 배달 가능
        // 1번마을에서 받을수 있는 주문 개수 return
        boolean [] viistted = new boolean[N];
        System.out.println(bfs(1, road, viistted));

        return answer;
    }

    String bfs(int start, int[][]road, boolean[]viistted){
      StringBuilder sb = new StringBuilder();
      Queue<Integer> q = new LinkedList<>();
      q.offer(start);
      viistted[start]=true;

      while(!q.isEmpty()){
        int node = q.poll();
        sb.append(node + " -> ");
        //큐에서 꺼낸 노드와 연결된 간선 체크
        for(int i=0; i<road[node].length; i++){
          int temp = road[node][i];
          //방문하지 않았으면 방문처리 후에 큐에 삽입
          if(!viistted[temp]){
            viistted[temp] = true;
            q.offer(temp);
          }
        }
      }
      return sb.toString();
    }
}