import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        
      //1점부터 k점까지 (k가 최상, 1이 최하)
      //한 상자에 사과 m개씩 포장
      //사과중 가장 낮은 점수 p, 사과 한 상자 가격 = p x m
      //최대 이익을 얻고자, 남는 사과는 버림
      
      //작은 놈들끼리 묶음
      
      //1. 오름차순 정렬 후 score 배열값들  m개씩 묶기
      Arrays.sort(score);

      int answer=0;

      //i 값이 묶음의 최소값이 된다
      for(int i=score.length - m ; i>=0; i-=m){
        answer += score[i] * m;
      }

      return answer;
    }
}