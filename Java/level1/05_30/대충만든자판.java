class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] alpha = new int[26];

        // 초기값 설정
        for (int i = 0; i < 26; i++) {
            alpha[i] = 101;
        }

        // 각 알파벳의 최소 입력 횟수 저장
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {

                int idx = keymap[i].charAt(j) - 'A';

                if (j + 1 < alpha[idx]) {
                  //지금 발견한 입력횟수가 기존값보다 작으면 갱신
                    alpha[idx] = j + 1;
                }
            }
        }

        int[] answer = new int[targets.length];

        // targets 계산
        for (int i = 0; i < targets.length; i++) {

            int sum = 0;

            for (int j = 0; j < targets[i].length(); j++) {

                int idx = targets[i].charAt(j) - 'A';

                // 입력 불가능한 문자
                if (alpha[idx] == 101) {
                    sum = -1;
                    break;
                }

                sum += alpha[idx];
            }

            answer[i] = sum;
        }

        return answer;
    }
}