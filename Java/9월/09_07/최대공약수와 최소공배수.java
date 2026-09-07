class Solution {
    public int[] solution(int n, int m) {
        
      int big = n > m ? n : m;
      int num1 = 0;
      for(int i=1; i<= big; i++){
        if(n%i==0 && m%i==0){
          num1 = i;
        }
      }

      //최소 공배수
      int num2 = n*m/num1;
      int [] arr = {num1, num2}; 

      return arr;

    }
}