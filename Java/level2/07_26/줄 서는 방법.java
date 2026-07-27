import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int [n];
        List<Integer> list = new ArrayList<>();

        //1부터 n까지의 사람 담기
        long factorial = 1;
        for(int i=1; i<=n ;i++){
          list.add(i);
          factorial *=i;
        }

        //1부터로 되있어서 k-- 맞추기 위해
        k--;

        for(int i=0; i<n; i++){
          //현재 자리 제외하고 만들수 있는 경우의 수 (n-1-i)!
          factorial /= (n-i);

          //k를 현재 묶음단위로 묶기
          int index = (int)(k/factorial);
          //구한 인덱스 위치의 사람 배열제 저장
          answer[i] = list.get(index);
          //이미 줄 선사람은 제거 (중복을 방지)
          list.remove(index);
          // 다음 자릿수 계산을 위해, 남은 순번으로 갱신
          k %= factorial;
        }

        return answer;
    }
}