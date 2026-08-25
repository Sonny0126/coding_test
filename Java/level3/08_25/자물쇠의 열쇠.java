class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        //자물쇠 크기가 1x1인 NxN 크기의 정사각 격자 형태
        //특이한 모야으이 열쇠는 M x M
        //돌기에 딱 맞추면 자물쇠가 열리는 구조

        //자물쇠에 홈, 돌기 부분본재
        //열쇠는 회전과 이동이 가능하며, 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리는 구조
        //열쇠의 돌기와 자물쇠의 돌기가 만나서는 안된다

        int M = key.length;
        int N = lock.length;

        //4가지 방향 확인
        for(int r = 0; r<4; r++){
          //key를 놓을수 있는 모든 위치 확인
          for(int x=0; x<N+M; x++){
            for(int y=0; y<N+M; y++){
              //lock보다 큰 board 생성
              int size = N+2*M;
              int[][] board = new int [size][size];

              //board 가운데에 lock 배치
              for(int i=0; i<N; i++){
                for(int j=0;j<N; j++){
                  board[M+i][M+j] = lock[i][j];
                }
              }

            // key를 board 위에 놓기
            for (int i = 0; i < M; i++) {
              for (int j = 0; j < M; j++) {
                board[x + i][y + j] += key[i][j];
              }
            }

              //lock 영역이 전부 1인지 확인
              if(check(board, M, N)){
                return true;
              }
            }
          }
          //key를 시계방향으로 90도 회전
          key = rotate(key);
        }
        return false;
    }

    //lock 영역이 전부 1인지 확인
    public boolean check(int[][] board, int M, int N){
      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
          if(board[M+i][M+j] != 1){
            return false;
          }
        }
      }
      return true;
    }

    //시계방향 90도 회전
    public int [][] rotate(int [][]key){
      int M = key.length;
      int [][] rotated = new int [M][M];

      for(int i=0; i<M; i++){
        for(int j=0; j<M; j++){
          rotated[j][M-1-i] = key[i][j];
        }
      }
      return rotated;
    }
}
