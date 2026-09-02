import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        //원형 처리
        int [] arr = new int [elements.length * 2];
        for(int i=0; i<elements.length; i++){
          arr[i]=elements[i];
          arr[i+ elements.length] = elements[i];
        }

        // 길이
        for(int len=1; len<=elements.length; len++){
            // 시작 위치
            for(int start=0; start<elements.length; start++){

                int sum=0;

                for(int k=start; k<start+len; k++){
                    sum += arr[k];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}