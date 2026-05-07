#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 선수 이름으로 현재 인덱스 찾기
int findPlayer(const char* players[], size_t players_len, const char* name) {

    for(int i = 0; i < players_len; i++) {

        if(strcmp(players[i], name) == 0) {
            return i;
        }
    }

    return -1;
}

// players_len은 배열 players의 길이입니다.
// callings_len은 배열 callings의 길이입니다.
char** solution(
    const char* players[],
    size_t players_len,
    const char* callings[],
    size_t callings_len
) {

    // 결과 배열 동적 할당
    char** answer = (char**)malloc(sizeof(char*) * players_len);

    // players 복사
    for(int i = 0; i < players_len; i++) {

        answer[i] = (char*)malloc(strlen(players[i]) + 1);

        strcpy(answer[i], players[i]);
    }

    for(int i = 0; i < callings_len; i++) {

        const char* called = callings[i];

        int idx = findPlayer((const char**)answer, players_len, called);

        // called 선수가 자기 앞사람과 바꾸기
        char* temp = answer[idx - 1];

        answer[idx - 1] = answer[idx];

        answer[idx] = temp;
    }

    return answer;
}