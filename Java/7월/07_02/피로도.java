import java.util.Arrays;

class Solution {
    
  int answer =0;
  boolean[] visited;

  public int solution(int k, int[][] dungeons) {

    visited = new boolean[dungeons.length];
    dfs(k, dungeons, 0);
    return answer;
  }

  void dfs(int pirodo, int[][] dungeons, int count){
    answer = Math.max(answer, count);

    for(int i=0; i<dungeons.length; i++){
      if(!visited[i] && pirodo >= dungeons[i][0]){
        visited[i] = true;
        dfs(pirodo - dungeons[i][1], dungeons, count+1);
        visited[i]=false; //백트래킹
      }
    }
  }
}