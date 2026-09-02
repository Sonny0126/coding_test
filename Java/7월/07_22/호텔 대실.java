import java.util.*;

class Solution {

    public int change(String time){
        //문자열 시간으로 변환
        String[] arr = time.split(":");

        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour * 60 + min;
    }

    public int solution(String[][] book_time) {
        int answer = 0;

        //퇴실 시간 기준 10분간 청소 후 다른 손님 사용
        //book_time 앞에건 대실시작, 뒤에는 대실 종료시간
        // 시작 +1, 종료 + 청소시간 -1 로 기록
        int[] time = new int[24 * 60 + 10];

        //변환한 시간 Map에 넣기
        for(int i=0; i<book_time.length; i++){

            int startTime = change(book_time[i][0]);
            //청소시간 10분
            int endTime = change(book_time[i][1]) + 10;

            //해당시간부터 새로운 손님 방 사용시작 방 개수 증가
            time[startTime]++;
            //청소 끝난 시간 부터는 방 사용끝 방 개수 감소
            time[endTime]--;
        }

        //endTime 기준 오름차순 정렬
        int count = 0;

        //book_time에서 종료시간이 다음시간의 시작시간 보다 먼저 끝나면 count 1증가
        for(int i=0; i<time.length; i++){
            count += time[i];
            answer = Math.max(answer, count);
        }

        return answer;
    }
}