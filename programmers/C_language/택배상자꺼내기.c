#include <stdio.h>

int solution(int n, int w, int num) {
    // row, col 저장용 2차원 배열
    int position[101][2];

    // 배열 생성
    for (int i = 0; i < n; i++) {
        int row = i / w;
        int temp = i % w;

        // 짝수 줄: 왼->오, 홀수 줄: 오->왼
        int col = (row % 2 == 0) ? temp : (w - 1 - temp);

        position[i + 1][0] = row;
        position[i + 1][1] = col;
    }

    // 찾는 값 저장
    int targetRow = position[num][0];
    int targetCol = position[num][1];

    int cnt = 0;

    for (int i = 1; i <= n; i++) {
        if (i == num)
            continue;

        int r = position[i][0];
        int c = position[i][1];

        // 같은 열이고 위에 있는 상자인지 확인
        if (c == targetCol && r > targetRow) {
            cnt++;
        }
    }

    return cnt + 1;
}