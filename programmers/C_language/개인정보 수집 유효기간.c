#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

//날짜 -> 일수로 변환, 모든 달 28일이라고 가정
int dateToDays(int y, int m, int d){
  return y*12*28 + m * 28 + d;
}

int* solution(const char* today, const char* terms[], size_t terms_len, const char* privacies[], size_t privacies_len) {

  //약관 저장
  int tearMap[26]={0};

  for(int i=0; i<terms_len; i++){
    char type;
    int month;

    sscanf(terms[i], "%c %d", &type, &month);

    tearMap[type -'A'] = month;
  }

  // today 변환
  int ty, tm, td;
  sscanf(today, "%d.%d.%d", &ty, &tm, &td);

  //today 총 일수로 변환
  int todayDays = dateToDays(ty, tm, td);

  //결과 배열
  int * answer = (int*)malloc(sizeof(int)* privacies_len);

  int count=0;

  for(int i=0; i<privacies_len; i++){
    int y, m, d;
    char type;

    sscanf(privacies[i], "%d.%d.%d %c", &y, &m, &d, &type);
    //수집일을 총 일수로 변환
    int collectionDays = dateToDays(y, m, d);
    //만료일 계산, 유효기간은 전날까지라서 -1
    int expireDays = collectionDays + tearMap[type - 'A'] * 28 -1;

    //오늘보다 만료일 이전이면 파기
    if(expireDays < todayDays) {
      //문제에서 요구하는 번호 1부터
      answer[count++] = i + 1;
    }
  }

  return answer;
}