class Solution {
    public int solution(int sticker[]) {
        int n =sticker.length;

        //스티커 1장인 경우
        if(n==1){
          return sticker[0];
        }

        //원형이므로 case를 2개로 나눈다

        //1. 첫번째 스티커 선택경우
        int case1 = maxSum(sticker, 0, n-2);
        //2. 첫번쨰 스티커 선택하지 않는 경우
        int case2 = maxSum(sticker, 1, n-1);

        return Math.max(case1, case2);
    }

    public int maxSum(int[] sticker, int start, int end){
      //2칸 전까지 최대값
      int prev2=0;
      //1칸 전까지 최대값
      int prev1=0;

      for(int i=start; i<=end; i++){
          //현재 스티커를 선택하는 경우
          int select = prev2 + sticker[i];

          //현재 스티커 선택하지 않느 경우
          int notSelect = prev1;

          int cur = Math.max(select, notSelect);

          //DP값 갱신
          prev2=prev1;
          prev1=cur;
      }
      return prev1;
    }
}