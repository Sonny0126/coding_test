class Solution {
    public String solution(String s) {

        //첫 문자 모두 대문자, 그 외의 알파벳은 소문자
        // 단, 첫문자 알파벳 아닐 떄는 이어지는 알파벳은소문자로
        // 문자마다 받고, 문자 첫번째는 대문자로
        char [] arr = s.toLowerCase().toCharArray();

        //맨 처음 값 대문자
        if(arr.length >0){
          arr[0]= Character.toUpperCase(arr[0]);
        }
        // 공백 다음 대문자
        for(int i=1; i< s.length()-1; i++){
          if(arr[i-1]==' '){
            arr[i] = Character.toUpperCase(arr[i]);
          }
        }

        return new String(arr);
    }
}