import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        //str 이어붙여서 만들 수 있는 가장 큰수
        //각 문자 앞에 제일 큰수가 와야한다
        String [] sNumbers = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
          sNumbers[i]=String.valueOf(numbers[i]);
        // '6', '10', '2'

        // 3, 30비교시 330, 303 크기 비교해서 누가 더 큰지
        Arrays.sort(sNumbers, (a, b) -> (b + a).compareTo(a + b));

        if(sNumbers[0].equals("0")) 
          return "0";

        String answer = "";
        for(String str : sNumbers){
          answer += str;
        }

        return answer;
    }
}