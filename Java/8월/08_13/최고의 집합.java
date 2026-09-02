class Solution {
    public int[] solution(int n, int s) {

        //s = share x n + left
        //위에 식을 활용한다

        // n개의 자연수로 s를 최대한 균등하게 나눈다.
        int share = s / n;
        int left = s % n;

        //집합 존재하지 않는경우 -1 (몫==0)
        if (share == 0) {
            //길이가 -1인 배열 반환
            return new int[]{-1};
        }

        int[] answer = new int[n];

        // 작은 값을 먼저 넣기
        for (int i = 0; i < n - left; i++) {
            answer[i] = share;
        }

        // 나머지 1씩 더하기
        for (int i = n - left; i < n; i++) {
            answer[i] = share + 1;
        }

        return answer;
    }
}