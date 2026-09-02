class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

      //원하는 카드뭉치 카드 순서대로 1장씩
      //한번 사용한 카드는 다시 사용 X
      //카드를 사용하지않고 다음카드 이동 X
      //기존에 주어진 카드뭉치의 단어순서 변경 X
      int idx1=0, idx2=0;

      //cards1, cards2를 둘러보면서 goal 단어 처리
      for(int i=0; i<goal.length; i++){

        //cards1에서 사용 가능한 경우
        if(idx1< cards1.length && cards1[idx1].equals(goal[i])){
          idx1++;
          continue;
        }

        //cards2에서 사용 가능한 경우
        if(idx2< cards2.length && cards2[idx2].equals(goal[i])){
          idx2++;
          continue;
        }

        //둘 다 사용 안되는 경우
        else {
          return "No";
        }
      }
      
      return "Yes";
    }
}