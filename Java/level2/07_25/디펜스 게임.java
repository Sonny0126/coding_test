import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        //처음에 병사 n, enemy[i]등장
        //병사 enemy[i]만큼 소모해 막기 가능
        //남은 병사의 수보다 현재 라운드 적의수가 더 많으면 게임 종료
        //게임에서 무적권 스킬 O, 이 스킬 사용시 병사 소모없이 한 라운드 막을 수 있고, K번만큼 사용
        //무적권을 적절한 시기에 사용해 최대한 많은 라운드 진행
        //라운드 return
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<enemy.length; i++){
          //1. 병사 소모해서 라운드 막기
          n -= enemy[i];
          pq.add(enemy[i]);
          
          //2. 병사가 부족해진 경우
          if(n<0){
            //무적권이 있다면 가장 적이 많은 라운드에 사용
            if(k>0){
              n+=pq.poll();
              k--;
            }
            else{
              //무적권도 없으면 더이상 진행이 ㅂ루가
              return i;
            }
          }
        }

        return enemy.length;
    }
}