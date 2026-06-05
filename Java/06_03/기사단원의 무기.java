class Solution {

    public int decimalCount(int num){
      int count=0;
      for(int i=1; i<=num; i++){
        if(num%i==0) count++; 
      }
      return count;
    }

    public int solution(int number, int limit, int power) {
    
        //번호의 약수 개수에 해당하는 공격력 무기 구매
        //ex 15번은 약수 1,3,5,15 ->4개 이므로 공격력 4인 무기
        //if 공격력 제한수치 3 제한수치 초과한 기사가 사용할 무기의 공격력 2라면, 15번은 공격력 2인 무기 사용
        //무기 공격력 1당 1kg 철 필요
        int iron=0;

        for(int i=1; i<=number; i++){
          int attackPower = decimalCount(i);
          if(attackPower > limit){
            attackPower = power;
          }
          iron +=attackPower;
        }
        
        // 1부터 n까지 번호의 기사에게 필요한 모든 철 개수 
        return iron;
    }
}