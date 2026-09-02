class Solution {
    public int solution(int[] stones, int k) {
        //징검다리 일렬로, 디딤돌에 숫자 있고, 한번 밟을 때마다 1식 줄어듦. 0이되면 더이상 밟을 수 없고, 디딤돌로 한번에 여러칸 건너뛸수 있음. 다음 디딤돌 여러개인 경우 가장 가까운 디딤돋로 이동

        //최대 몇명까지 건너갈 수 있는지
        int left = 1;
        int right = 0;
        for(int stone : stones){
          right = Math.max(right, stone);
        }

        while(left <= right){
          int mid = (left+right)/2;

          if(canCross(stones, k, mid)){
            left = mid+1;
          }
          else{
            right = mid-1;
          }
        }
        return right;
    }

    public boolean canCross(int [] stones, int k, int people){
      int skip=0;

      for(int stone : stones){
        if(stone - people < 0){
          skip++;

          if(skip>=k)
            return false;
        }
        else{
          skip=0;
        }
      }
      return true;
    }
}