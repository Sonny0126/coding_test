class Solution {
    public int[] solution(int n) {

        int[][] arr = new int[n][n];

        // 아래, 오른쪽, 왼쪽 위
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;
        // 전체 칸 개수
        int total = n * (n + 1) / 2;

        while (num <= total) {
            arr[x][y] = num++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 갈 수 없으면 방향 변경
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        // 1차원 배열 변환
        int[] answer = new int[total];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}