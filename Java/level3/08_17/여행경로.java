import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        //항상 ICN 공항에서 출발
        //이어지도록
        //방문할 수 있는 공항 경로 배열에 담아 return
        // DFS를 통해 갈 수 있는 경로

        List<String> answer = new ArrayList<>();
        boolean[] used = new boolean[tickets.length];

        //알파벳 순으로 정렬하기 위해 티켓 정렬
        Arrays.sort(tickets, (a,b)-> a[1].compareTo(b[1]));

        //ICN에서 출발
        answer.add("ICN");

        dfs("ICN", tickets, used, answer);

        return answer.toArray(new String[0]);
    }

    public boolean dfs(String current, String [][] tickets, boolean[] used, List<String> path){
      //모든 티켓을 사용해서 완성된 경로
      if(path.size() == tickets.length+1){
        return true;
      }

      //현재 공항에서 갈 수 있는 티켓 탐색
      for(int i=0; i<tickets.length; i++){
        if(used[i]){
          continue;
        }

        //현재 공항에서 출발하는 티켓인지 확인
        if(!tickets[i][0].equals(current)){
          continue;
        }

        //티켓 사용
        used[i] = true;
        path.add(tickets[i][1]);

        //다음 공항으로 이동
        if(dfs(tickets[i][1], tickets, used, path)){
          return true;
        }

        //경로가 완성되지 않았다면 되돌리기
        used[i]=false;
        path.remove(path.size()-1);
      }

      return false;
    }
}