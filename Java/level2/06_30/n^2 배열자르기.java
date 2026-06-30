class Solution {
    public int[] solution(int n, long left, long right) {

        // left ~ right까지의 개수만큼만 결과 배열 생성
        int[] answer = new int[(int)(right - left + 1)];

        // answer 배열에 값을 넣기 위한 인덱스
        int idx = 0;

        // left부터 right까지 하나씩 확인
        for (long i = left; i <= right; i++) {

            // 1차원 인덱스를 2차원 배열의 행(row)으로 변환
            //n = 4, i = 6 -> row = 1
            long row = i / n;

            // 1차원 인덱스를 2차원 배열의 열(col)으로 변환
            //n = 4, i = 6 -> col = 2
            long col = i % n;

            // 해당 위치의 값은 max(행, 열) + 1
            // (0,0) -> 1
            // (0,2) -> 3
            // (2,1) -> 3
            // (3,3) -> 4
            answer[idx] = (int)(Math.max(row, col) + 1);

            // 다음 answer 위치로 이동
            idx++;
        }

        return answer;
    }
}