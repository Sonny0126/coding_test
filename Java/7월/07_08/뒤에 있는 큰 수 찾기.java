import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        //자신보다 뒤에 있는 숫자중에서 자신보다 크면서 가장 가까이있는 수 -> 뒷 큰수
        //뒷큰수들을 차례로 배열에 담아 출력
        int n = numbers.length;
        int []  answer = new int [n];

        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
          while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
            int temp = stack.pop();
            answer[temp] = numbers[i];
          }
          stack.push(i);
        }

        return answer;
    }
}