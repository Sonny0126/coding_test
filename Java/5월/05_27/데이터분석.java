import java.util.*;

class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        // 각 항목의 위치
        Map<String, Integer> map = new HashMap<>();

        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);

        // 조건 맞는 데이터 저장
        List<int[]> list = new ArrayList<>();

        for(int[] arr : data) {
            if(arr[extIdx] < val_ext) {
                list.add(arr);
            }
        }

        // 정렬
        list.sort((a, b) -> a[sortIdx] - b[sortIdx]);

        // List -> 배열 변환
        return list.toArray(new int[list.size()][]);
    }
}