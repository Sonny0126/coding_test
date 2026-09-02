import java.util.*;

class Solution {

    class Car{
      String time;
      String status;

      Car(String time, String status){
        this.time=time;
        this.status=status;
      }
    }

    public int[] solution(int[] fees, String[] records) {
        //fees
        // 기본시간, 기본 요금, 단위시간, 단위 요금
        //records
        //출입차시간, 차량번호, 차량(In,Out)출입

        //차량번호별로, 출입차시간, 차량 In, Out기록
        HashMap<String, Integer> inTime = new HashMap<>();
        //treeMap은 차량번호 자동정렬
        Map<String, Integer> totalTime = new TreeMap<>();
        
        for(String record: records){
          String [] temp = record.split(" ");
          int time = toMinutes(temp[0]);
          String carNumber = temp[1];
          String status = temp[2];

          //입차한 경우
          if(status.equals("IN")){
            inTime.put(carNumber, time);
          }
          //출차한 경우
          else{
            //입차시간 꺼내서 주차시간 계산 후 누적
            int in_time = inTime.remove(carNumber);
            int parked_time = time - in_time;
            totalTime.put(carNumber, totalTime.getOrDefault(carNumber, 0) + parked_time);
          }
        }

        // 아직 출차하지 않은 차량들은 23:59에 출차한 것으로 처리
        for (String carNumber : inTime.keySet()) {
            int in_time = inTime.get(carNumber);
            int parkedTime = toMinutes("23:59") - in_time;
            totalTime.put(carNumber, totalTime.getOrDefault(carNumber, 0) + parkedTime);
        }

        //차량번호 오름차순 정렬(TreeMap이라 이미 정렬)
        int [] answer = new int[totalTime.size()];
        int idx=0;
        for(int timeSum : totalTime.values()){
          answer[idx++] = calculateFee(fees, timeSum);
        }
        return answer;
    }

       // "HH:MM" -> 분 단위로 변환
    private int toMinutes(String time) {
        String[] hm = time.split(":");
        int hour = Integer.parseInt(hm[0]);
        int minute = Integer.parseInt(hm[1]);
        return hour * 60 + minute;
    }

    // 주차 시간(분)을 받아서 요금 계산
    private int calculateFee(int[] fees, int parkedTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int fee = baseFee;

        if (parkedTime > baseTime) {
            int extraTime = parkedTime - baseTime;
            // 단위 시간으로 나눠서 올림 처리
            int extraUnits = (int) Math.ceil((double) extraTime / unitTime);
            fee += extraUnits * unitFee;
        }

        return fee;
    }
}