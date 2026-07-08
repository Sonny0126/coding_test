import java.util.* ;
class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;

        int [][] dp = new int [row][col];

        for(int i=0; i<col; i++){
          dp[0][i] = land[0][i];
        }

        for(int i=1; i<row; i++){
          for(int j=0; j<col; j++){
            int MAX=0; //최대 값 갱신

            //이전 행의 모든 열 탐색
            for(int k=0; k<col; k++){
              //같은 열은 제외
              if(k==j) continue;

              //최대값 갱신
              MAX = Math.max(MAX, dp[i-1][k]); 
            }
            //이전까지 최대 점수 + 현재칸의 점수
            dp[i][j] = MAX + land[i][j];
          }
        }
        int answer =0;

        //마지막으로 행렬을 돌면서 최대값을 찾아서 반환
        //(어떤 열에서 끝나든 가장 큰값이어야 한다, 왜냐면 음수가 들어올수도 있음)
        for(int i=0; i<col; i++){
          answer = Math.max(answer, dp[row-1][i]);
        }

        return answer;
    }
}