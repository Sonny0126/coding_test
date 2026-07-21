import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        //2,3, 4 지점
        //시소가 평형인 상태에서 토크의 크기가 상쇄돼어 균형
        //탑승한 사람 무게 시소 축 x 좌석 간의 거리 같다면 시소 짝꿍
        int [] seat = {2,3,4};

        //배열 오름차순 정렬
        Arrays.sort(weights);

        Map<Integer, Long> map = new HashMap<>();

        for (int w : weights) {

            // 같은 무게
            answer += map.getOrDefault(w, 0L);
            // 2 : 3
            if (w * 2 % 3 == 0)
                answer += map.getOrDefault(w * 2 / 3, 0L);
            // 1 : 2
            if (w % 2 == 0)
                answer += map.getOrDefault(w / 2, 0L);
            // 3 : 4
            if (w * 3 % 4 == 0)
                answer += map.getOrDefault(w * 3 / 4, 0L);
              
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        return answer;
    }
}