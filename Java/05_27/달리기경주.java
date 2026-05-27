import java.util.*;

class Solution {

    public String[] solution(String[] players, String[] callings) {

        // 이름 -> 현재 순위 저장
        Map<String, Integer> map = new HashMap<>();

        // 초기 순위 저장
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        // 호출된 선수 처리
        for(int i = 0; i < callings.length; i++) {

            String call = callings[i];

            // 현재 위치
            int idx = map.get(call);

            // 앞 선수 이름
            String frontPlayer = players[idx - 1];

            // players 배열에서 자리 교환
            players[idx - 1] = call;
            players[idx] = frontPlayer;

            // map 위치 업데이트
            map.put(call, idx - 1);
            map.put(frontPlayer, idx);
        }

        return players;
    }
}