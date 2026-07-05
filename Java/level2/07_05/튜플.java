import java.util.*;

class Solution {
    public int[] solution(String s) {

        // {{, }} 제거
        s = s.substring(2, s.length()-2);

        // }, { 기준으로 문자열 자르기
        String[] group = s.split("\\},\\{");

        //집합 원소 개수 작은순서대로 정렬
        Arrays.sort(group,
            (a,b) -> a.split(",").length - b.split(",").length);

        //1. 중복된 원소 있을 수 있음
        //2. 원소 정해진 순서 있으며, 원소 순서다르면 다른 튜플
        //3. 튜플의 원소 개수는 유한
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[group.length];
        int idx = 0;

        for(String g : group){
            String[] nums = g.split(",");

            for(String n : nums){
                int num = Integer.parseInt(n);

                if(!set.contains(num)){
                    //set에 넣어 중복 제거
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }
}