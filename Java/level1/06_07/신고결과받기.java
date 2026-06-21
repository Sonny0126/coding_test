import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        // 1. 중복 신고 제거
        Set<String> set = new HashSet<>();
        for(String r : report){
            set.add(r);
        }

        // 2. 신고당한 횟수
        Map<String, Integer> count = new HashMap<>();

        for(String r : set){
            String[] p = r.split(" ");
            String to = p[1];
            //몇 번 신고당했는지 기록
            //to 라는 사람이 Map에 없으면 0 반환
            if(count.containsKey(to)){
                count.put(to, count.get(to) + 1);
            } else {
                count.put(to, 1);
            }
        }

        // 3. 결과 배열
        int[] answer = new int[id_list.length];

        // 4. 다시 돌면서 메일 계산
        for(String r : set){
            String[] p = r.split(" ");
            String from = p[0];
            String to = p[1];

            //신고 당한적이 있고, k번 이상 신고당한 경우
            if(count.get(to) != null && count.get(to) >= k){
                for(int i=0; i<id_list.length; i++){
                    if(id_list[i].equals(from)){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}