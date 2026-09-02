class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime =-1;
        m = replaceNote(m);

        //악보음 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개
        //조건일치 음악 없으면 None 반환
        //조건 일치하는 음악이 여러개인 경우, 재생된 시간이 제일 긴 음악 제목을 반환, 재생시간도 같으면 먼저 입력된 음악 제목 반환
        for(String str : musicinfos){
          String [] temp = str.split(",");
          String startTime = temp[0];
          String endTime = temp[1];
          String word = temp[2];
          String code = replaceNote(temp[3]);
            
          //3. 재생 시간 계산
          int playTime = getPlayTime(startTime, endTime);

          //4. 재생 시간 동안 멜로디 생성
          StringBuilder sb = new StringBuilder();
          int codeLen = code.length();
          for(int i=0; i<playTime; i++){
            sb.append(code.charAt(i % codeLen));
          }

          //5. 조건 확인
          if(sb.toString().contains(m)){
            //재생 시간 더 긴 음악으로 갱신(시간 동일하면 먼저 입력된것)
            if(playTime> maxTime){
              maxTime = playTime;
              answer = word;
            }
          }
        }
        return answer;
    }

    public String replaceNote(String s){
      return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");      
    }

    public int getPlayTime(String start, String end){
      String [] s = start.split(":");
      String[] e = end.split(":");

      int startMin = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
      int endMin = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
      
      return endMin - startMin;
    }

}