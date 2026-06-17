class Solution {
    public int solution(String dartResult) {

        //다트게임 기회 3번
        //기회마다 점수 0-10
        //Single^1, Double^2, Triple^3
        // 스타상(*), 당첨시 해당 점수와 이전 점수 x2
        // 아차상(#), 당첨시 해당 점수 마이너스(-) 음수
        // 스타상(*)은 다른 스타상과 중첩 가능 2 x 2 = 4
        // 스타사(*)은 아차상(#)효과도 중첩 가능 이때 점수 x (-2)
        
        int [] score = new int[3];
        int idx = -1;
        for(int i=0; i<dartResult.length(); i++){
          char c = dartResult.charAt(i);

          //숫자
          if(Character.isDigit(c)){
            idx++;
            //10 처리
            if(c=='1' && i+1 < dartResult.length() && dartResult.charAt(i+1)=='0') {
              score[idx]=10;
              i++;
            }
            else {
              score[idx]=c-'0';
            }
          }

          //Single
          else if(c=='S'){
            score[idx]=(int)Math.pow(score[idx], 1);
          }
          //Double
          else if(c=='D'){
            score[idx]=(int)Math.pow(score[idx], 2);
          }
          //Triple
          else if(c=='T'){
            score[idx]=(int)Math.pow(score[idx], 3);
          }

          //스타상(*)
          else if (c=='*'){
            score[idx] *=2;
            //맨처음이 아니라면
            if(idx>0){
              score[idx-1]*=2;
            }
          }

          //아차상(#)
          else if(c=='#'){
            score[idx]*=-1;
          }

        }

        int answer= score[0]+score[1]+score[2];

        return answer;
    }
}