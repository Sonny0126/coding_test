class Solution {

    public int solution(int[] mats, String[][] park) {

        // 큰 값부터 정렬 (내림차순)
        for(int i = 0; i < mats.length - 1; i++) {
            for(int j = i + 1; j < mats.length; j++) {

                if(mats[i] < mats[j]) {
                    int temp = mats[i];
                    mats[i] = mats[j];
                    mats[j] = temp;
                }
            }
        }

        // 큰 돗자리부터 검사
        for(int m = 0; m < mats.length; m++) {

            int size = mats[m];

            // 시작 위치 탐색
            for(int i = 0; i <= park.length - size; i++) {
                for(int j = 0; j <= park[0].length - size; j++) {

                    boolean check = true;

                    // size x size 확인
                    for(int x = i; x < i + size; x++) {
                        for(int y = j; y < j + size; y++) {

                            // 사람이 있으면 실패
                            if(!park[x][y].equals("-1")) {
                                check = false;
                                break;
                            }
                        }

                        if(!check) {
                            break;
                        }
                    }

                    // 가능하면 바로 반환
                    if(check) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }
}