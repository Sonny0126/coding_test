#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int m, int sections[], size_t sections_len) {

    //최소 롤러 횟수를 알려줌
    //n은 총 길이, m은 롤러 길이
    //section은 총 칠해야 할 부분
    //최소 사용 횟수 구하기

    int cnt = 0;

    int painted = 0; //현재까지 롤러로 칠한 마지막 위치

    for(int i = 0; i < sections_len; i++) {

        int section = sections[i];

        //아직 안 칠해졌으면 롤러를 새로 시작
        if(painted < section) {

            cnt++;

            painted = section + m - 1;
        }
    }

    return cnt;
}