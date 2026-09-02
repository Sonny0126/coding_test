class Solution {
    public int solution(int n, int m, int[] section) {

      //길이 n미터인 벽
      //벽에 페인트를 칠하는 룰러 길이는 m미터
      //1. 룰러 벽에서 벗어나면 안된다
      //2. 구역 일부분만 포함되도록 칠하면 안된다
      int count=0;

      //칠해진 위치
      int painted=0;

      for(int i=0; i<section.length; i++){
        int part = section[i];
        
        //아직 안 칠해졌으면 룰러를 새로 시작
        if(painted < part){
          count++;
          //현재 롤러로 어디까지 칠했는지
          painted = part + m -1;
        }
      }

      return count;
    }
}