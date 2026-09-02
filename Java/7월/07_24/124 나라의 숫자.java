class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        //124 나라에 자연수만 존재
        //124 나라에서 모든 수는 1,2,4만 사용
        String [] numbers = {"4", "1", "2"};

        while(n>0){
          //3으로 나눌 때 나머지 0,1,2를 착안해서 0만 4로 변환
          int temp = n%3;
          n /=3;

          //나머지가 0이면 나누어떨어지므로 n을 1 빼줘야 다음 자릿수가 맞음
          if(temp==0) n-=1;

          sb.insert(0, numbers[temp]);
        }

        return sb.toString();
    }
}