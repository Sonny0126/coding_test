#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* s, const char* skip, int index) {
    
    int len = strlen(s);

    // 결과 문자열 메모리 할당
    char* answer = (char*)malloc(len + 1);

    for(int i = 0; i < len; i++) {

        char c = s[i];
        int count = 0;

        // index만큼 이동
        while(count < index) {

            // 다음 문자
            c++;

            // z 넘어가면 a
            if(c > 'z')
                c = 'a';

            // skip에 있는지 검사
            bool isSkip = false;

            for(int j = 0; skip[j] != '\0'; j++) {
                if(c == skip[j]) {
                    isSkip = true;
                    break;
                }
            }

            // skip 문자가 아니면 count 증가
            if(!isSkip)
                count++;
        }

        answer[i] = c;
    }

    answer[len] = '\0';

    return answer;
}