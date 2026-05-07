#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 이름으로 인덱스 찾기
int findIndex(const char* friends[], size_t friends_len, const char* name) {

    for(int i = 0; i < friends_len; i++) {
        if(strcmp(friends[i], name) == 0) {
            return i;
        }
    }

    return -1;
}

// friends_len은 배열 friends의 길이입니다.
// gifts_len은 배열 gifts의 길이입니다.
int solution(
    const char* friends[],
    size_t friends_len,
    const char* gifts[],
    size_t gifts_len
) {

    int answer = 0;

    int len = friends_len;

    // 선물 기록 테이블
    int giftTable[50][50] = {0};

    // 선물 지수
    int rankInfo[50] = {0};

    // 다음 달 받을 선물 수
    int nextMonth[50] = {0};

    //주고 받은거 저장
    for(int i = 0; i < gifts_len; i++) {

        char from[20];
        char to[20];

        sscanf(gifts[i], "%s %s", from, to);

        int fromIdx = findIndex(friends, friends_len, from);
        int toIdx = findIndex(friends, friends_len, to);

        giftTable[fromIdx][toIdx]++;
    }

    //선물 지수 저장
    for(int i = 0; i < len; i++) {

        for(int j = 0; j < len; j++) {

            // 내가 준 선물
            rankInfo[i] += giftTable[i][j];

            // 내가 받은 선물
            rankInfo[i] -= giftTable[j][i];
        }
    }

    for(int i = 0; i < len; i++) {

        for(int j = i + 1; j < len; j++) {

            if(giftTable[i][j] > giftTable[j][i]) {
                nextMonth[i]++;
            }

            else if(giftTable[i][j] < giftTable[j][i]) {
                nextMonth[j]++;
            }

            else {

                if(rankInfo[i] > rankInfo[j]) {
                    nextMonth[i]++;
                }

                else if(rankInfo[i] < rankInfo[j]) {
                    nextMonth[j]++;
                }
            }
        }
    }

    // 최대값 찾기
    for(int i = 0; i < len; i++) {

        if(nextMonth[i] > answer) {
            answer = nextMonth[i];
        }
    }

    return answer;
}