class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        //붕대 감기 t초동안 1초마다 x체력회복, t초 연속 붕대 감기 성공하면 y만큼 체력 추가 회복
        //현재 체력 >최대 체력 X
        
        //기술 쓰다가 공격당하면 기술 취소, 
        //bandage [시전시간, 초당 회복량, 추가 회복량]
        //health는 체력
        //attacks [공격 시간, 피해량]

        //모든 공격끝난 후 체력 return, 피가 0이하면 -1 return

        int healTime=bandage[0];
        int secHeal=bandage[1];
        int plusHeal=bandage[2];

        int maxHealth=health;
        int curHealth=health;

        int prevTime = 0;

        for(int[]part : attacks){
          int attackTime=part[0];
          int damage=part[1];

          //공격 전까지 회복 가능한 시간
          int healSeconds = attackTime-prevTime-1;

          //초당 회복
          curHealth += healSeconds * secHeal;

          //추가 회복 횟수
          curHealth += (healSeconds / healTime) * plusHeal;

          //최대 체력 초과 방지
          if(curHealth>maxHealth) curHealth=maxHealth;

          //공격 받기
          curHealth-=damage;

          // 현재 체력이 0이하이면 종료
          if(curHealth<=0) return -1;

          //이전 시간 갱신
          prevTime = attackTime;
        }

        return curHealth;
    }
}