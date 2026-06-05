class Solution {
    public int solution(int[] ingredient) {

      //아래부터 빵 - 야채 - 고기 -빵
      //재료 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]
      //1->빵, 2->야채, 3->고기
      //그 순서가 배열에 몇개 있는지 찾기
      //stack을 이용하기
        int[] stack = new int[ingredient.length];
        int top = 0;      // 현재 스택 크기
        int answer = 0;

        for (int x : ingredient) {
            stack[top++] = x;

            if (top >= 4 &&
                stack[top - 4] == 1 &&
                stack[top - 3] == 2 &&
                stack[top - 2] == 3 &&
                stack[top - 1] == 1) {

                top -= 4;   // 햄버거 제거
                answer++;
            }
        }

        return answer;
    }
}