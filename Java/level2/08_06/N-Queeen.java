class Solution {
    public int solution(int n) {
        int answer = 0;

        //가로 세로 길이 n
        //n개의 퀸 서로 공격 못하게 가로, 세로, 대각선 X
        //n개의 퀸이 만족하도록 배치하는 방법의 수 return

        if(n<4) return answer;

        int [] q = new int[n]; //배열로 퀸 위치 기록
        answer = dfs(0, n, q);

        return answer;
    }

     public int dfs(int row, int n, int[] queen){
        //모든 행에 퀸을 다 놓았다면
        if(row==n){
          return 1;
        }

        int count =0;

        for(int col = 0; col<n; col++){
          if(check(row, col, queen)){
            //안전하다면 위치를 기록하고
            queen[row] = col;
            //dfs를 호출 (횟수는 count++)
            count += dfs(row+1, n, queen);
          }
        }
      return count;
    }

    //퀸을 놓을 수 있는지 확인하는 함수
    public boolean check(int row, int col, int[] queen){
      for(int x=0; x<row; x++){
        int y = queen[x];

        //같은 열
        if(y == col){
          return false;
        }

        //대각선
        if(Math.abs(x-row)==Math.abs(y - col)){
          return false;
        }
      }
      return true;
    }
}