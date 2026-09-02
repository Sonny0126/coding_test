import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        //LZW 압축과정
        /*
        1. 길이가 1인 모든 단어 포함하도록 사전 초기화
        2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 찾기
        3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거
        4. 입력에서 처리되지 않은 다음 글자 남아있으면(c), w+c에 해당하는 단어 사전에 등록
        5. 단계 2로 돌아가기
        */

        // 1. 사전 초기화
        // A~Z를 1~26번으로 등록
        HashMap<String, Integer> dict = new HashMap<>();

        int index = 1;

        for(char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), index++);
        }


        int i = 0; // 현재 입력에서 확인할 위치


        while(i < msg.length()) {

            StringBuilder sb = new StringBuilder();

            String w = ""; // 사전에 존재하는 가장 긴 문자열
            int j = i;


            // 2. 현재 위치에서 가장 긴 문자열(w) 찾기
            while(j < msg.length()) {
                // 현재 문자열에 문자 하나 추가
                sb.append(msg.charAt(j));
                // 사전에 존재하는 문자열이면 계속 확장
                if(dict.containsKey(sb.toString())) {
                    // 현재까지 만든 문자열을 저장
                    w = sb.toString();
                    j++;
                } 
                // 사전에 없는 문자열이면 종료
                else {
                    break;
                }
            }


            // 3. 가장 긴 문자열 w의 사전 번호 출력
            answer.add(dict.get(w));

            // 4. w + 다음 문자(c)를 사전에 추가
            // 예) w = "KA", 다음 문자 = "K"
            // 새로운 단어 "KAK" 등록
            if(j < msg.length()) {
                String newWord = w + msg.charAt(j);
                dict.put(newWord, index++);
            }


            // 5. 이미 처리한 w 길이만큼 이동
            i += w.length();
        }


        // List<Integer> -> int[] 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}