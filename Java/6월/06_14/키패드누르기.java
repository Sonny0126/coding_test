class Solution {

    public int distance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0])
             + Math.abs(pos1[1] - pos2[1]);
    }

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        // 0~9의 위치
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9
        };

        // 초기 위치
        int[] left = {3, 0};   // *
        int[] right = {3, 2};  // #

        for (int num : numbers) {

            // 왼쪽 열
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = keypad[num];
            }

            // 오른쪽 열
            else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = keypad[num];
            }

            // 가운데 열 (2,5,8,0)
            else {

                int leftDist = distance(left, keypad[num]);
                int rightDist = distance(right, keypad[num]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    left = keypad[num];
                }
                else if (rightDist < leftDist) {
                    answer.append("R");
                    right = keypad[num];
                }
                else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = keypad[num];
                    } else {
                        answer.append("L");
                        left = keypad[num];
                    }
                }
            }
        }

        return answer.toString();
    }
}