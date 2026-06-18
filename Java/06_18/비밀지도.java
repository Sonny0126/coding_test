class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        //비밀지도 암호 해독필요
        // 한 변의 길이 n 정사각형
        // #은 벽 " "은 길
        // 전체 지도는 두장의 지도 겹쳐짐
        //각각 지도 2진수로 주어진다

        //1. 두개의 arr값을 배열로 변환
        int [][] nArr1 = new int [arr1.length][arr1.length];
        int [][] nArr2 = new int [arr2.length][arr2.length];


        // arr1 이진수 변환
        for (int i = 0; i < n; i++) {
            int temp = arr1[i];
            for (int j = n - 1; j >= 0; j--) {
                nArr1[i][j] = temp % 2;
                temp /= 2;
            }
        }

        // arr2 이진수 변환
        for (int i = 0; i < n; i++) {
            int temp = arr2[i];
            for (int j = n - 1; j >= 0; j--) {
                nArr2[i][j] = temp % 2;
                temp /= 2;
            }
        }

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = "";

            for (int j = 0; j < n; j++) {
                if (nArr1[i][j] == 1 || nArr2[i][j] == 1) {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }
}