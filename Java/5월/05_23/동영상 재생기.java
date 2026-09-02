

class Solution {

    public static int timeToMinute(String pos){

      String[] parts = pos.split(":");

      int hour = Integer.parseInt(parts[0]);
      int minute = Integer.parseInt(parts[1]);
      return hour * 60 + minute;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {   

        int curTime = timeToMinute(pos);
        int videoTime = timeToMinute(video_len);
        int op_startTime = timeToMinute(op_start);
        int op_endTime = timeToMinute(op_end);

        //command에 있는값 확인
        for(String str : commands) {
          //10초 전으로 이동 -> prev (10초 미만인 경우 0)
          if(str.equals("prev")){

            //오프닝 시간인지 확인
            if(op_startTime <=curTime && curTime <= op_endTime){
              curTime=op_endTime;
            }

            //prev -10
            curTime-=10;

            //만약 curTime이 10초 미만인 경우
            if(curTime<10) curTime=0;

            //다시 오프닝 시간인지 확인 
            else if(op_startTime <=curTime && curTime <= op_endTime){
              curTime=op_endTime;
            }
        
          }

          if(str.equals("next")){

            //오프닝 시간인지 확인
            if(op_startTime <=curTime && curTime <= op_endTime){
              curTime=op_endTime;
            }

            //next + 10
            curTime+=10;

            //만약 endTime이 10초 남은 경우
            if(curTime + 10 > videoTime) curTime = videoTime;

            //오프닝 시간 사이라면 
            else if(op_startTime <=curTime && curTime <= op_endTime){
              curTime = op_endTime;
            }

          }

        }

        int ansHour=curTime/60;
        int ansMin=curTime%60;
        String answer = String.format("%02d:%02d", ansHour, ansMin);

        return answer;
    }
}

