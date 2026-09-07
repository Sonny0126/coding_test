import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            // 스택이 비어있거나, 최상단 값이 현재 값과 다를 때만 push
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}