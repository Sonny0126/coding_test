import java.util.*;

class Solution {
    // 6가지 연산자 우선순위 조합
    static char[][] priorities = {
        {'+', '-', '*'},
        {'+', '*', '-'},
        {'-', '+', '*'},
        {'-', '*', '+'},
        {'*', '+', '-'},
        {'*', '-', '+'}
    };

    public long solution(String expression) {
        long MAX = 0;

        // 수식에서 숫자와 연산자를 분리하여 리스트에 저장
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        StringBuilder numStr = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(numStr.toString()));
                numStr.setLength(0); // 초기화
                ops.add(c);
            } else {
                numStr.append(c);
            }
        }
        numbers.add(Long.parseLong(numStr.toString())); // 마지막 숫자 추가

        // 6가지 우선순위 조합 각각에 대해 계산 수행
        for (char[] priority : priorities) {
            // 원본 리스트 복사
            List<Long> cpNumbers = new ArrayList<>(numbers);
            List<Character> cpOps = new ArrayList<>(ops);

            // 우선순위 순서대로 연산자 처리
            for (char op : priority) {
                for (int i = 0; i < cpOps.size(); i++) {
                    if (cpOps.get(i) == op) {
                        // i번째 연산자 기준 좌우 숫자 계산
                        long num1 = cpNumbers.get(i);
                        long num2 = cpNumbers.get(i + 1);
                        long result = calculate(num1, num2, op);

                        // 계산된 결과로 리스트 갱신
                        cpNumbers.remove(i + 1);
                        cpNumbers.set(i, result);
                        cpOps.remove(i);
                        i--;
                    }
                }
            }

            // 최종 결과의 절댓값으로 최댓값 갱신
            long temp = Math.abs(cpNumbers.get(0));
            MAX = Math.max(MAX, temp);
        }

        return MAX;
    }

    public long calculate(long a, long b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        return a * b;
    }
}