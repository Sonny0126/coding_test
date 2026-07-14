import java.util.*;

class Solution {
  public String[] solution(String[] record) {
        //"[닉네임]님이 나갔습니다."
        // 채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
        // 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
        // 채팅방에서 닉네임을 변경한다.
        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for(String r : record){
          String[] temp = r.split(" ");

          String command = temp[0];
          String uid = temp[1];

          //Enter와 Change는 닉네임이 존재
          if(command.equals("Enter") || command.equals(("Change"))){
            String name = temp[2];
            map.put(uid, name);
          }
        }

        for(String r: record){
          String[] temp = r.split(" ");
          String command= temp[0];
          String uid = temp[1];

          if(command.equals("Enter")){
            result.add(map.get(uid)+ "님이 들어왔습니다.");
          }

          else if(command.equals("Leave")){
            result.add(map.get(uid)+ "님이 나갔습니다.");
          }
        }

        String [] answer = new String[result.size()];
        
        for(int i=0; i<result.size(); i++){
          answer[i]=result.get(i);
        }

        return answer;
    }
}