```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        //1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
        //2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
        //3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
        //3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

        Queue<Integer> q = new LinkedList<>();

        //우선순위 기준으로 순서
        for (int priority : priorities) {
            q.add(priority);
        }

        while (!q.isEmpty()) {
          //첫번째 값 뽑아서 버림
            int temp = q.poll();

            boolean bigger = false;

            // 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 확인(가장 큰 값 temp 체크)
            for (int p : q) {
                //우선순위가 temp보다 크면
                if (p > temp) {
                    //큰 값 확인
                    bigger = true;
                    break;
                }
            }

            // 우선순위가 더 높은 프로세스가 있다면 다시 큐에 삽입
            if (bigger) {
                //다시 q 꽁무니에 삽입
                q.add(temp);

                // 찾고 있는 프로세스 위치 갱신
                if (location == 0) {
                    location = q.size() - 1;
                } 
                else {
                    location--;
                }
            }
            // 없다면 실행
            else {
                //값 증가
                answer++;

                // location 위치의 프로세스라면 실행 순서 반환
                if (location == 0) {
                    return answer;
                }

                location--;
            }
        }

        return answer;
    }
}
