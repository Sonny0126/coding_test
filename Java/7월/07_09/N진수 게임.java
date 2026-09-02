class Solution {
    
  public String change(int decimal, int num) {
    if(decimal == 0) return "0";
    
    StringBuilder sb = new StringBuilder();

    //10진수 정수가 0이 될때까지 반복
    while(decimal > 0){
      int temp = decimal % num;
      if(temp>=10) {
        sb.append((char) (temp-10+'a'));
      }
      else{
        sb.append(temp);
      }

      decimal = decimal / num;
    }
    return sb.reverse().toString();
  }
  
  public String solution(int n, int t, int m, int p) {
        //N진수 게임
        // 0부터 시작하는 숫자들을 n진수로 바꿔 하나의 긴 문자열을 만든 뒤, 여러 사람이 한 글자씩 돌아가며 읽는다고 했을 때, 튜브(p번째 사람)가 읽게 되는 문자 t개를 구하는 문제

        StringBuilder game = new StringBuilder();
        int number=0;
        //최소 t*m개 문자있으면 됨
        while(game.length() <t * m){
          game.append(change(number, n));
          //다음 숫자로 증가
          number++;
        }

        StringBuilder answer = new StringBuilder();

        //사람의 시작 위치는 p-1
        int idx = p-1;

        for(int i=0; i<t; i++){
          answer.append(game.charAt(idx));
          //m만큼 뒤에 있음
          idx +=m;
        }

        return answer.toString().toUpperCase();
    }
}