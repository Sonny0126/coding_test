class Solution {

  int answer=0;

  //idx값 숫자를 처리하면서 현재 sum을 가진 상태
  public void dfs(int[] numbers, int target, int idx, int sum){
    if(idx == numbers.length){
      if(sum==target)
        answer++;
      return;
    }
      //합
      dfs(numbers, target, idx+1, sum+numbers[idx]);
      //차
      dfs(numbers, target, idx+1, sum-numbers[idx]);
  } 

    public int solution(int[] numbers, int target) {
        // 순서 변경 x 적절히 더하거나 빼서 타겟 값 구하기
        //타겟 값 구할수 있는 방법의 수 return
        //dfs 탐색으로 풀이
        dfs(numbers, target, 0, 0);

        return answer;
    }
}