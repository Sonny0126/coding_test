import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //각 지역과 연결되어 있는 지역들을 저장할 리스트
        List<Integer>[] graph = new ArrayList[n+1];

        for(int i=1; i<=n ;i++){
          graph[i]= new ArrayList<>();
        }

        //2. 양방향 길이므로 서로 연결해주기
        for(int []road : roads){
          int a = road[0];
          int b = road[1];
          graph[a].add(b);
          graph[b].add(a);
        }

        //3. destination에서 각 지역까지의 최단거리를 저장
        int[] distance = new int[n+1];

        //아직 방문하지 않은 지역을 -1로 설정
        Arrays.fill(distance, -1);

        //destination에서 destion까지 거리는 0
        distance[destination]=0;

        //4. BFS를 위한 queue
        Queue<Integer> q = new LinkedList<>();

        q.offer(destination);

        //5. BFS 시작
        while(!q.isEmpty()){
          int cur = q.poll();

          //현재 지역과 연결된 모든 지역 확인
          for(int next : graph[cur]){
            //이미 방문한 지역이라면 넘어감
            if(distance[next] != -1){
              continue;
            }
            //현재 지역까지 거리 + 1
            distance[next] = distance[cur] + 1;

            //다음 탐색을 위해 queue에 넣기
            q.offer(next);
          }
        }

        //6. sources에 있는 지역들의 최단 거리 구하기
        int [] answer = new int [sources.length];

        for(int i=0; i<sources.length; i++){
          int source = sources[i];
          answer[i]=distance[source];
        }
        return answer;
    }
}