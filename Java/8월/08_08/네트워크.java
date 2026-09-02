class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        //컴퓨터 A, B 직접적으로 연결되어 있고, B와 C가 직접적으로 연결되어 있을 때 A와 C도 연결

        //n은 네트워크 개수, 1은 연결, 0은 비연결
        // 네트워크 개수 return
        
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
          if(!visited[i]){
            answer++;
            dfs(i, n, computers, visited);
          }
        }

        return answer;
    }

    public void dfs(int computer, int n, int[][] computers, boolean[] visited){
      visited[computer] = true;

      for(int i=0; i<n; i++){
        //연결되어 있고, 아직 방문하지 않은 컴퓨터라면
        if(computers[computer][i] == 1 && !visited[i]){
          dfs(i, n, computers, visited);
        }
      }
    }
}