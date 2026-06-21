class Solution {
    public int solution(String s) {
        int answer = 0;

        //첫 글자는 x
        // 왼->오 x와 x가 아닌 다른 글자들 횟수 각각 셈
        //처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열 분리
        //분리한 문자열 빼고 남은 과정 반복
        //abra c adabra

        int same =0;
        int diff =0;
        char x =s.charAt(0); // 첫글자 x

        for(int i=0; i<s.length(); i++){
          if(same==diff){
            answer++;
            x=s.charAt(i);
          }

          if(s.charAt(i)==x){
            same++;
          }
          else{
            diff++;
          }
        }

        return answer;
    }
}