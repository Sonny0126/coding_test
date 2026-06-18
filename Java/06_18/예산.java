import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        //오름차순 정렬
        Arrays.sort(d);

        int count=0;
        while(budget>=0){
          budget-=d[count++];
        }

        return count;
    }
}