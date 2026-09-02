import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        //귤 수확하려고 함  k개 상자에 담아서 판매
        //크기 별로 분류 후, 서로 다른 종류의 수를 최소화

        //1. 크기별 개수 세기(HashMap 사용)
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int size : tangerine){
          //값이 있으면 가져오고, 없으면 0으로 기본값
          //가져온 값 개수 + 1
          countMap.put(size, countMap.getOrDefault(size,0)+1);
        }

        //2. 개수 기준 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts, Collections.reverseOrder());

        //3. K개를 채울 때까지 종류 수 카운트
        int remain = k;
        for(int count : counts){
          //다 채웠다면 종료
          if(remain <= 0) break;
          remain -= count;
          answer++;
        }

        return answer;
    }
}