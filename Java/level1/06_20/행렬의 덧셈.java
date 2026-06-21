class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int y = arr1.length;       // 행
        int x = arr1[0].length;    // 열

        int[][] answer = new int[y][x];

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}