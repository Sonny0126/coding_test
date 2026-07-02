import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        //논문 n중, h번 이상 인용된 논문이 h편이상
        //h 값 최대로
        Arrays.sort(citations);
        
        //0 1 3 5 6
        for(int i=0; i<citations.length; i++){
          int h = citations.length-i;

          //h편 이상의 논문이 h번 이상 사용이라는 조건
          if(citations[i] >= h){
            //H-Index 갱신
            answer = h;
            break;
          }
        }

        return answer;
    }
}