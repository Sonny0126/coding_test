import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(begin);
        int count = 0;

        //비기 전까지
        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                String current = q.poll();

                for (int j = 0; j < words.length; j++) {
                    // 아직 방문하지 않았고 한 글자만 다른 경우
                    if (!visited[j] && canChange(current, words[j])) {
                        // target에 도착
                        if (words[j].equals(target)) {
                            return count;
                        }
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
        }
        return 0;
    }

    // 두 단어가 한 글자만 다른지 확인
    public boolean canChange(String a, String b) {
        int temp = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                temp++;
            }
        }

        if (temp == 1) 
            return true;
        else 
            return false;
    }
}