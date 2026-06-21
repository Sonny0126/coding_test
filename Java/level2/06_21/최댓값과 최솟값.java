class Solution {
    public String solution(String s) {

      int max =Integer.MIN_VALUE;
      int min =Integer.MAX_VALUE;
      //최소값, 최대값 찾아서 (최소값) (최대값) 형태로 문자열 반환

      String [] arr= s.split(" ");

      for(String str : arr){
        int num = Integer.parseInt(str);
        max = Math.max(max, num);
        min = Math.min(min, num);
      }

      String answer = min + " " + max;

      return answer;
    }
}