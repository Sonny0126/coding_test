class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //yellow 가운데 부분, brown 그 주위를 감싸는 부분
        //yellow =1 brown = 3 + 3 + 1 + 1
        //yellow =2 brown = 4 + 4 + 1 + 1
        //yellow =3 brown = 5 + 5 + 1 + 1
        //yellow =4

        //yello2 = 24, brown = 24라고 하면, 

        //    bbbbbb
        //    byyyyb
        //    byyyyb
        //    byyyyb  
        //    byyyyb
        //    byyyyb
        //    byyyyb
        //    bbbbbb 
        // => (4 + 2) x 2 + (8-2) x 2 =24
        
        //찾는 구간 제곱으로 나누고 이를 int로 변경해 가능한 적은 반복으로 시행하기 위해서
        for(int h=(int)Math.sqrt(yellow); h>=1; h--){
          if(yellow%h==0){
            int w = yellow/h;

            int width = w+2;
            int height = h+2;

            //brown개수 = 가로x2 + 세로x2 -4(꼭짓점 개수)
            if(brown == 2*width + 2 * height - 4){
              answer[0]=width;
              answer[1]=height;
              break;
            }
          }
        }
        return answer;
    }
}