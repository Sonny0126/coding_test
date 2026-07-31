import java.util.*;
class Solution {

    List<int[]> list = new ArrayList<>();
    void hanoi(int n, int start, int mid, int end) {

        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }

        hanoi(n - 1, start, end, mid);
        list.add(new int[]{start, end});
        hanoi(n - 1, mid, start, end);
    }

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}