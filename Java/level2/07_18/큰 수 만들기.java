import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        //앞자리 숫자를 최대한 크게 만들기
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 아직 제거할 개수가 남아있다면 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}