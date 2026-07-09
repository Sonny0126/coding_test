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
        // 1, 2, 3, ..., 9, 1, 0, 1, 1, 1, 2, 1, 3
        //2진수로 이 게임을 진행하기도 함 
        // 0, 1, 1, 0, 1, 1, 1, 0, 0 , ....
        //난이도 높이기 위해 이진법에서 16진법까지 게임 진행
        //n이 진법, 미리 구할 숫자 개수 t, 게임참가인원 m, 튜브의 순서 p

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