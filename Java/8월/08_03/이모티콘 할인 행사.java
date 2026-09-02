class Solution {

    int[] discount = {10, 20, 30, 40};

    int maxCount = 0;
    int maxBuy = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        // 각 이모티콘의 할인율 저장
        int[] selected = new int[emoticons.length];

        dfs(0, selected, users, emoticons);

        return new int[]{maxCount, maxBuy};
    }

    void dfs(int depth, int[] selected, int[][] users, int[] emoticons) {
        // 모든 이모티콘의 할인율을 정한 경우
        if (depth == emoticons.length) {
            int count = 0;   // 가입자 수
            int emoBuy = 0;  // 매출액
            // 모든 사용자 계산
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                // 모든 이모티콘 확인
                for (int j = 0; j < emoticons.length; j++) {
                    // 사용자가 원하는 할인율 이상이면 구매
                    if (selected[j] >= users[i][0]) {
                        sum += emoticons[j] * (100 - selected[j]) / 100;
                    }
                }

                // 가입 여부 판단
                if (sum >= users[i][1]) {
                    count++;
                } 
                else {
                    emoBuy += sum;
                }
            }

            // 정답 갱신
            if (count > maxCount) {
                maxCount = count;
                maxBuy = emoBuy;
            } 
            else if (count == maxCount && emoBuy > maxBuy) {
                maxBuy = emoBuy;
            }
            return;
        }

        // 현재 이모티콘의 할인율 4가지 모두 시도
        for (int i = 0; i < 4; i++) {
            selected[depth] = discount[i];
            dfs(depth + 1, selected, users, emoticons);
        }
    }
}