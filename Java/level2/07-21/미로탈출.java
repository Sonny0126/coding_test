import java.util.*;

class Solution {

    // 이동 방향 : 위, 아래, 왼쪽, 오른쪽
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        // 시작점(S), 레버(L) 위치 찾기
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }

        // 시작점 -> 레버까지 거리
        int startToLever = bfs(maps, startX, startY, 'L');
        // 레버에 갈 수 없다면 탈출 불가능
        if (startToLever == -1) {
            return -1;
        }
        // 레버 -> 출구까지 거리
        int leverToExit = bfs(maps, leverX, leverY, 'E');
        // 출구에 갈 수 없다면 탈출 불가능
        if (leverToExit == -1) {
            return -1;
        }
        // 두 거리의 합이 최종 이동 거리
        return startToLever + leverToExit;
    }

    //최단거리 구할 때 bfs, 모든경로 탐색 or 경우 찾을 때 dfs
    public int bfs(String[] maps, int startX, int startY, char target) {
        // 방문 여부 체크 배열
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        // Queue에 [x좌표, y좌표, 이동거리] 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            // 현재 위치 꺼내기
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int distance = now[2];

            // 목표 지점 도착
            if (maps[x].charAt(y) == target) {
                return distance;
            }

            // 네 방향 이동
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 미로 범위를 벗어나면 이동 불가
                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length()) {
                    continue;
                }
                // 벽(X)이거나 이미 방문한 곳이면 이동 불가
                if (maps[nextX].charAt(nextY) == 'X'|| visited[nextX][nextY]) {
                    continue;
                }
                // 방문 처리
                visited[nextX][nextY] = true;
                // 이동 거리 +1 해서 저장
                queue.offer(new int[]{
                    nextX,
                    nextY,
                    distance + 1
                });
            }
        }
        // 목표 지점까지 갈 수 없는 경우
        return -1;
    }
}