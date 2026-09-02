import java.util.*;

class Solution {
    Map<Integer, List<Integer>> tree = new HashMap<>();

    public int solution(int n, int[][] wires) {
        // 그래프 생성
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            //비어있다면 a를 ArrayList에 추가
            tree.putIfAbsent(a, new ArrayList<>());
            tree.putIfAbsent(b, new ArrayList<>());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int answer = Integer.MAX_VALUE;

        // 전선 하나씩 끊기
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];

            int count = dfs(1, visited, wire[0], wire[1]);

            //모든 전선을 끊어 본 뒤, 가장 작은 차이를 반환
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        return answer;
    }

    int dfs(int now, boolean[] visited, int cutA, int cutB) {
        visited[now] = true;
        int count = 1;
        for (int next : tree.get(now)) {
            // 끊은 전선이면 건너뛰기
            if ((now == cutA && next == cutB) ||
                (now == cutB && next == cutA)) {
                continue;
            }
            if (!visited[next]) {
                count += dfs(next, visited, cutA, cutB);
            }
        }

        return count;
    }
}