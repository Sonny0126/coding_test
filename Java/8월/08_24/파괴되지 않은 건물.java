class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        // N x M 크기의 행렬 모양 게임맵 존재
        //공격받으면 내구도 감소되고, 0이하되면 파괴된다
        //아군은 회복스킬을 통해 건물들의 내구도를 높이려고 한다
        // type = 1 적의 공격, type = 2 힐, degree만큼 내구도 낮춤
        //skill = [type, r1, c1, r2, c2, degree]

        //ex)
        // 5 5 5 5 5
        // 5 5 5 5 5
        // 5 5 5 5 5
        // 5 5 5 5 5

        int n = board.length;
        int m = board[0].length;

        int [][] diff = new int [n+1][m+1];
        
        //1. 각 스킬의 4개 모서리 마킹
        for(int [] s : skill){
          int type = s[0];
          int r1=s[1];
          int c1=s[2];
          int r2=s[3];
          int c2=s[4];

          //공격 -, 회복 +
          int degree = (type==1) ? -s[5] : s[5];

          diff[r1][c1] += degree;
          diff[r1][c2+1] -= degree;
          diff[r2+1][c1] -= degree;
          diff[r2+1][c2+1] += degree;
        }

        // 2. 가로방햔 누적합
        for(int r=0; r<n; r++){
          for(int c=1; c<m; c++){
            diff[r][c] += diff[r][c-1];
          }
        }

        //3. 세로방향 누적합
        for(int c=0; c<m; c++){
          for(int r=1; r<n; r++){
            diff[r][c]+=diff[r-1][c];
          }
        }

        //4. 원래 보드판과 누적 변화량을 더해 생존된 건물을 계산
        int answer = 0;
        for(int r=0; r<n; r++){
          for(int c=0; c<m; c++){
            if(board[r][c] + diff[r][c]>0){
              answer++;
            }
          }
        }

        return answer;
    }
}