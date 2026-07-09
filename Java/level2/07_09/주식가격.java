import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();

        //초 단위로 기록된 주식가격 담긴 prices 매개변수로 주어질 때 가격 떨어지지 않은 기간 몇 초인지 return
        for(int i=0; i<prices.length; i++){
          int count=0;
          for(int j=i+1; j<prices.length; j++){
            if(prices[i]<=prices[j]){
              count++;
            }
          }
          //list에 증가된 값 넣기
          list.add(count);
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}