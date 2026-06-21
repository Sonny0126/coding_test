import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        

      //arr i번쨰 숫자부터 j번쨰 숫자까지 자르고 정렬할 때 K번째 수 구하려고 한다
      //arr [1,5,2,6,3,7,4], i=2, j=5, k=3이라면
      //arr 2번째부터 5번째 자르면 [5,2,6,3]
      int ans [] = new int [commands.length];

      for(int i=0; i<commands.length; i++){
        int start = commands[i][0];
        int end = commands[i][1];
        int target = commands[i][2];

        //배열의 일부를 잘라서 새로운 배열로 만들어줌
        int [] temp = Arrays.copyOfRange(array, start-1, end);
        Arrays.sort(temp);

        ans[i] = temp[target-1];
      }
      
      return ans;
    }
}