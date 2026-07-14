import java.util.*;

class Solution {

    class File {
        String head;
        int number;
        String original;

        File(String head, int number, String original) {
            this.head = head;
            this.number = number;
            this.original = original;
        }
    }

    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(String file : files){
            int idx = 0;
            // HEAD 찾기
            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                idx++;
            }
            String head = file.substring(0, idx);
            // NUMBER 찾기
            int start = idx;
            //NUMBER 최대 5글자
            while(idx < file.length() && Character.isDigit(file.charAt(idx)) && idx - start < 5){
                idx++;
            }

            int number = Integer.parseInt(file.substring(start, idx));
            list.add(new File(head, number, file));
        }

        
        
        Collections.sort(list, (a, b) -> {
            // 파일명은 우선 HEAD 기준으로 사전 순으로 정렬
            int result = a.head.compareToIgnoreCase(b.head);
            if(result != 0){
                return result;
            }
            // HEAD가 같으면 NUMBER의 숫자 순으로 정렬
            return a.number - b.number;
        });

        String[] answer = new String[files.length];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).original;
        }

        return answer;
    }
}