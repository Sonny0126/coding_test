class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int inc = x;
        for(int i=0; i<n; i++){
          answer[i]=x;
          x+=inc;
        }

        return answer;
    }
}