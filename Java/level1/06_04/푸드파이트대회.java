import java.util.Arrays;

class Solution {
    public String solution(int[] food) {
            //선수-------------물------------- 선수
      //중앙 물 배치하고, 물 먼저 먹는 사람 승리 
      //칼로리 낮음 음식 먼저 배치
      //물은 0번음식

      // 1번 3개, 2번 4개, 3번 6개 
      // 1, 3, 4, 6인 경우
      
      //1. 오름차순 정렬
      //food[0]은 물의 양 항상 1
      
      String answer ="";

      for(int i=1; i<food.length; i++){
        int num = food[i]/2;
        if(food[i]<2) continue; 
        answer += String.valueOf(i).repeat(num);
      }

      String reverse = new StringBuilder(answer).reverse().toString(); 
      String realAns = answer + "0" + reverse;

      return realAns;
    }
}