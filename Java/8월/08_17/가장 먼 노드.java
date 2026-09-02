import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 연결
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        boolean[] visited = new boolean[n + 1];

        //1번 노드에서부터 떨어진 거리
        int[] distance = new int[n + 1];


        // BFS 
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;
        distance[1] = 0;


        // 5. BFS 탐색
        while (!q.isEmpty()) {

            int current = q.poll();

            // 현재 노드와 연결된 노드 확인
            for (int next : graph.get(current)) {

                // 이미 방문했다면 넘어가기
                if (visited[next]) {
                    continue;
                }

                // 방문 처리
                visited[next] = true;

                // 현재 노드보다 1만큼 멀리 있음
                distance[next] = distance[current] + 1;

                // 다음 탐색을 위해 큐에 넣기
                q.offer(next);
            }
        }


        // 가장 먼 거리 찾기
        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }


        // 가장 먼 노드의 개수 세기
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}