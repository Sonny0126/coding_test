import java.util.*;

class Solution {

    static class Job {
        int request;
        int duration;
        int number;

        Job(int request, int duration, int number) {
            this.request = request;
            this.duration = duration;
            this.number = number;
        }
    }

    public int solution(int[][] jobs) {

        List<Job> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            list.add(new Job(jobs[i][0], jobs[i][1], i));
        }

        // 요청 시간이 빠른 순
        list.sort((a, b) -> a.request - b.request);

        // 소요 시간 → 요청 시간 → 번호
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration) {
                return a.duration - b.duration;
            }

            if (a.request != b.request) {
                return a.request - b.request;
            }

            return a.number - b.number;
        });

        int time = 0;
        int index = 0;
        int total = 0;

        while (index < list.size() || !pq.isEmpty()) {

            // 현재 시각까지 들어온 작업 추가
            while (index < list.size()
                    && list.get(index).request <= time) {

                pq.offer(list.get(index));
                index++;
            }

            // 처리할 작업이 없다면 다음 요청 시간으로 이동
            if (pq.isEmpty()) {
                time = list.get(index).request;
                continue;
            }

            // 가장 우선순위 높은 작업 실행
            Job job = pq.poll();

            time += job.duration;

            total += time - job.request;
        }

        return total / jobs.length;
    }
}