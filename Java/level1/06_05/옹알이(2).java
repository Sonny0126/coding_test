class Solution {
    public int solution(String[] babbling) {

        int answer = 0;

        for (String s : babbling) {

            // 같은 발음 연속이면 바로 제외
            if (s.contains("ayaaya") ||
                s.contains("yeye") ||
                s.contains("woowoo") ||
                s.contains("mama")) {
                continue;
            }

            // 발음 가능한 단어 제거
            s = s.replace("aya", " ");
            s = s.replace("ye", " ");
            s = s.replace("woo", " ");
            s = s.replace("ma", " ");

            // 공백 제거 후 아무것도 없으면 성공
            if(s.isBlank()) answer++;
        }

        return answer;
    }
}