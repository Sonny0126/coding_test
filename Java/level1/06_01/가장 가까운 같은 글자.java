class Solution {
    public int[] solution(String s) {

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                //이전에 들어왔던 숫자라면 
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j;
                    break;
                }
            }
        }

        return answer;
    }
}