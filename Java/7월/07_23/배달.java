import java.util.*;

class Node {
    int to;
    int cost;

    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

class Solution {

    public int solution(int N, int[][] road, int K) {
        // 각 번호 부여, 도로 부여
        // K시간 이하로 배달 가능
        // 1번마을에서 받을수 있는 주문 개수 return

        //graph는 마을 번호를 관리
        List<List<Node>> graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            //그래프에 빈 리스트 추가
            graph.add(new ArrayList<>());
        }

        for(int[] r : road){
            //r[0]에서 갈수 있는 마을 r[1]과 거리r[2]그래프에 추가
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

        pq.offer(new Node(1,0));

        //우선순위 큐가 비어있기 전까지
        while(!pq.isEmpty()){
            Node now = pq.poll();
            //현재 우선순위 큐에서 꺼낸 경로가 > 이미 저장된 최단 경로보다 길다면, 볼 필요없으므로 건너뛰기
            if(now.cost > dist[now.to])
                continue;

            for(Node next : graph.get(now.to)){
                int newCost = dist[now.to] + next.cost;

                //더 짧은 경로 찾으면 갱신
                if(newCost < dist[next.to]){
                    //최단 거리 업데이트
                    dist[next.to] = newCost;
                    // 갱신된 거리 탐색 대상에 추가
                    pq.offer(new Node(next.to,newCost));
                }
            }
        }

        int answer = 0;

        //K시간 이하로 배달 가능한 마을 개수 계산
        for(int i=1;i<=N;i++){
            if(dist[i] <= K)
                answer++;
        }

        return answer;
    }
}