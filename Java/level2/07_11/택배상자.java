import java.util.*;

class Solution {
    public int solution(int[] order) {
        //1번~ n번상자까지 번호 증가하는 컨테이너 벨트
        //벨트 순서대로 놓으면 택배 기사님이 배달하는 순서와 택배상자 실려있는 순서 다름
        //택배 기사님이 미리 알려준 순서에 맞게 싥기
        //지금 싥는게 아니면 다른 곳에 보관
        //큐 사용

        Stack<Integer> s = new Stack<>();

        int box=1;

        int count=0;

        for(int want : order){
          
          //원하는 상자 나올때까지 stack에 보관
          while(box <= order.length && box < want){
            s.push(box++);
          }

          //원하는 상자 나오면 트럭에 적재
          if(box==want){
            box++;
          }
          //못꺼내지만, 보조 컨테이너 맨 위에 원하는 상자 있으면 꺼내 적재
          else if (!s.isEmpty() && s.peek() ==want){
            s.pop();
          }
          //두곳 모두 원하는 상자 없으면 적재 불가
          else{
            break;
          }
          //적재 성공
          count++;
        }
        return count;
    }
}