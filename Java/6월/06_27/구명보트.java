import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        //최대 2명 탑승 가능
        //무게제한도 존재 
        //최대한 적게 사용하여 사람 태우기
        Arrays.sort(people);

        int left=0;
        int right = people.length-1;
        int answer=0;

        //투 포인터 방식(Greedy)
        // 50    50     70    80
        //left               right

        //가장 무거운 사람 먼저 태우기
        //가장 가벼운 사람과 태울수 있는지 확인
        while(left <= right){
          //마지막까지 다 태워서 만나면 값 증가시키고 종료
          if(left == right){
            answer++;
            break;
          }
          if(people[left]+people[right] <= limit){
            left++;
          }

          right--;
          answer++;
        }

        return answer;
    }
}