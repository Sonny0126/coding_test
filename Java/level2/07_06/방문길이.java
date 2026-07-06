import java.util.*;
class Solution {

    public int solution(String dirs) {

      //dirs는 UDRl, 이렇게 문자열로 주어짐
        //U 위쪽
        //D 아래쪽
        //R 오른쪽
        //L 왼쪽

        //처음 걸어본 길이 구하기
        //지나온길은 visited로 저장하면서
        //안 지나온 길은 count++
        int x=0, y=0;
        //지나간 길 저장하는 set(같은길 두번 안세려고)
        Set<String> set = new HashSet<>();

        for(char c : dirs.toCharArray()){
          int nx =x;
          int ny = y;

          //UDRL 문자열 처리
          if( c== 'U') nx++;
          else if (c=='D') nx--;
          else if (c=='R') ny++;
          else if (c=='L') ny--;

          //범위 밖이면 무시
          if(nx < -5 || nx >5 || ny <-5 || ny >5) continue;

          String path;

          //(x,y), (nx, ny)중에서 항상 "작은 좌표" -> "큰 좌표" 순서 정렬하기 위해서
          if(x<nx || (x==nx && y < ny) ) 
            path = x + "," + y + "," + nx + "," + ny;
          else
            path = nx + "," + ny + "," + x + "," + y;

          //순방향과 역방향을 둘다 저장
          set.add(path);

          //실제 이동
          x=nx;
          y=ny;
        }

        //양바얗ㅇ 저장했으니
        return set.size();
    }
}