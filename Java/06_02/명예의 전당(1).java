class Solution {
    public int[] solution(int k, int[] score) {

        // 매일 발표할 최하위 점수를 저장할 배열
        int[] answer = new int[score.length];

        // 명예의 전당 저장 공간
        int[] temp = new int[k];

        // 현재 명예의 전당에 들어있는 사람 수
        int size = 0;

        // 매일 점수를 하나씩 확인
        for (int i = 0; i < score.length; i++) {

            // 아직 명예의 전당이 꽉 차지 않은 경우
            if (size < k) {

                // 그냥 추가
                temp[size] = score[i];
                size++;

            } else {

                // 명예의 전당에서 가장 낮은 점수 찾기
                int min = 0;

                for (int j = 1; j < k; j++) {
                    if (temp[j] < temp[min]) {
                        min = j;
                    }
                }

                // 새 점수가 최하위 점수보다 크면 교체
                if (score[i] > temp[min]) {
                    temp[min] = score[i];
                }
            }

            // 현재 명예의 전당의 최하위 점수 찾기
            int min = temp[0];

            for (int j = 1; j < size; j++) {
                if (temp[j] < min) {
                    min = temp[j];
                }
            }

            // 오늘 발표할 점수 저장
            answer[i] = min;
        }

        return answer;
    }
}