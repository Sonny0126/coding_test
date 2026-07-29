import java.util.*;

class Solution {
    // 상, 하, 좌, 우 이동을 위한 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // X591X
    // X1X5X
    // X231X
    // 1XXX1
    
    public int[] solution(String[] maps) {
        int n = maps.length;        // 행 크기
        int m = maps[0].length();   // 열 크기
        
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        // 전체 지도 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 'X'가 아니고 아직 방문하지 않은 무인도를 찾은 경우
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    // BFS 탐색을 통해 해당 무인도의 전체 식량 합 계산
                    int sum = bfs(i, j, n, m, maps, visited);
                    list.add(sum);
                }
            }
        }

        // 지낼 수 있는 무인도가 없는 경우 [-1] 반환
        if (list.isEmpty()) {
            return new int[]{-1};
        }

        // 오름차순 정렬 후 int[] 배열로 변환
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 너비 우선 탐색 (BFS)
    public int bfs(int startX, int startY, int n, int m, String[] maps, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int sum = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 문자를 숫자로 변환하여 합산 ('5' - '0' = 5)
            sum += maps[x].charAt(y) - '0';

            // 상, 하, 좌, 우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 지도의 범위를 벗어나지 않고
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 'X'가 아니며 아직 방문하지 않았다면
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 방문 처리
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return sum;
    }
}