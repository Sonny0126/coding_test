import java.util.*;

class Solution {
    //이진 트리
    //노드 방문마다 해당 노드에 있는 양과 늑대가 따라옴
    //늑대는 양먹을 기회를 노림 
    //양의 수 <= 늑대의 수 (잡아먹기 가능)
    //잡아먹히지 않도록 조심하면서 최대한 많은 수의 양을 모아서 루트노드로 돌아오기

    int answer = 0;
    int[] info;
    List<Integer>[] graph;

    public int solution(int[] info, int[][] edges) {

        this.info = info;

        // 트리 생성
        graph = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 부모 -> 자식 연결
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        // candidates[다음에 갈 수 있는 곳들]
        List<Integer> candidates = new ArrayList<>();
        dfs(0, 0, 0, candidates);
        return answer;
    }

    public void dfs(int node, int sheep, int wolf, List<Integer> candidates) {

        // 현재 노드 방문
        if (info[node] == 0) {
            sheep++;
        } 
        else {
            wolf++;
        }
        // 늑대가 양보다 많거나 같으면 실패
        if (sheep <= wolf) {
            return;
        }
        // 현재까지 모은 양의 최대값 갱신
        answer = Math.max(answer, sheep);
        // 현재 노드의 자식들을 새로운 후보에 추가
        List<Integer> nextCandidates = new ArrayList<>(candidates);

        for (int child : graph[node]) {
            nextCandidates.add(child);
        }

        // 현재 후보 중 하나를 선택해서 DFS
        for (int i = 0; i < nextCandidates.size(); i++) {
            int next = nextCandidates.get(i);
            // 선택한 노드를 후보에서 제거
            List<Integer> newCandidates =
                    new ArrayList<>(nextCandidates);
            newCandidates.remove(i);
            // 선택한 노드로 이동
            dfs(next, sheep, wolf, newCandidates);
        }
    }
}