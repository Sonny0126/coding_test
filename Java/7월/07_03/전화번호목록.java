import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        //phone book에서 어떤 번호가 다른 번호의 접두어인 경우 false
        //아닌 경우 true return 
        ArrayList<String> book = new ArrayList<>();
        for(int i=0; i<phone_book.length; i++){
          book.add(phone_book[i]);
        }

        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length - 1; i++){
            if(phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}