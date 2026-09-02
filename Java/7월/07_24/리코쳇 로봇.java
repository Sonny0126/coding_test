import java.util.*;

class Solution {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};

    class Node {
      int r, c, count;

      Node(int r, int c, int count){
        this.r=r;
        this.c=c;
        this.count=count;
      }
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int startR = -1, startC = -1;

        //시작 위치 R 찾기
        for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
            if(board[i].charAt(j)=='R'){
              startR = i;
              startC = j;
              break;
            }
          }
        }

        return bfs(board, startR, startC, n, m);
    }

    public int bfs(String[] board, int startR, int startC, int n, int m){
      Queue<Node> q = new LinkedList<>();
      boolean[][] visited = new boolean[n][m];

      q.add(new Node(startR, startC, 0));
      visited[startR][startC] =true;

      while(!q.isEmpty()){
        Node current = q.poll();

        //목표지점 G에 도달했는지
        if(board[current.r].charAt(current.c)=='G'){
          return current.count;
        }

        //4방향 탐색
        for(int i=0; i<4; i++){
          int nr = current.r;
          int nc = current.c;

          //벽(D)나 보드 경계를 만나기전까지 이동
          while(true){
            int nextR = nr + dx[i];
            int nextC = nc  +dy[i];

            //보드 범위를 벗어나거나 장애물(D)를 만나면 정지
            if(nextR<0 || nextR >= n || nextC <0 || nextC >= m || board[nextR].charAt(nextC)=='D'){
              break;
            }

            nr = nextR;
            nc = nextC;
          }

          //이동을 안하거나 방문한 위치라면 패스
          if(nr==current.r && nc == current.c) continue;

          if(!visited[nr][nc]){
            visited[nr][nc] =true;
            q.add(new Node(nr, nc, current.count+1));
          }
        }

      }
      
      return -1;
    }
}