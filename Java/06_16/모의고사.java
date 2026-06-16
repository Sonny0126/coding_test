import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        //1번 수포자1 2 3 4 5 (순서대로)
        //2번 수포자 2, 1 , 2, 3, 4, 2, 5 .. 2번 숫자가 반복
        //3번 3, 3, 1 ,1 ,2 ,2 , 4 ,4 , 5 ,5 , 3, 3, 1, 1, ... 각 번호 2회씩 2번 (3번째 숫자는 맨 앞으로 빼서)

        //가장 많이 문제를 맞힌 사람을 배열에 담아 return
        //여러명이면 오름차순 정렬
        int [] supo1 = {1,2,3,4,5};
        int [] supo2 = {2,1,2,3,2,4,2,5};
        int [] supo3 = {3,3,1,1,2,2,4,4,5,5};

        int [] score = new int [3];

        for(int i=0; i<answers.length; i++){
          if(answers[i] ==supo1[i%supo1.length]) score[0]++;
          if(answers[i] ==supo2[i%supo2.length]) score[1]++;
          if(answers[i] ==supo3[i%supo3.length]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<3; i++){
          if(score[i]==max) result.add(i+1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}