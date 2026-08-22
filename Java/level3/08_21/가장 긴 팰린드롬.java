class Solution {
    public int solution(String s) {
        if (s == null || s.length() == 0) return 0;

        int MAX = 1;

        for (int i = 0; i < s.length(); i++) {
            // 1. 홀수 길이 팰린드롬 (중심이 문자 1개: 'aba')
            int oddLen = palindrome(s, i, i);
            
            // 2. 짝수 길이 팰린드롬 (중심이 문자 2개 사이: 'abba')
            int evenLen = palindrome(s, i, i + 1);

            MAX = Math.max(MAX, Math.max(oddLen, evenLen));
        }

        return MAX;
    }

    public int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 반복문 종료 시점에는 일치하지 않는 범위까지 확장되어 있으므로: (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
}