import java.util.*;

class Solution {

    static int[] parent;

    public int solution(int n, int[][] costs) {

        // 1. 비용기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        //어느 그룹에 속해 있는지 확인하기 위한 용도(실제 양방향 연결 X)
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;

        // 비용이 적은 다리부터 확인하기
        for (int[] cost : costs) {

            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];

            // 두 섬이 이미 연결되어 있지 않은 경우에만 다리 건설
            if (find(island1) != find(island2)) {

                union(island1, island2);

                answer += bridgeCost;
                count++;
            }

            // 섬이 n개라면 n-1개의 다리만 있으면 모두 연결 가능
            if (count == n - 1) {
                break;
            }
        }

        return answer;
    }

    // 부모를 찾는 함수
    public int find(int x) {

        // x가 자기 자신을 부모로 가지고 있다면
        // x가 대표 섬이다.
        if (parent[x] == x) {
            return x;
        }

        // 부모를 찾아서 저장
        parent[x] = find(parent[x]);

        return parent[x];
    }

    // 두 섬을 연결하는 함수
    public void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        // 두 섬의 대표를 연결
        parent[rootB] = rootA;
    }
}