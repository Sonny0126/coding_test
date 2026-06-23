class Solution {
    public int solution(int n) {
        //1. n의 다음 큰 숫자는 n보다 큼
        //2. n의 다음 큰 숫자와 n은 2진수변호나시 1의 개수가 동일
        //3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 가장 작은 수

        int count = Integer.bitCount(n);

        for(int i=n+1 ; ; i++){
          if(Integer.bitCount(i)==count){
            return i;
          }
        }
    }
}