class Solution {
    public int solution(String s) {
        String[] word = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < 10; i++) {
            //s문자열안에 word에 값 있을 경우 i로 값 변경
            s = s.replace(word[i], String.valueOf(i));
        }

        //문자열 -> 숫자
        return Integer.parseInt(s);
    }
}