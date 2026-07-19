class Solution {
    public int solution(int storey) {
        int answer = 0;
        //엘리베이터 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않는다
        //엘리베이터움직이려면 마법의 돌 1개 사용
        //최소한 버튼으로 이동

        //필요한 마법의 돌 개수
        //+1, -1, +10, -10, +100, -100, ... 
        
        //모든 자리수 처리할 때까지
        while(storey>0){
          //현재 처리할 수
          int num = storey %10;

          //6~9 위로 올라가는게 더 적은 횟수
          if(num > 5){
            answer += 10 - num;
            storey += 10;
          }
          //0~4 아래로 내려가ㅏ는 것이 더 적은 횟수
          else if (num < 5) {
            answer += num;
          }

          //현재 5인 경우
          else{
            int next = (storey/10) % 10;
            if(next >=5 ){
              answer+=5;
              storey+=10;
            }
            else{
              answer += 5;
            }
          }
          storey /= 10;
        }

        return answer;
    }
}