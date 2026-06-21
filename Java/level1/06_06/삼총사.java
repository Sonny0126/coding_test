import java.util.Arrays;

class Solution {
    public int solution(int[] number) {

        // 3명 정수 값 += 0이면, 3명은 삼총사
        int Samchongsa=0;

        //오름차순 정렬 -5, -2, 0, 2, 3
        Arrays.sort(number);
        
        for(int i=0; i<number.length; i++){
          for(int j=i+1; j<number.length; j++){
            for(int k=j+1; k<number.length; k++){
              if(number[i]+number[j]+number[k]==0) Samchongsa++;
            }
          }
        }

        return Samchongsa;
    }
}