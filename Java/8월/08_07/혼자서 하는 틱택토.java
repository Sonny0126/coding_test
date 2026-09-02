class Solution {
    public int solution(String[] board) {
        //혼자서 선공, 후공 둘다
        // O,X번걸아가면서

        // O 개수, X개수 정상인가
        //          |
        //  승리한 사람이 있는가
        //    |             |
        // 없다            있다
        //   |              |
        // 정상 개수     둘 다 이겼나?
        //                  |
        //                아니면
        //                  |
        //             이긴 사람 마지막 차례?
        
        int o = 0;
        int x = 0;

        // O, X 개수 세기
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'O') o++;
                if (c == 'X') x++;
            }
        }

        // O는 X보다 많아야 하고, 최대 1개만 많을 수 있음
        if (o < x || o > x + 1) {
            return 0;
        }

        boolean ow = win(board, 'O');
        boolean xw = win(board, 'X');

        // 둘 다 이겼다면 불가능
        if (ow && xw) {
            return 0;
        }

        // O가 이겼다면 O가 마지막으로 놓은 것
        if (ow) {
            return o == x + 1 ? 1 : 0;
        }

        // X가 이겼다면 X가 마지막으로 놓은 것
        if (xw) {
            return o == x ? 1 : 0;
        }

        return 1;
    }

    private boolean win(String[] board, char c) {

        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c &&
                board[i].charAt(1) == c &&
                board[i].charAt(2) == c) {
                return true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == c &&
                board[1].charAt(i) == c &&
                board[2].charAt(i) == c) {
                return true;
            }
        }

        // 대각선 ↘
        if (board[0].charAt(0) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(2) == c) {
            return true;
        }

        // 대각선 ↙
        if (board[0].charAt(2) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(0) == c) {
            return true;
        }

        return false;
    }
}