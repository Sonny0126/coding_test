import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = 0;

        for(int i=0; i<s.length(); i++){

            // 왼쪽으로 i칸 회전
            //abcde라면
            // i=1 일때, s.substring(1) = 'bcde', s.substring(0,1) ='a'
            String rotated = s.substring(i) + s.substring(0, i);

            //회전 가능하다
            if(isCorrect(rotated)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(c == ')'){
                //스택 비어있거나, 뽑은 값이 '('이 아니라면
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            else if(c == '}'){
              //스택 비어있거나, 뽑은 값이 '{'이 아니라면
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
            else if(c == ']'){
              //스택 비어있거나, 뽑은 값이 '['이 아니라면
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}