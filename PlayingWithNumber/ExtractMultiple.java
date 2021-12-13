package PlayingWithNumber;

import java.util.*;

public class ExtractMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number;
        long multiple;
        boolean play = true;
        String choice ;

        while (play){

            //  <main program (start)>
            System.out.println("Enter a number : ");
            number = scanner.nextLong();
            System.out.println("Enter the factor : ");
            multiple = scanner.nextLong();
            scanner.nextLine();
            List<Long> multipleList = new ArrayList<>();
            String str_number = Long.toString(number); // Converting number to String.
            String[] str_arr = str_number.split(""); // string to String array.
            //System.out.println(str_number.length());
            for (int i = 0 ; i < str_number.length(); i++){
                for (int j = i+1 ; j < str_number.length(); j++){
                    //System.out.println(concat_string(str_arr,i,j));
                    if (Long.parseLong(concat_string(str_arr,i,j)) % multiple == 0 ){
                        //System.out.print(Long.parseLong(concat_string(str_arr,i,j))+" ");
                        multipleList.add(Long.parseLong(concat_string(str_arr,i,j)));
                    }
                }
            }

            // checking for the last digit.
            if (Long.parseLong(concat_string(str_arr,str_number.length()-1,str_number.length()-1)) % multiple == 0 && Long.parseLong(concat_string(str_arr,str_number.length() -1,str_number.length() -1)) != 0){
                multipleList.add(Long.parseLong(concat_string(str_arr,str_number.length()-1,str_number.length()-1)));
            }

            Collections.sort(multipleList);
            System.out.println("\nThe List : ");
            for (Long integer : multipleList) {
                System.out.print(integer+" ");
            }
            System.out.println("\nThe program found "+multipleList.size()+" multiple of "+multiple+" in the number.");
            // <main program (end)>

            System.out.println("\nContinue ? (y or n)");
            choice = scanner.nextLine();
            if (Objects.equals(choice,"n")){
                play = false;
            }
        }



    }

    // adding the string from Pointer1 to Pointer2.
    private static String concat_string(String[] str_arr, int ptr1, int ptr2){
        String concat = "";
        for (int i = ptr1; i <= ptr2; i++){
            concat = concat + str_arr[i];
        }
        return concat;
    }


}
