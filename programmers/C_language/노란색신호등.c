#include <stdio.h>
#include <stdbool.h>

// 최대공약수
int gcd(int a, int b) {
    while (b != 0) {
        int t = a % b;
        a = b;
        b = t;
    }
    return a;
}

// 최소공배수
int lcm(int a, int b) {
    return a / gcd(a, b) * b;
}

int solution(int** signals, size_t n, size_t m) {

    // 전체 주기 구하기
    int total_cycle = 1;

    for (int i = 0; i < n; i++) {
        int cycle = signals[i][0] + signals[i][1] + signals[i][2];
        total_cycle = lcm(total_cycle, cycle);
    }

    // LCM까지만 탐색
    for (int t = 1; t <= total_cycle; t++) {

        bool allYellow = true;

        for (int i = 0; i < n; i++) {
            int G = signals[i][0];
            int Y = signals[i][1];
            int R = signals[i][2];

            int cycle = G + Y + R;
            int cur = (t - 1) % cycle;

            if (cur < G || cur >= G + Y) {
                allYellow = false;
                break;
            }
        }

        if (allYellow) return t;
    }

    return -1;
}