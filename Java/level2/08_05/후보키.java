import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        int len = relation[0].length;
        List<Integer> huboKey = new ArrayList<>();

        // 모든 컬럼 조합 검사
        for (int bit = 1; bit < (1 << len); bit++) {
            // 최소성 검사
            boolean smallest = true;

            for (int key : huboKey) {
                //후보키가 존재한다면
                if ((bit & key) == key) {
                    smallest = false;
                    break;
                }
            }

            //최소성 만족 못하면 패스
            if (!smallest) continue;

            // 유일성 검사
            Set<String> set = new HashSet<>();

            for (String[] row : relation) {
              //현재 행에서 선택한 칼럼들의 값 하나로 합칠 문자열
              String value = "";
                for (int j = 0; j < len; j++) {
                    //bit 에서 j번쨰 컬럼이 선택됬는지 확인
                    //ex) bit = 011이면 0번,1번 선택
                    if ((bit & (1 << j)) != 0) {
                        //선택한 칼럼값 문자열에 추가
                        //"/"을 넣어서 컬럼 값 구분
                        value += row[j] + "/";
                    }
                }
                //만들어진 것 set에 저장
                //같은 값이 있으면 중복된 행이 존재함을 의미
                set.add(value);
            }

            // 서로 다른 값의 개수 == 전체 행의 개수
            // -> 모든 행이 서로 다른 값을 가진다는 의미
            if (set.size() == relation.length) {
              //현재 조합을 후보키 목록에 저장
                huboKey.add(bit);
                //개수 +1
                answer++;
            }
        }

        return answer;
    }
}