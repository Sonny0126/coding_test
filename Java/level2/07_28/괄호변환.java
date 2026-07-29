import java.util.*;

class Solution {
    public String solution(String p) {
        // 1단계: 빈 문자열인 경우 빈 문자열 반환
        if (p.isEmpty()) {
            return "";
        }

        // 2단계: u, v로 분리 (균형잡힌 괄호 문자열 u 찾기)
        int openCount = 0;
        int closeCount = 0;
        int index = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                openCount++;
            } 
            else {
                closeCount++;
            }

            // '('와 ')'의 개수가 같아지는 순간 최소 단위의 u가 완성됨
            if (openCount == closeCount) {
                index = i;
                break;
            }
        }

        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        // 3단계: u가 "올바른 괄호 문자열"인 경우
        if (isStack(u)) {
            return u + solution(v); // u에 v를 재귀 수행한 결과를 붙임
        }

        // 4단계: u가 "올바른 괄호 문자열"이 아닌 경우
        StringBuilder sb = new StringBuilder();
        sb.append("(");             // 4-1
        sb.append(solution(v));     // 4-2 (v 재귀 수행)
        sb.append(")");             // 4-3

        // 4-4: u의 첫 번째와 마지막 문자를 제거하고, 괄호 방향을 뒤집어서 붙임
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } 
            else {
                sb.append("(");
            }
        }
        return sb.toString();
    }

    // "올바른 괄호 문자열"인지 검사 함수 (Stack 활용)
    private boolean isStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 먼저 나오면 올바르지 않음
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}