import java.util.*;

class Solution {
    // 상하좌우 이동을 위한 좌표 변환 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        // 5개의 대기실을 각각 검사
        for (int i = 0; i < 5; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1; // 거리두기 지킴
            } 
            else {
                answer[i] = 0; // 거리두기 위반
            }
        }
        return answer;
    }

    // 한 대기실이 거리두기를 잘 지켰는지 검사하는 함수
    private boolean checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                // 응시자(P)를 발견하면 해당 위치에서 BFS 실행
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(r, c, place)) {
                        return false; // 한 명이라도 거리두기를 위반했으면 false
                    }
                }
            }
        }
        return true;
    }

    // 특정 응시자 위치에서 거리 2 이내에 다른 P가 있는지 BFS 탐색
    private boolean bfs(int startR, int startC, String[] place) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        // {행, 열, 현재 이동 거리}
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // 자기 자신을 제외하고, 탐색 거리 1~2 사이에서 다른 응시자 P를 만나면 위반!
            if (dist > 0 && place[r].charAt(c) == 'P') {
                return false;
            }

            // 거리 2까지만 확장 (거리 2를 넘어가면 안전하므로 더 이상 탐색 안 함)
            if (dist < 2) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    // 대기실 범위를 벗어나지 않고
                    if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                        // 아직 방문하지 않았고, 파티션(X)이 아니라면 이동 가능
                        if (!visited[nr][nc] && place[nr].charAt(nc) != 'X') {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc, dist + 1});
                        }
                    }
                }
            }
        }

        return true; // 거리 2 이내에 다른 P를 안 만났다면 합격
    }
}