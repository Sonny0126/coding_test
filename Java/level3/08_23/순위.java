class Solution {
    public int solution(int n, int[][] results) {
        
        //n명의 권투선수 1~n번
        // 실력: A>B 이면, 항상이김
        //순위 매겨야 하는데 몇몇결과 누락해서 순위 매길수 없음
        // 정확하게 계산할 수 있는 선수의 수를 return
        
        //내가 이긴 선수의 수 + 나를 이긴 선수의 수 = n-1

        // graph[i][j] = true 면 i가 j를 이겼다는 의미
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] r : results) {
            int win = r[0];
            int lose = r[1];
            graph[win][lose] = true;
        }

        // 플로이드-워셜: i가 k를 이기고, k가 j를 이겼다면 -> i가 j를 이김
        for (int k = 1; k <= n; k++) {          // 거쳐가는 노드
            for (int i = 1; i <= n; i++) {      // 출발 노드
                for (int j = 1; j <= n; j++) {  // 도착 노드
                    // i가 k이기고, k가 j이기면, i는 j를 이긴다
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        // 각 선수마다 승패 관계가 확실한 상대의 수 카운트
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                // i가 j를 이겼거나, j가 i를 이긴 경우
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            // 자신을 제외한 n-1명과의 승패를 모두 안다면 순위 확정
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}