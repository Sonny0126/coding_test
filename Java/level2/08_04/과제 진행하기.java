import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        //시작시간 기준 정렬
        Arrays.sort(plans, (a, b) -> time(a[1]) - time(b[1]));

        String[] answer = new String[plans.length];

        //멈춘과제 저장할 stack
        Stack<String[]> stack = new Stack<>();
        int idx = 0;

        String[] cur = plans[0];

        for (int i = 1; i < plans.length; i++) {
            String[] next = plans[i];

            int curEnd = time(cur[1]) + Integer.parseInt(cur[2]);
            int nextStart = time(next[1]);

            if (curEnd <= nextStart) {
                answer[idx++] = cur[0];

                int now = curEnd;

                while (!stack.isEmpty()) {
                    String[] stopped = stack.pop();
                    int remain = Integer.parseInt(stopped[2]);

                    if (now + remain <= nextStart) {
                        now += remain;
                        answer[idx++] = stopped[0];
                    } else {
                        stopped[2] = String.valueOf(remain - (nextStart - now));
                        stack.push(stopped);
                        break;
                    }
                }
            } else {
                cur[2] = String.valueOf(curEnd - nextStart);
                stack.push(cur);
            }

            cur = next;
        }

        answer[idx++] = cur[0];

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop()[0];
        }

        return answer;
    }

    private int time(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}