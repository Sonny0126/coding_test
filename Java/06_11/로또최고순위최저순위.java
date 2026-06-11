class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        // 알아볼수 없는 번호 0
        // 최저, 최고 출력
        int max=0;
        int min=0;

        //최대일 때
        for(int i=0; i<lottos.length; i++){
          if(lottos[i]==0) {
            max++;
            continue;
          }

          for(int j=0; j<win_nums.length; j++){
            if(lottos[i]==win_nums[j]){
              max++;
              break;
            }
          }
        }

        // 최저일 때
        for(int i = 0; i < lottos.length; i++) {

            if(lottos[i] == 0) continue;

            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    min++;
                    break;
                }
            }
        }

        //6개 다 맞으면 1등, 다 틀리면 6등
        int maxRank, minRank;
        if(max < 2) maxRank=6;
        else maxRank=7-max;

        if(min < 2) minRank=6;
        else minRank=7-min;

        int [] answer = {maxRank, minRank};

        return answer;
    }
}