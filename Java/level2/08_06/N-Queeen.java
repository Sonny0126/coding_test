class Solution {
    public int solution(int n) {
        int answer = 0;

        //가로 세로 길이 n
        //n개의 퀸 서로 공격 못하게 가로, 세로, 대각선 X
        //n개의 퀸이 만족하도록 배치하는 방법의 수 return

        if(n<4) return answer;

        int [] q = new int[n];
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
          if(isPossible(row, col, queen)){
            queen[row] = col;
            count += dfs(row+1, n, queen);
          }
        }
      return count;
    }

    public boolean isPossible(int row, int col, int[] queen){
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