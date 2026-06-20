import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        //오름차순 정렬
        Arrays.sort(d);

        int count=0;
        
        while( count < d.length && budget >=d[count]){
          budget-=d[count++];
        }

        return count;
    }
}