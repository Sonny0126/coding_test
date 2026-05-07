#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(
    const char* video_len,
    const char* pos,
    const char* op_start,
    const char* op_end,
    const char* commands[],
    size_t commands_len
) {

    int vmin, vsec;
    sscanf(video_len, "%d:%d", &vmin, &vsec);

    int vTime = vmin * 60 + vsec;

    int min, sec;
    sscanf(pos, "%d:%d", &min, &sec);

    int realTime = min * 60 + sec;

    int start_min, start_sec;
    sscanf(op_start, "%d:%d", &start_min, &start_sec);

    int end_min, end_sec;
    sscanf(op_end, "%d:%d", &end_min, &end_sec);

    int realStart = start_min * 60 + start_sec;
    int realEnd = end_min * 60 + end_sec;

    //오프닝 사이인 경우
    if(realTime >= realStart && realTime <= realEnd){
        realTime = realEnd;
    }

    for(int i = 0; i < commands_len; i++){

        // prev
        if(strcmp(commands[i], "prev") == 0){

            realTime -= 10;

            if(realTime < 0)
                realTime = 0;
        }

        // next
        else if(strcmp(commands[i], "next") == 0){

            realTime += 10;

            if(realTime > vTime)
                realTime = vTime;
        }

        //오프닝 사이인 경우 재확인
        if(realTime >= realStart && realTime <= realEnd){
            realTime = realEnd;
        }
    }

    int changeMin = realTime / 60;
    int changeSec = realTime % 60;

    // 결과 문자열 메모리 할당
    char* answer = (char*)malloc(6);

    sprintf(answer, "%02d:%02d", changeMin, changeSec);

    return answer;
}