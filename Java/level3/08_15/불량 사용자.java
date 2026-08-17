import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
      //부정행위 저지른 ID * 가려서 옴
      //보고 응모자 id에서 찾아서 제거
      //제재 아이디 목록이 몇가지 경우의 수가 가능한지 return
      Set<String> result = new HashSet<>();
      boolean [] visited = new boolean[user_id.length];
      dfs(0, user_id, banned_id, visited, result);
      
      return result.size();
    }

    public void dfs(int depth, String[] user_id, String[] banned_id, boolean[] visited, Set<String> result){
      //모든 banned_id 처리한 경우
      if(depth == banned_id.length){
        String[] selected = new String[banned_id.length];

        int index=0;

        for(int i=0; i<user_id.length; i++){
          if(visited[i]){
            selected[index++] = user_id[i];
          }
        }

        //순서 관계없이 제재목록으로 처리하기 위해 정렬
        Arrays.sort(selected);
        result.add(String.join(",", selected));

        return;
      }

      //현재 banned_id와 매칭되는 user_id 찾기
      for(int i=0; i<user_id.length; i++){
        //이미 사용한 user_id라면 넘어감
        if(visited[i]){
          continue;
        }
        //매칭되지 않는다면 넘어감
        if(!isMatch(user_id[i], banned_id[depth])){
          continue;
        }

        visited[i]=true;

        dfs(depth+1, user_id, banned_id, visited, result);

        //다른 경우 탐색을 위해 원상복구
        visited[i] = false;
      }
    }

    public boolean isMatch(String userId, String banned_id){
      //길이 다르면 매칭 불가
      if(userId.length() != banned_id.length()){
        return false;
      }

      for(int i=0; i<userId.length(); i++){
        if(banned_id.charAt(i)=='*'){
          continue;
        }
        if(userId.charAt(i)!= banned_id.charAt(i)){
          return false;
        }
      }
      return true;
    }

}