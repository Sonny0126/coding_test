class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + n) % 26);
            }
            else if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + n) % 26);
            }
            answer.append(c);
        }
        return answer.toString();
    }
}