class Solution
{
    public int solution(int [][]board)
    {
        //가자 큰 정사각 형 찾아서 넓이 반환

        int [][] dp = new int[board.length][board[0].length];
        int answer=0;

        int row =0;
        int col =0;
        int MAX=0;

        for(int i=0; i<board.length; i++){
          for(int j=0; j<board[0].length; j++){
            //현재 칸이 1인 경우에만 정사각형 만들 수 있다
            if(board[i][j]==1){
              if(i==0 || j== 0 ){
                //첫번쨰 행 or 첫번째 열은 참고할 칸이 없어서 최대 크기는 1이다
                dp[i][j]=1;
              }
              else{
                //현재 칸을 오른쪽 아래 꼭짓점으로 하는 정사각형 크기 계산
                //위(dp[i-1][j]), 왼쪽(dp[i][j-1]), 왼쪽 위(dp[i-1][j-1])
                // 세 값중 가장 작은 크기에 +1을 한다
                dp[i][j]= Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
              }

              //지금 만들 수 있는 정사각형 크기와 지금까지 발견한 가장 큰 정사각형 크기를 갱신해서 최대값 저장
              MAX = Math.max(MAX, dp[i][j]);
            }
          }
        }
        answer = MAX * MAX;

        return answer;
    }
}