import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //want들을 number만큼 구매
        //자신이 원하는 제품과 수량이 할인하는 날짜와 10일연속으로 일치할 경우에 맞춰서 회원가입

        Map<String, Integer> target = new HashMap<>();
      
        for(int i=0; i<want.length; i++){
          target.put(want[i], number[i]);
        }

        //sliding window 기법 사용
        for(int i=0; i<=discount.length-10; i++){
          Map<String, Integer> map = new HashMap<>();

          for(int j=i; j<i+10; j++){
            map.put(discount[j], map.getOrDefault(discount[j], 0)+1);
          }

          if(target.equals(map))
            answer++;
        }
        //다 지워지지않은 경우 0 출력
        return answer;
    }
}