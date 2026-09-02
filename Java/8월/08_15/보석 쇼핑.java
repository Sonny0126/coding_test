import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};

        //쇼핑 싹쓸이
        //모든 종료의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간 찾아서 구매
        Set<String> gemSet = new HashSet<>();

        for(String gem: gems){
          gemSet.add(gem);
        }

        int kinds = gemSet.size();

        //현재구간 [left, right]에 있는 보석 개수
        Map<String, Integer> map = new HashMap<>();

        int left =0;
        int answerStart = 0;
        int answerEnd = gems.length -1;

        int minLength = Integer.MAX_VALUE;

        for(int right =0; right < gems.length; right++){
          //오른쪽 보석 추가
          String gem = gems[right];
          map.put(gem, map.getOrDefault(gem, 0) + 1);

          //현재 구간에 모든 종류의 보석이 있는 상태
          while(map.size() == kinds){
            //현재 구간의 길이
            int length = right-left +1;

            //더 짧거나, 길이가 같다면 시작점이 더 작은 경우 정답 갱신
            if(length < minLength || length == minLength && left < answerStart){
              minLength = length;
              answerStart = left;
              answerEnd = right;
            }

            //왼쪽 보석 제거
            String leftGem = gems[left];
            map.put(leftGem, map.get(leftGem)-1);

            //해당 보석이 더이상 구간에 없다면 제거
            if(map.get(leftGem)==0){
              map.remove(leftGem);
            }
            left++;
          }
        }

        return new int[] {answerStart+1, answerEnd+1};
    }
}