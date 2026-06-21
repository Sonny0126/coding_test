import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        // 오늘 날짜를 일수로 변환
        String[] todayArr = today.split("\\.");

        int year = Integer.parseInt(todayArr[0]);
        int month = Integer.parseInt(todayArr[1]);
        int day = Integer.parseInt(todayArr[2]);

        int todayDate = year * 12 * 28 + month * 28 + day;

        // 약관 저장
        Map<String, Integer> termMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");

            String type = temp[0];
            int period = Integer.parseInt(temp[1]);

            termMap.put(type, period);
        }

        // 파기 대상 번호 저장
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {

            String[] temp = privacies[i].split(" ");

            String date = temp[0];
            String type = temp[1];

            // 날짜 분리
            String[] dateArr = date.split("\\.");

            int y = Integer.parseInt(dateArr[0]);
            int m = Integer.parseInt(dateArr[1]);
            int d = Integer.parseInt(dateArr[2]);

            // 수집일 -> 일수
            int privacyDate = y * 12 * 28 + m * 28 + d;

            // 유효기간(개월)
            int period = termMap.get(type);

            // 만료일 계산
            int expireDate = privacyDate + period * 28 - 1;

            // 오늘이 만료일보다 크면 파기
            if (todayDate > expireDate) {
                list.add(i + 1);
            }
        }

        // List -> int[]
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}