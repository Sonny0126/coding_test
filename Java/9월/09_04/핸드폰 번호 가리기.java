class Solution {
    public String solution(String phone_number) {
        
        String str = phone_number.substring(0, phone_number.length()-4);

        String star = "*".repeat(str.length());

        return phone_number.replace(str, star);
    }
}