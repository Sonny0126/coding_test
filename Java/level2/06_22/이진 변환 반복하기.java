class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        //x의 모든 0을 제거
        //x의 길이를 c라고 하면, x를 2진법으로 표현한 문자열로 변경

        //return 제거한 0 개수, 이진 변환한 횟수
        int zeroCount=0;
        int change=0;
        //copy에 s값 복사
        String copy=s;

        //'1'이 남을때까지 반복
        while(!copy.equals("1")){
        
          String str = "";
          //0을 제거하고 남은 str
          for(int i=0; i<copy.length(); i++){
            if(copy.charAt(i)=='0') {
              zeroCount++;
            }
            else {
              str += copy.charAt(i);
            }
          }
          //Integer.toBinaryString은 정수를 받아서 2진수 형태의 문자열로 변환
          copy = Integer.toBinaryString(str.length());
          
          //변환횟수 증가
          change++;
        }

        answer = new int[]{change, zeroCount};

        return answer;
    }
}