import java.util.*;

class Solution {

    public void filter (List list, String str){
      for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);

            if (c1 >= 'A' && c1 <= 'Z' &&
                c2 >= 'A' && c2 <= 'Z') {
                list.add(str.substring(i, i + 2));
            }
        }
    }

    public int solution(String str1, String str2) {
        //자카드 유사도 =  두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈값
        // 두글자씩 끊어서 다중 집합의 원소로 만든다, 영문자만 유효, 기타는 버림

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        filter(str1List, str1);
        filter(str2List, str2);

        // 정렬
        Collections.sort(str1List);
        Collections.sort(str2List);

        int i = 0;
        int j = 0;

        //교집합
        int intersection = 0;
        //합집합
        int union = 0;

        // 투 포인터 방법 사용
        while (i < str1List.size() && j < str2List.size()) {
            //같은 문자열인지 비교
            int cmp = str1List.get(i).compareTo(str2List.get(j));
            
            if (cmp == 0) {
                // 같으면 둘 다 이동
                intersection++;
                union++;
                i++;
                j++;
            } 
            else if (cmp < 0) {
                // str1이 더 작으면 str2에 뒤에 나올 수 없으므로 ++
                union++;
                i++;
            } 
            else {
                // str2가 더 작으면 str1에 뒤에 나올 수 없으므로 ++
                union++;
                j++;
            }
        }

        // 남은 원소는 모두 합집합에 추가하기
        while (i < str1List.size()) {
            union++;
            i++;
        }

        while (j < str2List.size()) {
            union++;
            j++;
        }

        // 둘 다 공집합인 경우
        if (union == 0) {
            return 65536;
        }

        return intersection * 65536 / union;
    }
}