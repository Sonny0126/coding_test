class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        //1. 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고,
        //   영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
        //2. 영희가 가진 카드들이 적힌 모든 숫자를 나눌 수 있고,
        //   철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의정수 a

        // 2조건 중 하나 만족하는 가장큰 양의 정수 a

        int answer = 0;

        // 철수가 가진 카드들의 최대공약수 구하기
        int A = arrayA[0];

        for(int i = 1; i < arrayA.length; i++){
            A = gcd(A, arrayA[i]);
        }
        // 영희가 가진 카드들의 최대공약수 구하기
        int B = arrayB[0];

        for(int i = 1; i < arrayB.length; i++){
            B = gcd(B, arrayB[i]);
        }
        // 조건 1 확인
        if(check(A, arrayB)){
            answer = Math.max(answer, A);
        }
        // 조건 2 확인
        if(check(B, arrayA)){
            answer = Math.max(answer, B);
        }

        return answer;
    }

    // 최대공약수 구하는 함수
    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 해당 숫자가 상대방 카드들의 모든 숫자를 나눌 수 없는지 확인
    public boolean check(int num, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % num == 0){
                return false;
            }
        }

        return true;
    }
}