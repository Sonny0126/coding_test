import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //한 명 선수 제외하고 모든 선수 마라톤 완주
        //완주한 선수 이름 completion, 
        //완주하지 못한 선수 이름 return

        // 참여자 명단에 있지만 완주자 명단에 없어서 완주 x'

        //1. participant 명단 선수 중복 제거
        Map<String, Integer> map = new HashMap<>();
        for(String name : participant){
          //map.getOrDefault(name, 0)은 name이라는 키가 있으면 그 값을 가져오고 없으면 0 반환, +1은 현재개수에 1을 더해서 저장
          map.put(name, map.getOrDefault(name, 0)+1); 
        }

        //2.set에 있는 이름이 completion에 있으면 제외
        for(String completeName : completion){
          //완주한 사람만큼 사람의 수 -1하기 위해서
          map.put(completeName, map.get(completeName)-1);
        }

        for(String answer : map.keySet()){
          if(map.get(answer)>0) 
            return answer;
        }

        //set은 존재여부만 관리하기에 부적절하고 개수를 관리하는 map이 적합하다
        return "";
      }
    }