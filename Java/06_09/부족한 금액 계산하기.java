class Solution {
    public long solution(int price, int money, int count) {

        //놀이기구 N번째 이용시, 원래 이용료의 N배
        // count만큼 타면 얼마 모자른지, 안 부족하면 0 return
        long sum = 0;

        for (long i = 1; i <= count; i++) {
            sum += price * i;
        }

        if (sum <= money)
            return 0;

        return sum - money;
    }
}