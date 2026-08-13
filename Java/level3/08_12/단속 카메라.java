import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        
        //고속도로 이용차령 경로 route
        //최소한 한번은 단속용 카메라를 만나게 하려면 최소 몇 대 설치해야 하는지

        // 각 구간들이 가장 많은 공통을 가진 부분을 찾고, 새롭게 찾아야 할 경우 찾기
        Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for(int[]route : routes){
          int start = route[0];
          int end = route[1];

          //현재 카메라가 이 차량 구간안에 없다면
          if(camera<start){
            //현재 차량을 가장 오른쪽에 설치할수록, 앞으로 나오는 차량과 겹칠 가능성이 커서, camera를 end에 둠
            camera=end;
            answer++;
          }
        }
        return answer;
    }
}