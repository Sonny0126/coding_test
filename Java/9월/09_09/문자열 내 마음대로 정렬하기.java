import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String a, String b) {
                // n번째 글자가 다르면 n번째 글자를 기준으로 정렬
                if (a.charAt(n) != b.charAt(n)) {
                    return a.charAt(n) - b.charAt(n);
                }
                // n번째 글자가 같으면 사전순으로 정렬
                return a.compareTo(b);
            }
        });
        return strings;
    }
}