class Solution {
    public int solution(int[][] signals) {

        for (int t = 1; t <= 2000000; t++) {

            boolean ok = true;

            for (int i = 0; i < signals.length; i++) {

                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];

                int cycle = g + y + r;

                int pos = (t - 1) % cycle + 1;

                if (!(pos > g && pos <= g + y)) {
                    ok = false;
                    break;
                }
            }

            if (ok) return t;
        }

        return -1;
    }
}