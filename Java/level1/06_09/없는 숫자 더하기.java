class Solution {
    public int solution(int[] numbers) {
        
        int count=0;

        for(int i=0; i<=9; i++){
          boolean exist =false;
          for(int j=0; j<numbers.length; j++){
            //numbers의 포함되어있지 않은 경우
            if(i == numbers[j]) {
              exist=true;
              break;
            }
          }
          if(!exist) count +=i;
        }

        return count;
    }
}