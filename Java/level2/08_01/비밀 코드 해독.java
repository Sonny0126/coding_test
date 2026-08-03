import java.util.*;

class Solution {

    int answer = 0;
    int[] selected = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, 0, n, q, ans);
        return answer;
    }

    // 1~n에서 5개를 선택하는 조합
    void dfs(int start, int depth, int n, int[][] q, int[] ans) {
        // 5개를 모두 선택한 경우
        if (depth == 5) {
            // 모든 질문을 만족하는지 검사
            for (int i = 0; i < q.length; i++) {
                int cnt = 0;

                // q[i]와 현재 선택한 숫자의 일치 개수
                for (int x : q[i]) {
                    for (int y : selected) {
                        if (x == y) cnt++;
                    }
                }
                // 하나라도 다르면 탈락
                if (cnt != ans[i]) return;
            }
            // 모든 질문을 만족
            answer++;
            return;
        }

        // 현재 자리에 i를 넣고
        // 다음 자리로 이동하고
        // i보다 큰 숫자만 선택한다
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1, n, q, ans);
        }
    }
}