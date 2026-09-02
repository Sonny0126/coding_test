class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
      
        // 2 x 2 블록으로 4개 되면 사라짐
        //위에 블록이 아래로 내려옴
        //내려온 상태블록이 2x2 4개가 다시 되면 사라짐
        char [][] map = new char[m][n];
        for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
            map[i][j] = board[i].charAt(j);
          }
        }

        while(true) {
          boolean[][]remove = new boolean[m][n];
          boolean found = false;

          //2x2 같은 블록 찾기
          for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
              char c = map[i][j];
              if(c=='0') continue;
              if(c==map[i][j+1] && c==map[i+1][j] && c== map[i+1][j+1]){
                remove[i][j]=true;
                remove[i][j+1]=true;
                remove[i+1][j]=true;
                remove[i+1][j+1]=true;
                found = true;
              }
            }
          }

          // 더 이상 제거할 블록이 없다면 종료
          if(!found) break;

          //블록 제거
          for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
              if(remove[i][j]){
                map[i][j]='0';
                answer++;
              }
            }
          }

          //블록 아래로 내리기
          for(int j=0; j<n; j++){
            int temp = m-1;
            //아래에서부터 채우기
            for(int i=m-1; i>=0; i--){
              if(map[i][j]!='0'){
                map[temp][j]= map[i][j];
                temp--;
              }
            }

            while(temp >=0){
              map[temp][j]='0';
              temp--;
            }
          }
        }

        return answer;
    }
}