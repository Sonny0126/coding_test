#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// cards1_len은 배열 cards1의 길이입니다.
// cards2_len은 배열 cards2의 길이입니다.
// goal_len은 배열 goal의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다.
char* solution(
    const char* cards1[],
    size_t cards1_len,
    const char* cards2[],
    size_t cards2_len,
    const char* goal[],
    size_t goal_len
) {

    int idx1 = 0;
    int idx2 = 0;

    for(int i = 0; i < goal_len; i++) {

        // cards1에서 사용 가능한 경우
        if(idx1 < cards1_len &&
           strcmp(cards1[idx1], goal[i]) == 0) {

            idx1++;
        }

        // cards2에서 사용 가능한 경우
        else if(idx2 < cards2_len &&
                strcmp(cards2[idx2], goal[i]) == 0) {

            idx2++;
        }

        // 둘 다 불가능한 경우
        else {

            char* answer = (char*)malloc(3);

            strcpy(answer, "No");

            return answer;
        }
    }

    char* answer = (char*)malloc(4);

    strcpy(answer, "Yes");

    return answer;
}