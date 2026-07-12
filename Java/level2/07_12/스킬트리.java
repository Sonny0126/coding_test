class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        //스킬 순서로 배워야 함
        //스킬트리를 돌면서 검사하면서 스킬순서대로인지 판단
        //CBD의 경우 C뒤에 B, B뒤에 D가 만족하도록
        
        for(String tree : skill_trees){
          String str="";

          //스킬 트리 문자 뒤지기
          for(char c: tree.toCharArray()){
            //현재 문자가 스킬에 포함되어있다면 순서를 그대로 저장
            if(skill.contains(String.valueOf(c))){
              str+=c;
            }
          }

          //선행 스킬의 결과과 skill의 앞부분이면 올바른 순서이므로 개수 증가
          if(skill.startsWith(str)) 
            count++;
        }

        return count;
    }
}