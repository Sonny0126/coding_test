import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        //입력된 수가 짝수라면 2로 나누기
        //입력된 수가 홀수라명 3을 곱하고 1을 더한다
        //결과로 나온수가 1보다 크다면 1번 작업을 반복한다

        List<Integer> list = new ArrayList<>();
        list.add(k);

        while(k>1){
          if(k%2==0) {
            k/=2;
          }
          else {
            k=k*3+1;
          }
          list.add(k);
        }

        //넓이 생성
        double [] extent = new double[list.size()];

        //구간 넓이 누적해서 저장하기(높이는 항상 1이므로)
        for(int i=1; i<list.size(); i++){
          double area = (list.get(i-1) + list.get(i)) /2.0;
          extent[i] = extent[i-1] + area;
        }

        // 3. range 처리
        double [] answer = new double[ranges.length];

        int last = list.size()-1;

        for(int i=0; i<ranges.length; i++){
          int start = ranges[i][0];
          int end = last + ranges[i][1];

          if(start>end){
            answer[i] = -1.0;
          }
          else{
            answer[i]=extent[end]-extent[start];
          }
        }

        return answer;
    }
}