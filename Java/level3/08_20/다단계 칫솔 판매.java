import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral,
String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        // 판매원 이름 -> answer의 인덱스
        Map<String, Integer> index = new HashMap<>();

        // 판매원 -> 추천인
        Map<String, String> parent = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            index.put(enroll[i], i);
            parent.put(enroll[i], referral[i]);
        }

        // 판매 기록 처리
        for (int i = 0; i < seller.length; i++) {

            String current = seller[i];
            int money = amount[i] * 100;

            // 추천인을 따라가며 수익 분배
            while (!current.equals("-") && money > 0) {

                int idx = index.get(current);

                // 추천인에게 줄 돈
                int parentMoney = money / 10;

                // 내가 가져갈 돈
                int myMoney = money - parentMoney;

                answer[idx] += myMoney;

                // 추천인에게 올라감
                current = parent.get(current);
                money = parentMoney;
            }
        }

        return answer;
    }
}