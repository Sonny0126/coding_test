import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        //DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
        //LRU 교체 알고리즘 사용
        //cache hit일 경우 실행시간 = 1
        //cache miss일 경우 실행시간 = 5
        LinkedList<String> LRU = new LinkedList<>();

        //캐시가 초기부터 비어있는 경우 cachemiss이므로 N개 도시 x 5 출력
        if(cacheSize==0) return cities.length*5;

        int score=0;

        for (String city : cities) { 
          city = city.toLowerCase(); // 대소문자 구분안하니 소문자로 변경

        // cache hit 
        if (!LRU.isEmpty() && LRU.contains(city)) { 
          LRU.remove(city); // 기존 위치 제거 
          LRU.add(city); // 가장 최근 사용으로 이동 
          score += 1; 
        } 
        
        //cache miss 
        else { 
          if (!LRU.isEmpty() && LRU.size() == cacheSize) { 
            LRU.removeFirst(); // 가장 오래된 데이터 제거 
          }
          LRU.add(city); 
          // cache miss
          score += 5; 
        } 
      }
      return score;
    }
}