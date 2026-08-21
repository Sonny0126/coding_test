import java.util.*;

class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board) {

      //경주로 부지 N x N
      // // 0 or 1(벽) // 직선도로 하나 100원, 코너 50
      //최소 비용 계산
      //최대한 직선을 많이 사용해서 목적지까지 도달
      //최소한 코너를 사용해서

        int n = board.length;

        if (n == 1) {
            return 0;
        }

        int[][][] dist = new int[n][n][4]; // 상, 하, 좌, 우

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 오른쪽
        if (board[0][1] == 0) {
            dist[0][1][3] = 100;
            pq.offer(new Node(0, 1, 3, 100));
        }

        // 아래
        if (board[1][0] == 0) {
            dist[1][0][1] = 100;
            pq.offer(new Node(1, 0, 1, 100));
        }

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (dist[cur.r][cur.c][cur.dir] < cur.cost) {
                continue;
            }

            for (int nextDir = 0; nextDir < 4; nextDir++) {

                int nr = cur.r + dr[nextDir];
                int nc = cur.c + dc[nextDir];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (board[nr][nc] == 1) {
                    continue;
                }

                int nextCost;

                if (cur.dir == nextDir) {
                    nextCost = cur.cost + 100;
                } else {
                    nextCost = cur.cost + 600;
                }

                if (nextCost < dist[nr][nc][nextDir]) {

                    dist[nr][nc][nextDir] = nextCost;

                    pq.offer(
                        new Node(nr, nc, nextDir, nextCost)
                    );
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(
                answer,
                dist[n - 1][n - 1][dir]
            );
        }

        return answer;
    }

    static class Node implements Comparable<Node> {

        int r;
        int c;
        int dir;
        int cost;

        Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}