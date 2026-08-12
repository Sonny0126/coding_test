class Solution {
    public int solution(int m, int n, int[][] puddles) {

        //m=4, n=3인 경우
        //오른쪽과 애쪽으로만 움직여 학교까지 갈수 있는 최단 경로 개수 1,000,000,007 로 나눈 나머지 개수 return
        //집 위치 (1,1), 학교 위치 (m, n)

        int temp = 1000000007;
        int [][] dp = new int[n+1][m+1];

        boolean[][] puddle = new boolean[n+1][m+1];

        for(int[] p : puddles){
          int x = p[0];
          int y = p[1];

          puddle[y][x]=true;
        }
        dp[1][1]=1;

        //위 -> 아래
        for(int i=1; i<=n; i++){
          //왼 -> 오
          for(int j=1; j<=m; j++){
            //시작점 패스
            if(i==1 && j==1)
              continue;
            //웅덩이면 못감
            if(puddle[i][j]){
              dp[i][j]=0;
              continue;
            }

            //위 + 왼쪽
            dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % temp;
          }
        }

        return dp[n][m];
    }
}