#include<stdio.h>
#include<stdlib.h>

//시간 계산
int calcTime(int time){
    int hour = time / 100;
    int minute = time % 100;

    return hour * 60 + minute;
}

int solution(
    int schedules[],
    size_t schedules_len,
    int** timelogs,
    size_t timelogs_rows,
    size_t timelogs_cols,
    int startday
){
    //개수 체크
    int cnt = 0;

    //체크 알고리즘
    for(int i = 0; i < schedules_len; i++){

        int allowTime = calcTime(schedules[i]) + 10;
        int isSafe = 1;

        //시작날짜를 기준으로 계산
        for(int j = 0; j < 7; j++){

            int curDay = ((startday + j - 1) % 7) + 1;

            if(curDay == 6 || curDay == 7) continue;

            int realTime = calcTime(timelogs[i][j]);

            if(realTime > allowTime){
                isSafe = 0;
                break;
            }
        }

        if(isSafe) cnt++;
    }

    return cnt;
}