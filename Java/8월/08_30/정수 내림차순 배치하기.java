import java.util.*;

class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        
        //오름차순 정렬
        Arrays.sort(chars);
        
        // StringBuilder로 뒤집기
        String reversed = new StringBuilder(new String(chars)).reverse().toString();
        
        // String을 long으로 변환 
        return Long.parseLong(reversed);
    }
}