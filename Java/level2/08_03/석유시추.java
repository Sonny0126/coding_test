import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;

        int[] arr = new int[col];
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //석유가 있으며, 방문하지 않은 곳이라면
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int size = 0;

                    //석유 덩어리가 포함하는 열들(중복을 제거하기 위해)
                    HashSet<Integer> set = new HashSet<>();

                    //BFS 시작
                    while (!q.isEmpty()) {
                        //현재 위치 꺼내기
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];

                        //석유 크기 1증가
                        size++;
                        //현재 위치 열 번호 저장
                        set.add(y);

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= row || ny >= col)
                                continue;

                            if (visited[nx][ny])
                                continue;

                            if (land[nx][ny] == 0)
                                continue;

                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }

                    // 이 덩어리가 지나가는 모든 열에 석유량 size 더하기
                    for (int c : set) {
                        arr[c] += size;
                    }
                }
            }
        }

        //최대 석유량 반환
        for (int MAX : arr) {
            answer = Math.max(answer, MAX);
        }

        return answer;
    }
}