import java.util.*;

class Solution {
    public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 고를 수 있는 폰켓몬 수
        int ponketmon = nums.length / 2;

        // 종류의 수가 고를 수 있는 수보다 많으면
        // 고를 수 있는 수만큼 종류를 선택
        if (set.size() > ponketmon) {
            return ponketmon;
        }
        return set.size();
    }
}