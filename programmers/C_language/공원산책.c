#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// park_len은 배열 park의 길이입니다.
// routes_len은 배열 routes의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* park[], size_t park_len, const char* routes[], size_t routes_len) {
    
    int a=park_len;
    int b=strlen(park[0]);

    //시작 좌표 설정
    int sx=0;
    int sy=0;
    for(int i=0; i<a; i++){
      for(int j=0; j<b; j++){
        if(park[i][j]=='S'){
          sx=i;
          sy=j;
        }
      }
    }

    //방향 이동
    int dx[128]={0};
    int dy[128]={0};

    dx['E'] = 0;  dy['E'] = 1;
    dx['W'] = 0;  dy['W'] = -1;
    dx['S'] = 1;  dy['S'] = 0;
    dx['N'] = -1; dy['N'] = 0;

    //주어진 이동정보 배열에 담기
    for(int i=0; i<routes_len; i++){
      
      char dir;
      int distance;

      sscanf(routes[i], "%c %d", &dir,&distance);

      int nx=sx;
      int ny=sy;

      //주어진 결음수 만큼 한칸씩 이동
      int step=0;

      while(step<distance) {
        nx+=dx[(int)dir];
        ny+=dy[(int)dir];

        //만약 밖에 나가게 되거나 X를 만나게 된다면 종료
        if(nx<0 || nx>= a || ny <0 || ny>=b || park[nx][ny]=='X'){
          break;
        }
        step++;
      }

    //원하는 걸음수를 채우면 start는 마지막 위치로 바뀜
    if(step==distance){
      sx=nx;
      sy=ny;
    }
  }

  //반환용 배열을 만드는 이유는 지역변수처럼 만들면 함수 종료시 사라져서(끝나도 메모리가 살아있어야 하는데)
  int* answer = (int*)malloc(sizeof(int)*2);

  answer[0]=sx;
  answer[1]=sy;

  return answer;
}