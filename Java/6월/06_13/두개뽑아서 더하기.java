import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
      //2개의 수를 뽑아 더해서 만들수 있는 모든 수 set에 담음(중복 X)
      Set<Integer> set = new HashSet<>();

      for(int i=0; i<numbers.length; i++){
        for(int j=i+1; j<numbers.length; j++){
          set.add(numbers[i] + numbers[j]);
        }
      }

      //set -> 배열 변환
      //stream 생성, mapToInt는 Stream<Integer> -> IntStream
      //IntStream 
      int [] arr = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}