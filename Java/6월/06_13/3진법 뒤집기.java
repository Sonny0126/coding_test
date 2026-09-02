class Solution {
    public int solution(int n) {
        //n을 3진법 상에서 앞뒤로 뒤집고, 다시 10진법으로 표현한 수 return
        //ex) 45(10) -> 1200(3) -> 0021(앞뒤반전 3) -> 7(10)
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }
}