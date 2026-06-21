import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String,Integer>map=new HashMap<String, Integer>();

        for(int i=0; i<name.length; i++){
          map.put(name[i], yearning[i]);
        }
        
        int [] answer = new int[photo.length];

        for(int i=0; i<photo.length; i++){
          int count=0;

          for(String person : photo[i]){
            //map.containseKey는 포함되었는지 여부확인
            if(map.containsKey(person)){ 
              //포함되어있다면 값 증가
              count+=map.get(person);
            }
          }
          answer[i] = count;
        }

        return answer;
    }
}