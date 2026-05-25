class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        //선물기록을 봐서 더 많이 선물 준사람이 다음달에 선물하나 더 받음
        //기록 x or 같다면, 선물지수 큰사람이 작은사람에게 선물 하나 받음
        //선물 지수는 이번달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수     
        //선물지수도 같다면, 다음 달에 선물 주고받지 않기

        //-------------------------------------------------------------

        // 표를 만들어서 보면 훨씬 쉬어진다

        // 선물 기록 표
        int[][] arr = new int[friends.length][friends.length];

        // gifts 기록 저장
        for(String gift : gifts) {

            String[] temp = gift.split(" ");

            String from = temp[0];
            String to = temp[1];

            int fromIdx = -1;
            int toIdx = -1;

            // 번호 찾기
            for(int i = 0; i < friends.length; i++) {

                if(friends[i].equals(from)) {
                    fromIdx = i;
                }

                if(friends[i].equals(to)) {
                    toIdx = i;
                }
            }

            // 표에 저장
            arr[fromIdx][toIdx]++;
        }

        // 선물지수 저장
        int[] score = new int[friends.length];

        // 선물지수 계산
        for(int i = 0; i < friends.length; i++) {

            int give = 0;
            int receive = 0;

            for(int j = 0; j < friends.length; j++) {

                give += arr[i][j];
                receive += arr[j][i];
            }

            score[i] = give - receive;
        }

        // 다음달 받을 선물 수
        int[] nextGift = new int[friends.length];

        // 친구끼리 비교
        for(int i = 0; i < friends.length; i++) {

            for(int j = i + 1; j < friends.length; j++) {

                // i가 더 많이 줌
                if(arr[i][j] > arr[j][i]) {
                    nextGift[i]++;
                }

                // j가 더 많이 줌
                else if(arr[i][j] < arr[j][i]) {
                    nextGift[j]++;
                }

                // 주고받은 수 같음
                else {

                    // 선물지수 비교
                    if(score[i] > score[j]) {
                        nextGift[i]++;
                    }
                    else if(score[i] < score[j]) {
                        nextGift[j]++;
                    }

                    // 선물지수도 같으면 아무 일 없음
                }
            }
        }

        // 최댓값 찾기
        for(int i = 0; i < nextGift.length; i++) {

            if(nextGift[i] > answer) {
                answer = nextGift[i];
            }
        }

        return answer;
    }
}