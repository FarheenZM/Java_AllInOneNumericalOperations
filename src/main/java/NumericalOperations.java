public class NumericalOperations {

    public static int reverse(int number){
        int reverse = 0;
        while(number > 0){
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }

    public static boolean palindrome(int number){
        int temp = number;
        int reverse = 0;
        while(number > 0){
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        if(temp == reverse){
            return true;
        }else{
            return false;
        }
    }
}
