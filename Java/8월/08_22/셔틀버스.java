import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 1. 크루들의 도착 시각을 분으로 변환 후 정렬
        int[] crewTimes = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] parts = timetable[i].split(":");

            crewTimes[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        Arrays.sort(crewTimes);

        int shuttleTime = 9 * 60; // 09:00
        int crewIdx = 0;
        int lastCrewTime = 0;
        int myTime = 0;

        // 2. n번의 셔틀 운행 시뮬레이션
        for (int i = 0; i < n; i++) {
            int curShuttle = shuttleTime + (i * t);
            int count = 0;

            // 현재 셔틀에 탈 수 있는 크루 탑승 처리
            while (count < m && crewIdx < crewTimes.length && crewTimes[crewIdx] <= curShuttle) {
                lastCrewTime = crewTimes[crewIdx];
                crewIdx++;
                count++;
            }

            // 3. 마지막 셔틀일 때 콘의 시간 결정
            if (i == n - 1) {
                if (count < m) {
                    // 자리가 남아있으면 셔틀 도착 시간에 도착
                    myTime = curShuttle;
                } 
                else {
                    // 자리가 꽉 찼다면 마지막으로 탄 크루보다 1분 일찍 도착
                    myTime = lastCrewTime - 1;
                }
            }
        }

        // 4. "HH:MM" 형식 문자열로 변환
        int hour = myTime / 60;
        int minute = myTime % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}