class Solution {
    public String solution(String s) {
        int mid = s.length() / 2;

        if (s.length() % 2 == 1) {
            return s.substring(mid, mid + 1);
        } else {
            return s.substring(mid - 1, mid + 1);
        }
    }
}