import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        //stack 구조로
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i < s.length(); i++) {
          //스택 맨위 값과, 넣으려던값이 같으면 맨 위값 꺼내기
          if(!stack.isEmpty() && (stack.peek() == s.charAt(i))){
            stack.pop();
          }
          else {
            stack.push(s.charAt(i));
          }
        }
        if(stack.size()==0) answer=1;

        return answer;
    }
}