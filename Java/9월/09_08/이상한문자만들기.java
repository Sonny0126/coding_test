class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 공백이면 단어가 끝났으므로 인덱스를 0으로 초기화
            if (c == ' ') {
                answer.append(c);
                index = 0;
            } 
            else {
                // 단어의 짝수 번째 → 대문자
                // 단어의 홀수 번째 → 소문자
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } 
                else {
                    answer.append(Character.toLowerCase(c));
                }

                index++;
            }
        }
        return answer.toString();
    }
}
