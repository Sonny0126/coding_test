class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        // 필요한 행 개수
        int h = (n + w - 1) / w;

        // 상자 세팅
        int[][] boxes = new int[h][w];

        for (int i = 0; i < n; i++) {
            int level = i / w;   // 층
            int pos = i % w;     // 가로 위치

            // 짝수층: 왼 -> 오
            if (level % 2 == 0) {
                boxes[level][pos] = i + 1;
            }
            // 홀수층: 오 -> 왼
            else {
                boxes[level][w - 1 - pos] = i + 1;
            }
        }

        // 원하는 상자의 위치 찾기
        int targetRow = 0;
        int targetCol = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (boxes[i][j] == num) {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }

        // 같은 열에서 위에 있는 박스 개수 세기
        for (int i = targetRow; i < h; i++) {
            if (boxes[i][targetCol] != 0) {
                answer++;
            }
        }

        return answer;
    }
}