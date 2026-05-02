#include <stdio.h>
#include <stdbool.h>

int solution(int** signals, size_t n, size_t m) {

    // 충분히 큰 시간까지 확인 (최대 20초 주기라서 10000이면 충분)
    for (int t = 1; t <= 10000; t++) {

        bool allYellow = true;

        for (int i = 0; i < n; i++) {
            int G = signals[i][0];
            int Y = signals[i][1];
            int R = signals[i][2];

            int cycle = G + Y + R;

            // 시간은 1초부터 시작 → (t-1)
            int cur = (t - 1) % cycle;

            // 노란불이 아니면 탈락
            if (cur < G || cur >= G + Y) {
                allYellow = false;
                break;
            }
        }

        // 모든 신호등이 노란불이면 정답
        if (allYellow) return t;
    }

    return -1;
}