import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        //시작시간 기준 정렬
        Arrays.sort(plans, (a, b) -> time(a[1]) - time(b[1]));

        String[] answer = new String[plans.length];

        //멈춘과제 저장할 stack
        Stack<String[]> stack = new Stack<>();
        int idx = 0;

        //현재 진행중인 과제
        String[] cur = plans[0];
        for (int i = 1; i < plans.length; i++) {
            String[] next = plans[i];
            //현재 과제의 종료시간
            int curEnd = time(cur[1]) + Integer.parseInt(cur[2]);
            //다음 과제의 시작 시간
            int nextStart = time(next[1]);

            //현재 과제가 다음과제 시작전에 끝나는 경우
            if (curEnd <= nextStart) {
              //현재 과제 완료
                answer[idx++] = cur[0];

                int now = curEnd;

                //남은 시간동안 멈춰둔 과제 처리
                while (!stack.isEmpty()) {
                  //가장 최근에 멈춘과제부터 꺼냄
                    String[] stopped = stack.pop();
                    int remain = Integer.parseInt(stopped[2]);

                    //멈춘 과제까지 완료할 수 있는 경우
                    if (now + remain <= nextStart) {
                        now += remain;
                        answer[idx++] = stopped[0];
                    } 
                    else {
                      //시간 부족하면 남는시간만 저장ㅇ하고 다시 멈춤
                        stopped[2] = String.valueOf(remain - (nextStart - now));
                        stack.push(stopped);
                        break;
                    }
                }
            } 
            else {
              //다음 과제 먼저 시작하므로 현재 과제 종료
                cur[2] = String.valueOf(curEnd - nextStart);
                stack.push(cur);
            }
            //다음 과제 현재 과제로 변경
            cur = next;
        }
        //마지막 과제 완료
        answer[idx++] = cur[0];

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop()[0];
        }

        return answer;
    }

    public int time(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}