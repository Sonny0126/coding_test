import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        //이중 우선순위 큐
        //큐가 비었으면 [0, 0], 비어있지 않으면[최대, 최소]
        // | 숫자 <- 큐에 주어진 숫자를 삽입
        // D 1 <- 큐에서 최대값 삭제
        // D-1 <- 큐에서 최소값 삭제

        for (String word : operations) {
        // "I 16" → ["I", "16"] 형태로 분리
        String[] s = word.split(" ");
        int n = Integer.parseInt(s[1]);

        // I → 숫자 삽입
        if (s[0].equals("I")) {
            // 같은 숫자가 있으면 개수 +1
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // D → 삭제, 단 큐가 비어있지 않을 때만
        else if (!map.isEmpty()) {

            // D 1  → 최댓값 삭제
            // D -1 → 최솟값 삭제
            int key;
            if (n == 1) {
                // D 1 → 최댓값 삭제
                key = map.lastKey();
            } 
            else {
                // D -1 → 최솟값 삭제
                key = map.firstKey();
            }

            // 해당 숫자가 1개만 있으면 key 자체를 삭제
            if (map.get(key) == 1) {
                map.remove(key);
            }
            // 여러 개 있으면 개수만 1 감소
            else {
                map.put(key, map.get(key) - 1);
            }
        }
    }

      // 모든 연산 후 큐가 비어있으면 [0, 0]
      if (map.isEmpty()) {
          return new int[]{0, 0};
      }

      // 마지막에 [최댓값, 최솟값] 반환
      return new int[]{map.lastKey(), map.firstKey()};
    }
}