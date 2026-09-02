import java.util.*;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        List<int[]> list = new ArrayList<>();
        //picks는 [dia, iron, stone]과 같은 구조로(곡괭이 수)
        //다이아 피로도 -5, 철과돌은 피로도 -1
        //광물 5개 캔 후에 사용 x
        //작업끝내기까지 최소한의 피로도 출력
        //좋은 곡괭이는 다이아가 많은 구간에서만 가치가 크다

        //곡괭이로 캘 수 있는 최대 광물 개수
        int max = (picks[0] + picks[1] + picks[2]) * 5;

        //광물과, 곡괭이중 더 적은 것을기준으로
        for (int i = 0; i < Math.min(max, minerals.length); i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < Math.min(max, minerals.length); j++) {
                if (minerals[j].equals("diamond")) {
                    dia++; //다이아 곡괭이 
                    iron += 5; // 철 곡괭이
                    stone += 25; // 돌 곡괭이
                } else if (minerals[j].equals("iron")) {
                    dia++;
                    iron++;
                    stone += 5;
                } else {
                    dia++;
                    iron++;
                    stone++;
                }
            }
            //피로도 리스트에 더하기
            list.add(new int[]{stone, iron, dia});
        }

        //피로도 큰 순서대로 정렬
        list.sort((a, b) -> b[0] - a[0]);
        int answer = 0;

        for (int[] g : list) {
          //다이아 곡괭이 사용
            if (picks[0] > 0) {
                answer += g[2];
                picks[0]--;
            } 
            //철 곡괭이 사용
            else if (picks[1] > 0) {
                answer += g[1];
                picks[1]--;
            } 
            // 돌 곡괭이 사용
            else if (picks[2] > 0) {
                answer += g[0];
                picks[2]--;
            }
        }

        return answer;
    }
}