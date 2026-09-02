class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right - left + 1)];

        // 인덱스
        int idx = 0;

        //배열 크기가 커져서 long으로 받기
        for (long i = left; i <= right; i++) {

            // 1차원 인덱스를 2차원 배열의 행(row)
            //n = 4, i = 6 -> row = 1
            long row = i / n;

            // 1차원 인덱스를 2차원 배열의 열(col)
            //n = 4, i = 6 -> col = 2
            long col = i % n;

            // 해당 위치의 값은 max(행, 열) + 1
            // (0,0) -> 1
            // (0,2) -> 3
            // (2,1) -> 3
            // (3,3) -> 4
            // 마지막 변환시에 long ->Int로
            answer[idx] = (int)(Math.max(row, col) + 1);
            idx++;
        }

        return answer;
    }
}