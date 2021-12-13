package PlayingWithNumber;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Enter a number : ");
        number = scanner.nextInt();
        System.out.println("Reverse of the "+number+" is :"+ reverseNumber(number));
        String rev_number = reverse_number(number).replace('[',' ');
        rev_number = rev_number.replace(']',' ');
        rev_number = rev_number.replace(',',' ');
        rev_number = rev_number.replaceAll("\\s","");
        System.out.println("Reverse of the "+number+" using number as string :"+ rev_number);



        scanner.close();
    }

    private static int reverseNumber(int number){
        int remainder;
        int reverse = 0;
        
        while (number != 0) {
            remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number = number / 10;
        }
        return reverse;
    }
    // reverse using number as a string.
    private static String reverse_number(Integer number){
        String str_number = Integer.toString(number);
        char[] char_string ;
        char_string = str_number.toCharArray();
        char[] reverse_str = new char[char_string.length];
        for (int i = char_string.length-1, j= 0;  i >= 0 ; i--,j++){
            reverse_str[j] = char_string[i];
        }
        return Arrays.toString(reverse_str);
    }
}
