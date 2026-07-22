import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    public int solution(int []A, int []B)
    {
        //각 배열의 값을 꺼내 두 수를 곱하며 곱한값 누적해서 더한다
        //누적 값이 최소가 되도록
        // 각 배열에서 큰 값과 작은 값을 곱한다
        
        int sum=0;

        //오름차순 배열
        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;

        for(int i=0; i<len; i++){
          sum+=A[i] * B[len- 1 - i];
        }
      
        return sum;
    }
}