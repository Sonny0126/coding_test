class Solution {

  int [][]map;
  int zeroCnt=0;
  int oneCnt=0;

  void dfs(int x,int y,int size){
    //모두 같은지 검사(왼쪽 상단 값 기준)
    int temp=map[x][y];

    boolean same = true;
    for(int i=x; i<x+size; i++){
      for(int j=y; j<y+size; j++){
        if(map[i][j]!=temp){
          same=false;
          break;
        }
      }
      if(!same) 
        break;
    }

    //모두 같은 경우
    if(same){
      if(temp==0)
        zeroCnt++;
      else
        oneCnt++;

      return;
    }

    //모두 같지 않으면 4등분
    int half = size/2;

    // 왼쪽 위
    dfs(x,y,half);
    // 오른쪽 위
    dfs(x, y + half, half);
    // 왼쪽 아래
    dfs(x + half, y, half);
    // 오른쪽 아래
    dfs(x + half, y + half, half);
  }

  public int[] solution(int[][] arr) {
        //1. 압축하고자 하는 영역 S
        //2. S 내부에 모든 수가 같은값이면 S 하나로 압축
        //3. 4개의 정사각형 영역으로 쪼갠뒤, 각 정사각형의 영역에 대해 압축

        //ex 
        // 1 1 | 0 0           1 1 | 
        // 1 0 | 0 0           1 0 | 0
        // ---------  ->       1 0 | 0 1
        // 1 0 | 0 1           1 1 | 1 1
        // 1 1 | 1 1
        //  0: 4개, 1: 9개

        map = arr;
        dfs(0,0, arr.length);
        return new int[]{zeroCnt,oneCnt};
    }
}