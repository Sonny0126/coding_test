import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //앞번호, 뒷번호에게 체육복 전달
        //4번은 3번, or 5번만 가능
        //전체 학생수 n, 도난번호 담긴 번호 배열 lost,
        //여벌 체육복 가져온 학생 reserve
        //체육수업들을 수 있는 최대학생수(체육복있으면 수업 o)

        int [] students = new int [n+2];
        //모두 1개씩 가지고 있음
        Arrays.fill(students, 1);

        //2. Lost 처리 (체육복 -1)
        for(int i: lost){
          students[i]--;
        }

        //3. reserve 처리 (체육복 +1)
        for(int i : reserve){
          students[i]++;
        }

        //4. 체육복 없는 애들 빌려주기
        for(int i=1; i<=n ;i++){
          //옷이 없음
          if(students[i]==0){
            //앞친구에게서 옷 빌리기
            if(i >=2 && students[i-1]==2){
              students[i]++;
              students[i-1]--;
            }

            //뒷친구에게서 옷 빌리기
            else if(i <= n-1 && students[i+1]==2){
              students[i]++;
              students[i+1]--;
            }
          }
        }

        //옷이 1개 이상인 친구들 개수 count
        int count=0;
        for(int i=1; i<=n; i++){
          if(students[i]>=1) count++;
        }

        return count;
    }
}