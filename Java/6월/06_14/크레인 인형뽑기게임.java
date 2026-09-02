class Solution {

    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        
        int [] stack = new int[n*n];
        int top = -1;

        int answer=0;

        //ex)
        // 0 0 0 0 0
        // 0 0 1 0 3
        // 0 2 5 0 1
        // 4 2 4 4 2
        // 3 5 1 3 1

        for(int move : moves){
          int col = move-1;
          for(int row=0; row < n; row++){
            if(board[row][col]!=0){
              int temp = board[row][col];
              board[row][col]=0;

              //stack 처리
              if(top>=0 && stack[top]==temp){
                top--;
                // 사라진 인형의 개수 추가
                answer+=2;
              }
              else {
                stack[++top] = temp;
              }
              break;// 종료
            }
          }
        }

        return answer;
    }
}