class Solution {

    public static boolean check(int n){

        if(n < 2) return false;

        for(int i=2; i*i<=n; i++){
            if(n%i==0)
                return false;
        }

        return true;
    }

    public int solution(int[] nums) {
        int count = 0;
        int len = nums.length;

        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i]+nums[j]+nums[k];

                    if(check(sum))
                        count++;
                }
            }
        }

        return count;
    }
}