import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //테이블 튜플 col번쨰 컬럼값을 기준으로 오름차순 정렬
        //값이 동일하면 기본키인 첫번째 컬럼의 값을 기준으로 내림차순 정렬
        //정렬된 데이터에서 S_i를 i번쨰 행의 튜ㅡㄹ에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의
        // row_begin <= i <= row_ned인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로 반환
        Arrays.sort(data, (o1, o2)->{
          if(o1[col-1] == o2[col-1]){
            return Integer.compare(o2[0], o1[0]);
          }
          
          return Integer.compare(o1[col-1], o2[col-1]);
        });

        for(int i= row_begin; i<=row_end; i++){
          int S_i = 0;
          int[] row = data[i-1];

          for(int num : row ){
            S_i +=(num %i);
          }
          answer = answer ^ S_i;
        }

        return answer;
    }
}