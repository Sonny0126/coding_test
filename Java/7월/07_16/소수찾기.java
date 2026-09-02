import java.util.*;

class Solution {

    boolean[] visited;
    //중복을 제거하기 위해 Set을 이용
    Set<Integer> numbers = new HashSet<>();

    boolean isPrime(int n){

        if(n < 2) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }

        return true;
    }

    void dfs(int[] arr, int depth, String str){
        //만들어진 숫자가 있으면 저장
        if(!str.equals("")){
            //문자열 정수로 변환해서 numbers에 추가
            numbers.add(Integer.parseInt(str));
        }

        for(int i=0; i<arr.length; i++){
            //방문 안한경우
            if(!visited[i]){
                visited[i] = true;
                //숫자 이어 붙이기
                dfs(arr, depth+1, str + arr[i]);
                visited[i] = false;
            }
        }
    }

    public int solution(String input) {
        //흩어진 종이 조각을 붙여 소수를 몇 개 만들수 있는지
        //numbers는 길이 1 이상 7이하인 문자열

        int[] arr = new int[input.length()];
        //문자열 숫자를 int 배열로 변환
        for(int i=0; i<input.length(); i++){
            arr[i] = input.charAt(i) - '0';
        }

        visited = new boolean[input.length()];

        dfs(arr, 0, "");

        int count = 0;

        //소수 판별
        for(int num : numbers){
            if(isPrime(num)){
                count++;
            }
        }

        return count;
    }
}