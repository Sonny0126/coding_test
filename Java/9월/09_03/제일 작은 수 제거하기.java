class Solution {
    public int[] solution(int[] arr) {
        // 배열길이 1 이면 -1 반환
        if (arr.length == 1) {
            return new int[]{-1};
        }

        // 최소값 찾기
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 최소값을 제외하고 새 배열에 담기
        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int num : arr) {
            if (num != min) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}