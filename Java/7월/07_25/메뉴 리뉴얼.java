import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 1. 각 손님의 주문 내역 알파벳순 정렬 ("CBA" -> "ABC")
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 원하는 코스 요리 길이(course)별로 조합 구하기
        for (int len : course) {
            map = new HashMap<>();
            int maxCount = 0; // 해당 길이에서 가장 많이 주문된 횟수

            for (String order : orders) {
                if (order.length() >= len) {
                    // len 개수만큼의 메뉴 조합 생성 (재귀 탐색)
                    combination("", order, 0, len);
                }
            }

            // 가장 많이 주문된 횟수(최소 2번 이상) 찾기
            for (int count : map.values()) {
                if (count >= 2) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            // 최다 주문 횟수와 같은 조합들만 정답 리스트에 추가
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        answerList.add(entry.getKey());
                    }
                }
            }
        }

        // 3. 최종 코스 메뉴들을 사전순(오름차순)으로 정렬
        Collections.sort(answerList);

        // List -> String[] 변환
        return answerList.toArray(new String[0]);
    }

    // 조합 구하기 함수 (재귀)
    private void combination(String current, String order, int index, int targetLen) {
        //현재 길이가 목표길이와 동일한 경우
        if (current.length() == targetLen) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }

        //재귀함수를 통해 값 찾기 진행
        for (int i = index; i < order.length(); i++) {
            combination(current + order.charAt(i), order, i + 1, targetLen);
        }
    }
}