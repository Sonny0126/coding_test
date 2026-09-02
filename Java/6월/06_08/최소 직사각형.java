class Solution {
    public int solution(int[][] sizes) {

        int w = 0;
        int h = 0;

        for (int[] card : sizes) {
            //지갑의 가로 = 각 명함의 긴 길이 중 최대 값
            //지갑의 세로는 각 명함의 짧은 길이 중 최대 값
            w = Math.max(w, Math.max(card[0], card[1]));
            h = Math.max(h, Math.min(card[0], card[1]));
        }

        return w * h;
    }
}