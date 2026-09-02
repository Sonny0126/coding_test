class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        // 현재 위치에서 목표까지의 최소 거리
        int distance = Math.abs(x - r) + Math.abs(y - c);

        // k번 안에 아예 도착할 수 없는 경우
        if (distance > k) {
            return "impossible";
        }

        // 남는 이동 횟수가 홀수면 도착할 수 없음
        if ((k - distance) % 2 != 0) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();

        // 이동 방향
        // 사전순: d < l < r < u
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] direction = {'d', 'l', 'r', 'u'};

        for (int count = 0; count < k; count++) {

            // d, l, r, u 순서
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 밖으로 나가는 경우
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                // 이 위치에서 목표까지 가는 최소 거리
                int remainDistance = Math.abs(nx - r) + Math.abs(ny - c);

                // 앞으로 남은 이동 횟수
                int remainMove = k - count - 1;

                // 남은 횟수로 목표에 도착할 수 있는지 확인
                if (remainDistance <= remainMove && (remainMove - remainDistance) % 2 == 0) {
                    //방향 선택
                    answer.append(direction[i]);

                    x = nx;
                    y = ny;

                    break;
                }
            }
        }
        return answer.toString();
    }
}