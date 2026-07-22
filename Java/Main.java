import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }

        //DP 사용
        int [] dp = new int[N];

        //길이가 1인 경우 제외
        if(N==1) System.out.println(arr[0]);
        //길이가 2인 경우 제외
        if(N==1) System.out.println(arr[0]+arr[1]);

        //처음값, 둘째값
        dp[0]=arr[0];
        dp[1]=arr[0]+arr[1];
        //셋째 값은 3일연속 공부안되니 그 안에서 최대값 찾기
        dp[2]=Math.max(arr[0]+arr[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));

        for(int i=3; i < N; i++){
            //3가지 선택지가 있다
            //1. dp[i-1]오늘 공부 x
            //2. dp[i-2]+arr[i] 오늘 공부 O
            //3. dp[i-3]+arr[i-1] +arr[i] 어제, 오늘 공부 O
            //이 중에서 최대값을 dp[i]에 저장 (반복문 순회하면서 dp값 갱신하기
            dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3] + arr[i-1]+arr[i]));
        }

        int answer= dp[N-1];
        System.out.println(answer);
    }
}
