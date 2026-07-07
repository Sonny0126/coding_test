class Solution {
  String [] moem = {"A", "E", "I", "O", "U"};
  
  int count=0;
  int answer=0;
  String target;
  
    public int solution(String word) {
        //모음 A,E,I,O,U
        //사전 첫번째 단어, A, AA, AAA, ...  UUUUU
        //몇번째 단어인지 출력
        
        //A~ AUUUU, 다음에 B
        //길이 1->5에서 5->4->3->2->1 이런 구조
        // DFS알고리즘 사용
        target = word;
        dfs("");
        
        return answer;
    }

  public void dfs(String str){
    if(str.length() > 5) return;

    if(str.length() != 0){ 
      count++;

      if(str.equals(target)){
        answer= count;
        return ;
      }
    }

    for(int i=0; i<5; i++){
      dfs(str + moem[i]);
    }
  }
}