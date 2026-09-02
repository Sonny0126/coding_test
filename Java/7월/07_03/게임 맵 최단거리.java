import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        //x 이동
        int[] dx = {-1, 1, 0, 0};
        //y 이동
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        //2차원 배열로 저장
        q.offer(new int[]{0, 0});

        //비기 전까지
        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 범위 벗어나면
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                //장애물이면
                if (maps[nx][ny] == 0)
                    continue;

                //길 있는 경우
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        //답 출력
        if (maps[n - 1][m - 1] == 1) return -1;
        else return maps[n - 1][m - 1];
    }
}