class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

  
        int[][] answer = new int[arr1.length][arr2[0].length];

        // arr1 행
        for(int i=0; i<arr1.length; i++){
          // arr2 열
          for(int j=0; j<arr2[0].length; j++){
            // arr1 열 = arr2 행 (곱셉이 되려면 둘이 같아야 하기 때문에)
            for(int k=0; k< arr1[0].length; k++){
              answer[i][j] += arr1[i][k] * arr2[k][j];
            }
          }
        }

        return answer;
    }
}