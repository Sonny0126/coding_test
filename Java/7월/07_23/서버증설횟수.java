class Solution {
    public int solution(int[] players, int m, int k) {

        int answer = 0;
        int running = 0;
        //반납되는 서버 개수
        int[] expire = new int[24 + k];
        // 0시 ~ 23시 
        for(int time = 0; time < 24; time++){
            // 만료된 서버 반납
            running -= expire[time];

            // 현재 시간에 필요한 서버 수
            int need = players[time] / m;

            // 필요한 서버보다 부족하면 증설
            if(running < need){
                int add = need - running;
                // 증설 횟수 증가
                answer += add;
                // 서버 추가
                running += add;
                // k시간 뒤 반납 
                expire[time + k] += add;
            }
        }

        return answer;
    }
}