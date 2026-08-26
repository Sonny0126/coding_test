import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {

        int[] up = new int[n];
        int[] down = new int[n];

        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 삭제된 행을 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        // 현재 선택된 행
        int cur = k;

        // 실제로 삭제된 행인지 확인
        boolean[] removed = new boolean[n];

        for (String command : cmd) {
            char type = command.charAt(0);

            // U X : X칸 위로 이동
            if (type == 'U') {
                int x = Integer.parseInt(command.substring(2));

                for (int i = 0; i < x; i++) {
                    cur = up[cur];
                }

            }

            // D X : X칸 아래로 이동
            else if (type == 'D') {
                int x = Integer.parseInt(command.substring(2));

                for (int i = 0; i < x; i++) {
                    cur = down[cur];
                }

            }

            // C : 현재 행 삭제
            else if (type == 'C') {

                deleted.push(cur);
                removed[cur] = true;

                int p = up[cur];
                int nxt = down[cur];

                // 이전 행과 다음 행을 연결
                if (p != -1) {
                    down[p] = nxt;
                }

                if (nxt != n) {
                    up[nxt] = p;
                }

                // 삭제한 행이 가장 아래였다면 위 행 선택
                if (nxt == n) {
                    cur = p;
                }
                // 그렇지 않으면 바로 아래 행 선택
                else {
                    cur = nxt;
                }
            }

            // Z : 가장 최근 삭제 행 복구
            else if (type == 'Z') {

                int restore = deleted.pop();
                removed[restore] = false;

                int p = up[restore];
                int nxt = down[restore];

                // 복구할 행을 다시 연결
                if (p != -1) {
                    down[p] = restore;
                }

                if (nxt != n) {
                    up[nxt] = restore;
                }
            }
        }

        // 결과 생성
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (removed[i]) {
                answer.append('X');
            } else {
                answer.append('O');
            }
        }

        return answer.toString();
    }
}