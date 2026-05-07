#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// wallpaper_len은 배열 wallpaper의 길이입니다.
int* solution(const char* wallpaper[], size_t wallpaper_len) {

    int top = 50;
    int left = 50;

    int bottom = 0;
    int right = 0;

    for(int i = 0; i < wallpaper_len; i++) {

        int leftFile = -1;
        int rightFile = -1;

        // 문자열 직접 탐색
        for(int j = 0; wallpaper[i][j] != '\0'; j++) {

            if(wallpaper[i][j] == '#') {

                if(leftFile == -1) {
                    leftFile = j;
                }

                rightFile = j;
            }
        }

        // '#'이 존재하는 경우
        if(leftFile != -1) {

            if(i < top) {
                top = i;
            }

            if(i + 1 > bottom) {
                bottom = i + 1;
            }

            if(leftFile < left) {
                left = leftFile;
            }

            if(rightFile + 1 > right) {
                right = rightFile + 1;
            }
        }
    }

    // 결과 배열 동적 할당
    int* answer = (int*)malloc(sizeof(int) * 4);

    answer[0] = top;
    answer[1] = left;
    answer[2] = bottom;
    answer[3] = right;

    return answer;
}