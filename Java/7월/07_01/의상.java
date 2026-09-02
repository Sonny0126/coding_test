     

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        //매일 다른 옷 입는 것 선호
        //얼굴, 상의, 하의, 겉옷
        //기존 옷과는 달라져야 하며, 기존 옷에 추가는 가능하다
        //[옷 종류, 옷 위치]  

        // 종류별 개수 세기
        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];

            //이미 포함되어있으면 개수 +1
            if(map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            }
            //포함되어있지 않다면 추가 
            else {
                map.put(type, 1);
            }
        }

        int answer = 1;

        // (개수 + 1)씩 곱하기
        for(int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        // 아무것도 안 입는 경우 제외
        return answer - 1;
    }
}