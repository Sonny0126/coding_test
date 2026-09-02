import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int num = 1;
        //map 생성
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        // 2. 각 query마다 테두리 회전 수행
        for (int idx = 0; idx < queries.length; idx++) {
            // 0-based index 변환
            int r1 = queries[idx][0] - 1;
            int c1 = queries[idx][1] - 1;
            int r2 = queries[idx][2] - 1;
            int c2 = queries[idx][3] - 1;
            
            // 회전 시 이동으로 덮어씌워질 시작 위치의 값을 임시 저장
            int temp = map[r1][c1];
            int minVal = temp; // 회전된 숫자들 중 최솟값 저장
            
            // 왼쪽 변: 아래에서 위로 이동
            for (int i = r1; i < r2; i++) {
                map[i][c1] = map[i + 1][c1];
                minVal = Math.min(minVal, map[i][c1]);
            }
            
            // 아래쪽 변: 오른쪽에서 왼쪽으로 이동
            for (int j = c1; j < c2; j++) {
                map[r2][j] = map[r2][j + 1];
                minVal = Math.min(minVal, map[r2][j]);
            }
            
            // 오른쪽 변: 위에서 아래로 이동
            for (int i = r2; i > r1; i--) {
                map[i][c2] = map[i - 1][c2];
                minVal = Math.min(minVal, map[i][c2]);
            }
            
            // 위쪽 변: 왼쪽에서 오른쪽으로 이동
            for (int j = c2; j > c1 + 1; j--) {
                map[r1][j] = map[r1][j - 1];
                minVal = Math.min(minVal, map[r1][j]);
            }
            
            // 임시 저장했던 첫 값을 마지막 위치에 대입
            map[r1][c1 + 1] = temp;
            
            // 최솟값 기록
            answer[idx] = minVal;
        }
        
        return answer;
    }
}