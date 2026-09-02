import java.util.*;

class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        int removed = 0;

        for(String req : requests) {
            char target = req.charAt(0);
            // 같은 알파벳이 두 번 반복 -> 크레인
            if(req.length() == 2 && req.charAt(0) == req.charAt(1)) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(map[i][j] == target) {
                            map[i][j] = '0';
                            removed++;
                        }
                    }
                }
            } 
            // 알파벳 하나 -> 지게차
            else {
                List<int[]> remove = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(map[i][j] == target && canRemove(map, i, j)) {
                            remove.add(new int[]{i, j});
                        }
                    }
                }

                // 찾은 컨테이너 제거
                for(int[] pos : remove) {
                    map[pos[0]][pos[1]] = '0';
                    removed++;
                }
            }
        }

        return n * m - removed;
    }


    // 지게차로 접근 가능한지 확인
    boolean canRemove(char[][] map, int r, int c) {

        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // 가장자리까지 연결되면 외부 접근 가능
            if(cur[0] == 0 || cur[0] == n - 1 ||
                cur[1] == 0 || cur[1] == m - 1) {
                return true;
            }

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                // 빈 공간을 통해 이동
                if(map[nr][nc] == '0' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}