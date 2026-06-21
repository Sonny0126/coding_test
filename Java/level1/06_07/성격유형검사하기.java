class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        //1번 R, T
        //2번 C, F
        //3번 J, M
        //4번 A, N

        // 1. survye[i] 첫 글자 = 비동의, 두 글자 동의
        // 2. choices[i] 1~3 첫글자 3,2,1점
        //     4 -> 0점
        //     5~7 -> 두 글자에게 1,2,3점
        // 3. 모든 점수 더한 후, 각각 점수가 높은 쪽 이어붙여서 답 출력

        int R=0, T=0, C=0, F=0, J=0, M=0, A=0, N=0;

        for(int i=0; i<survey.length; i++){

            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            // 매우 비동의
            if(choices[i] == 1){
                if(first == 'R') R += 3;
                if(first == 'T') T += 3;
                if(first == 'C') C += 3;
                if(first == 'F') F += 3;
                if(first == 'J') J += 3;
                if(first == 'M') M += 3;
                if(first == 'A') A += 3;
                if(first == 'N') N += 3;
            }

            // 비동의
            if(choices[i] == 2){
                if(first == 'R') R += 2;
                if(first == 'T') T += 2;
                if(first == 'C') C += 2;
                if(first == 'F') F += 2;
                if(first == 'J') J += 2;
                if(first == 'M') M += 2;
                if(first == 'A') A += 2;
                if(first == 'N') N += 2;
            }

            // 약간 비동의
            if(choices[i] == 3){
                if(first == 'R') R += 1;
                if(first == 'T') T += 1;
                if(first == 'C') C += 1;
                if(first == 'F') F += 1;
                if(first == 'J') J += 1;
                if(first == 'M') M += 1;
                if(first == 'A') A += 1;
                if(first == 'N') N += 1;
            }

            // 약간 동의
            if(choices[i] == 5){
                if(second == 'R') R += 1;
                if(second == 'T') T += 1;
                if(second == 'C') C += 1;
                if(second == 'F') F += 1;
                if(second == 'J') J += 1;
                if(second == 'M') M += 1;
                if(second == 'A') A += 1;
                if(second == 'N') N += 1;
            }

            // 동의
            if(choices[i] == 6){
                if(second == 'R') R += 2;
                if(second == 'T') T += 2;
                if(second == 'C') C += 2;
                if(second == 'F') F += 2;
                if(second == 'J') J += 2;
                if(second == 'M') M += 2;
                if(second == 'A') A += 2;
                if(second == 'N') N += 2;
            }

            // 매우 동의
            if(choices[i] == 7){
                if(second == 'R') R += 3;
                if(second == 'T') T += 3;
                if(second == 'C') C += 3;
                if(second == 'F') F += 3;
                if(second == 'J') J += 3;
                if(second == 'M') M += 3;
                if(second == 'A') A += 3;
                if(second == 'N') N += 3;
            }
        }

        if(R >= T) answer += "R";
        else answer += "T";

        if(C >= F) answer += "C";
        else answer += "F";

        if(J >= M) answer += "J";
        else answer += "M";

        if(A >= N) answer += "A";
        else answer += "N";

        return answer;
    }
}