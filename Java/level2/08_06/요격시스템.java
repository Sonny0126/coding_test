import java.util.*;

class Solution {
    public int solution(int[][] targets) {

        //A나라 B나라 침공
        //폴격 미사일 끝나는 위치가 빠른 순서로 정렬하고, 현재 요격 위치로 맞출 수 없는 미사일을 만날 떄마다 새로운 요격 미사일을 쏜다

        Arrays.sort(targets, (a, b)->
          Integer.compare(a[1], b[1]));

          //첫번쨰 미사일 무조건 1개 필요
          int answer =1;

          // 마지막으로 발사한 요격 미사일의 기준 위치
          int last = targets[0][1];

          for(int i=1 ; i<targets.length; i++){
            int start = targets[i][0];
            int end = targets[i][1];

            //현재 요격 미사일로 못맞추는 경우
            //개구간이 있어서 start > last는 불가
            if(start >= last){
              answer++;
              last = end;
            }
          }

        return answer;
    }
}