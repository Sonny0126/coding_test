import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {

        // 2차원 배열 저장
        char[][] map = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
            }
        }

        int x = 0;
        int y = 0;

        // 시작 위치 S 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {

                if (map[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        // 동 서 남 북
        char[] dirArr = {'E', 'W', 'S', 'N'};

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 이동
        for (String route : routes) {

            String[] parts = route.split(" ");

            char dir = parts[0].charAt(0);
            int distance = Integer.parseInt(parts[1]);

            int nx = x;
            int ny = y;

            // 방향 찾기
            for (int i = 0; i < dirArr.length; i++) {

                if (dir == dirArr[i]) {

                    boolean possible = true;

                    // 한 칸씩 이동 검사
                    for (int d = 1; d <= distance; d++) {

                        int tx = x + dx[i] * d;
                        int ty = y + dy[i] * d;

                        // 범위 밖
                        if (tx < 0 || ty < 0 ||
                            ty >= park.length ||
                            tx >= park[0].length()) {

                            possible = false;
                            break;
                        }

                        // 장애물
                        if (map[ty][tx] == 'X') {
                            possible = false;
                            break;
                        }

                        nx = tx;
                        ny = ty;
                    }

                    // 이동 가능하면 적용
                    if (possible) {
                        x = nx;
                        y = ny;
                    }

                    break;
                }
            }
        }

        return new int[]{y, x};
    }
}