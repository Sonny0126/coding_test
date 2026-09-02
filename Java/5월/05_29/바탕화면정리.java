class Solution {
    public int[] solution(String[] wallpaper) {
        //드래그 시작점(lux, luy), 끝점(rdx, rdy)
        //모든 값 포함
        
        //1. wallPaper를 받고 map형태로
        String [][]map = new String[wallpaper.length][wallpaper[0].length()];

        // 2차원 배열로 형성
        for(int i=0; i<wallpaper.length;i ++){
          for(int j=0; j<wallpaper[i].length(); j++){
            map[i][j]=String.valueOf(wallpaper[i].charAt(j));
          }
        }
        //map 배열상태
        // [.#...]
        // [..#..]
        // [...#.]
        int minX=51, minY=51;
        int maxX=0, maxY=0;

        for(int i=0; i<wallpaper.length;i ++){
          for(int j=0; j<wallpaper[i].length(); j++){
            if(map[i][j].equals("#")) {
              //제일 작은 좌표값
              minX=Math.min(minX, j);
              minY=Math.min(minY, i);

              //제일 큰 좌표값
              maxX=Math.max(maxX, j);
              maxY=Math.max(maxY, i);
            }
          }
        }
        int [] answer = {minY, minX, maxY+1, maxX+1};

        return answer;
    }
}