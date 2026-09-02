import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {

        //4가지 종류의 토핑 있음
        //[1 2 1 3 1 4 1 2]
        //[1 2 1 3] [1 4 1 2]
        //맛 각각 3가지 
        //공평하게 자르는 방법의 개수
        int n = topping.length;
        int [] left = new int[n];
        int [] right = new int[n];

        //set에 넣어서 개수 판단
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
          set.add(topping[i]);
          left[i]=set.size();
        }

        //오른쪽 부터 종류 세기
        set.clear();

        for(int i=n-1; i>=0; i--){
          set.add(topping[i]);
          right[i] = set.size();
        }

        int answer =0;

        for(int i=0; i<n-1; i++){
          if(left[i]==right[i+1]){
            answer++;
          }
        }

        return answer;
    }
}