class Solution
{
    public int solution(int n, int a, int b)
    {
        //1번<->2번, 3번<->4번, .. , N-1 번 참가자끼리 경기
        //다음 라운드 진출할 참가자 번호는 1~N/2 까지 배정
        //A와 B는 서로 붙기 전까지 항상 이긴다
        //게임 참가자 수 : N  

        int round=0;

        while (a != b){
          a = (a+1)/2;
          b = (b+1)/2;
          round++;
        }

        return round;
    }
}