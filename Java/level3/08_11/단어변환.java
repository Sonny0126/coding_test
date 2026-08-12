import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // target이 words에 없으면 변환 X
        boolean check = false;
        for (String word : words) {
            if (word.equals(target)) {
                check = true;
                break;
            }
        }

        if (!check) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Queue<Integer> cnt = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(begin);
        cnt.offer(0);

        //BFS를 이용해 begin -> start 가는 가장
        //짧은 경로를 찾는 역할
        while (!q.isEmpty()) {
            String current = q.poll();
            int depth = cnt.poll();

            // target 도착
            if (current.equals(target)) {
                return depth;
            }

            // 현재 단어에서 한 글자만 바꿔서 갈 수 있는 단어 탐색
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(current, words[i])) {
                    visited[i] = true;

                    q.offer(words[i]);
                    cnt.offer(depth + 1);
                }
            }
        }
        return 0;
    }

    //두 단어가 알파벳 1개만 다른지 검사하는 코드
    private boolean canChange(String a, String b) {
        
        //다른 글자 개수
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        if (diff == 1) 
            return true;
        else 
            return false;
    }
}