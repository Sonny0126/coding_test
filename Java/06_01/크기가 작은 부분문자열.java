class Solution {
    public int solution(String t, String p) {

        long pNum = Long.parseLong(p);
        int count = 0;

        for(int i = 0; i <= t.length() - p.length(); i++) {
            // t에서 부분 문자열을 잘라서 숫자(long)으로 변환
            long num = Long.parseLong(t.substring(i, i + p.length()));

            if(num <= pNum) {
                count++;
            }
        }
        return count;
    }
}