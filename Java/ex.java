import java.util.HashSet;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();

        StringBuilder blinds = new StringBuilder(message);
        for (int[] range: spoiler_ranges) {
            for (int i=range[0]; i<=range[1]; ++i) {
                if (blinds.charAt(i) != ' ')
                    blinds.setCharAt(i, '*');
            }
        }

        for (String word: blinds.toString().split(" ")) {
            set.add(word);
        }

        for (String word: message.split(" ")) {
            if (!set.contains(word)) {
                ++answer;
                set.add(word);
            }
        }

        return answer;
    }
}