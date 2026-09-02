class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            // 짝수: 마지막 비트 0을 1로 변경
            if (n % 2 == 0) {
                answer[i] = n + 1;
                continue;
            }
            String binary = Long.toBinaryString(n);
            // 가장 앞자리 0을 확보
            char[] bits = ("0" + binary).toCharArray();
            // 오른쪽부터 가장 가까운 0 찾기
            for (int j = bits.length - 1; j >= 0; j--) {
                if (bits[j] == '0') {
                    // 0 -> 1
                    bits[j] = '1';
                    // 바로 오른쪽 비트 1 -> 0
                    if (j + 1 < bits.length) {
                        bits[j + 1] = '0';
                    }
                    break;
                }
            }
            //2진수 배열 -> 문자열 변환, 2진수로 해석해서 10진수 Long값으로 변경
            answer[i] = Long.parseLong(new String(bits), 2);
        }
        return answer;
    }
}