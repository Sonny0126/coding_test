#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// bandage_len은 배열 bandage의 길이입니다.
// attacks_rows는 2차원 배열 attacks의 행 길이,
// attacks_cols는 2차원 배열 attacks의 열 길이입니다.
int solution(
    int bandage[],
    size_t bandage_len,
    int health,
    int** attacks,
    size_t attacks_rows,
    size_t attacks_cols
) {

    //t초만큼 붕대 감으면 1초마다 x체력 회복,
    //t초 연속으로 붕대 감는데 성공하면 y만큼 회복
    //최대 체력 health, 몬스터 공격 시간, 피해량 attacks
    //캐릭터 체력이 0이하면 -1 return

    int t = bandage[0];
    int x = bandage[1];
    int y = bandage[2];

    int curHealth = health;
    int attackIdx = 0;
    int contHeal = 0;

    for(int time = 1; ; time++) {

        //현재 공격시간이라면
        if(attackIdx < attacks_rows &&
           attacks[attackIdx][0] == time) {

            //공격당함
            curHealth -= attacks[attackIdx][1];

            contHeal = 0; //붕대 끊김

            attackIdx++;
        }

        else {

            //회복 진행
            curHealth += x;

            contHeal++;

            if(contHeal == t) {

                curHealth += y;

                contHeal = 0;
            }

            //체력은 최대 체력 초과 불가
            if(curHealth > health) {
                curHealth = health;
            }
        }

        //죽었는지 확인
        if(curHealth <= 0) {
            return -1;
        }

        //모든 공격 다 받으면 끝
        if(attackIdx == attacks_rows) {
            break;
        }
    }

    return curHealth;
}