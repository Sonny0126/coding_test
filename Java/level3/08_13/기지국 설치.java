class Solution {
    public int solution(int n, int[] stations, int w) {
        //N개의 아파트 일렬로, 일부 아파트 옥상 4g, 4g -> 5g로 바꾸려고 함
        //5g는 4g보다 전달 범위가 좁아 4g -> 5g로 바꾸면 어떤 아파트에 전파 도달 x
        //5g 기지국 최소로 설치하면서, 최소값 return
        //

        int answer =0;
        //w는 전파 도달거리
        int cover = 2*w + 1;

        //현재 확인할 아파트
        int start = 1;

        for(int station : stations){
          //현재 기지국 전파가 닿기 시작하는 위치
          int left = station-w;
          //start ~ left-1이 빈 구간
          if(start<left){
            int gap = left - start;
            answer += (gap+cover-1)/cover;
          }
          //현재 기지국 커버하는 마지막 위치 다음부터 확인
          start = station + w +1;
        }

        //마지막으로 처리한 기지국의 전파가 닿는 곳 바로 다음 아파트
        if(start <= n){
          int gap = n - start +1;
          answer += (gap+cover-1)/cover;
        }

        return answer;
    }
}