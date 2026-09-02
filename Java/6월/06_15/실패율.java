import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] failCount = new int[N + 2]; // 1~N 진행 스테이지이고 N+1은 게임 다 깬사람이므로 다 깬 사람까지 포함해야해서 N+2
        int people = stages.length;        // 전체 사람 수

        // 1. 각 스테이지에 몇 명 멈췄는지 세기
        for (int s : stages) {
            failCount[s]++;
        }

        // 2. 실패율 저장할 배열
        double[] rate = new double[N + 1];

        // 3. 실패율 계산
        for (int i = 1; i <= N; i++) {

            if (people == 0) {
                rate[i] = 0;
            } else {
                rate[i] = (double) failCount[i] / people;
            }

            people -= failCount[i]; // 다음 스테이지로 넘어간 사람 제외
        }

        // 4. 스테이지 번호 배열 만들기
        Integer[] stage = new Integer[N];

        for (int i = 0; i < N; i++) {
            stage[i] = i + 1;
        }

        // 5. 실패율 기준으로 정렬
        Arrays.sort(stage, (a, b) -> {
            if (rate[b] == rate[a]) return a - b; // 같으면 작은 번호 먼저
            return Double.compare(rate[b], rate[a]); // 큰 실패율 먼저
        });

        // 6. 결과 넣기
        for (int i = 0; i < N; i++) {
            answer[i] = stage[i];
        }

        return answer;
    }
}