import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 200 * 100000 + 1; //에러 안나는 최대값
        int[][] dist = new int[n + 1][n + 1];

        // 1. 최단 거리 테이블 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 2. 주어진 간선 정보 채우기 (양방향)
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }

        // 3. 플로이드-워셜 알고리즘으로 모든 쌍 최단 거리 계산
        //플로이-워셜 알고리즘은 그래프에서 가능한 모든 노드 쌍에 대해 최단거리를 구하는 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 4. 모든 노드를 경유지 k로 하여 최저 요금 탐색
        int MIN = INF;
        for (int k = 1; k <= n; k++) {
            // S->k(합승 구간) + k->A(A 혼자)+ k->B(B 혼자)
            int sum = dist[s][k] + dist[k][a] + dist[k][b];
            MIN = Math.min(MIN, sum);
        }

        return MIN;
    }
}