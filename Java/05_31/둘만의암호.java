class Solution {
    public String solution(String s, String skip, int index) {
        
        //s 각 알파벳 index 만큼 뒤의 알파벳으로 
        //index 만큼 뒤의 알파벳이 z넘어가면 a로 
        //skip에 있는 알파벳 제외하고 건너뜀

        String answer = "";

        for(int i=0; i<s.length(); i++){
          char arr=s.charAt(i);
          int count=0;

          //index만큼 이동
          while(count<index){
            //다음 문자
            arr++;

            //z 넘어가면 a
            if(arr > 'z') arr='a';

            //skip에 있는지 검사
            boolean isSkip = false;

            for(int j=0; j<skip.length(); j++){
              if(arr==skip.charAt(j)){
                isSkip=true;
                break;
              }
            }
            
            //skip 문자가 아니면 count 증가
            if(!isSkip) count++;
          }
          answer[i]=arr;
        }

        return answer;
    }
}