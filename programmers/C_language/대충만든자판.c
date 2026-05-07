#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(
    const char* keymap[],
    size_t keymap_len,
    const char* targets[],
    size_t targets_len
) {

    // 알파벳 최소 클릭 수 저장
    int alpha[26];

    for(int i = 0; i < 26; i++) {
        alpha[i] = 101;
    }

    // keymap 최소값 저장
    for(int i = 0; i < keymap_len; i++) {

        for(int j = 0; keymap[i][j] != '\0'; j++) {

            int idx = keymap[i][j] - 'A';

            if(j + 1 < alpha[idx]) {
                alpha[idx] = j + 1;
            }
        }
    }

    // 결과 배열
    int* answer = (int*)malloc(sizeof(int) * targets_len);

    for(int i = 0; i < targets_len; i++) {

        int sum = 0;
        bool possible = true;

        for(int j = 0; targets[i][j] != '\0'; j++) {

            int idx = targets[i][j] - 'A';

            if(alpha[idx] == 101) {

                possible = false;

                break;
            }

            sum += alpha[idx];
        }

        answer[i] = possible ? sum : -1;
    }

    return answer;
}