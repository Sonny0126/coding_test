import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> q = new LinkedList<>();
        // 다리를 빈칸(0)으로 채움
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        int time = 0;
        int curWeight = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            time++;
            // 다리에서 하나 나감
            curWeight -= q.poll();
            // 다음 트럭이 올라갈 수 있는지
            if (curWeight + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } 
            else {
                // 못 올라가면 빈칸(0)
                q.offer(0);
            }
        }
        // 마지막 트럭이 다리를 건너는 시간
        return time + bridge_length;
    }
}