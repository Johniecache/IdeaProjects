// DO NOT REMOVE THE PACKAGE LINE!!
// Without this line Autograder will not run correctly
// You can comment it while you work on the problem
// When everything works - uncomment and submit!
package com.gradescope.HW1;
import java.util.Scanner;

/* Make sure to use good coding practices such as indenting code,
writing comments, use meaningful variable names, and so on
*/
public class HW1 {
    public static void main(String[] args) {
// test you code here
// main will not be graded but it must compile with no errors.

        // MISMATCH
        mismatch("ATCGAT","TAGCTA");
        mismatch("ATCGAT","TAGCAA");
        mismatch("ATCGAT","TATCTT");
        mismatch("ATCG","TATCTT");

        // REMOVE ZEROS
        removeZeros(new int[] {1,-2,3});
        removeZeros(new int[] {1,0,0});
        removeZeros(new int[] {1,0,-2,0,3});
        removeZeros(new int[] {0,0});

        // VOWELCOUNT
        vowelCount("homework");
        vowelCount("sun\n goes down early");
        vowelCount("fly");


        // PRINTSTRINGS
        Scanner sc = new Scanner(System.in);
        printStrings(sc);


        // SHOWTWOS
        System.out.println("\n\n");
        showTwos(7);
        showTwos(18);
        showTwos(68);
        showTwos(120);

    }

/* Write the mismatch method here. The method takes two Strings
and returns the number of mismatches */
    public static int mismatch(String x, String y){
        int count = 0; //Counts the number of mismatches
        char[] x_arr = x.toCharArray(); // Turning x string to char array
        char[] y_arr = y.toCharArray(); // Turning y string to char array

        if(x_arr.length==y_arr.length || x_arr.length> y_arr.length){
            char[] y_copy = new char[x_arr.length]; // creating new y array incase its smaller then x array
            System.arraycopy(y_arr,0,y_copy,0,y_arr.length); // putting y into new array incase it is smaller then x_arr
            for(int i=0;i< x_arr.length;i++){ // for loop to go through arrays
                if(x_arr[i]=='A'){ // if char is A...
                    if(y_copy[i]!='T'){ // Should be paired with T, if not count goes up
                        count++;
                    }
                }
                if(x_arr[i]=='T'){ // if char is T...
                    if(y_copy[i]!='A'){ // should be paired with A
                        count++;
                    }
                }
                if(x_arr[i]=='G'){ // if char is G...
                    if(y_copy[i]!='C'){ // should be paired with C
                        count++;
                    }
                }
                if(x_arr[i]=='C'){ // if char is C...
                    if(y_copy[i]!='G'){ // should be paired with G
                        count++;
                    }
                }
                if(y_copy[i]==0){ // if y array is null then theres a mismatch
                    count++;
                }
            }
        }

        if(x_arr.length<y_arr.length){
            char[] x_copy = new char[y_arr.length]; //copying x_arr into a new array with null at the end
            System.arraycopy(x_arr, 0, x_copy, 0, x_arr.length); // copies old array into new array
            for(int i=0;i<y_arr.length;i++){ // for loop to go through arrays
                if(x_copy[i]=='A'){ // if char is A...
                    if(y_arr[i]!='T'){ // Should be paired with T, if not count goes up
                        count++;
                    }
                }
                if(x_copy[i]=='T'){ // if char is T...
                    if(y_arr[i]!='A'){ // should be paired with A
                        count++;
                    }
                }
                if(x_copy[i]=='G'){ // if char is G...
                    if(y_arr[i]!='C'){ // should be paired with C
                        count++;
                    }
                }
                if(x_copy[i]=='C'){ // if char is C...
                    if(y_arr[i]!='G'){ // should be paired with C
                        count++;
                    }
                }
                if(x_copy[i]==0){ // if x array is null at any point is has a mismatch
                    count++;
                }
            }
        }



        System.out.println(count);
        return count;
    }
/* Write the removeZeros method here. The method takes an array
of integers and returns a new array */
    public static int[] removeZeros(int[] arr){
        int count = 0;

        for(int i=0;i<arr.length;i++){ // looping through array
            if(arr[i]!=0){ // counts all non zeros
                count++; // increase count if true
            }
        }

        int[] no_zeros = new int[count]; // sets no_zeros array to the counted number of non zeros
        int pos = 0; // position number counter

        for(int i=0;i<arr.length;i++){ // loop through array again
            if(arr[i]!=0){ // if array isnt 0...
                no_zeros[pos] = arr[i]; // put the array number from arr into no_zero array at position pos
                pos++; // increase position
            }
        }

        for(int i=0;i<no_zeros.length;i++){ // for output purposes
            System.out.println(no_zeros[i]);
        }
        return no_zeros; // return
    }
/* Write the vowelCount method here. The method takes a String
and returns a new array of integers
representing the counts of each vowel in the String. */
    public static int[] vowelCount(String s){
        char[] s_arr = s.toCharArray();
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;

        for(int j=0;j<s_arr.length;j++){ // to loop through the char array
            if(s_arr[j]=='a'){ // check if array at j is a
                a++;
            }
            if(s_arr[j]=='e'){ // check if array at j is e
                e++;
            }
            if(s_arr[j]=='i'){ // check if array at j is i
                i++;
            }
            if(s_arr[j]=='o'){ // check if array at j is o
                o++;
            }
            if(s_arr[j]=='u'){ // check if array at j is u
                u++;
            }
        }

        int[] vowels = new int[] {a,e,i,o,u}; // new array that takes vowel variables as inputs

        for(int j=0;j<vowels.length;j++){ // for return purposes
            System.out.print(vowels[j] + ", ");
        }
        return vowels;
    }
/* Write the printStrings method here. The method takes a Scanner
holding a sequence of integer/string pairs and prints to the console
(System.out) one line of output for each pair, with the given
String repeated the given number of times. */
    // Works only for 1 pair
    public static void printStrings(Scanner sc){
        //System.out.println("\nEnter for problem 4: "); // Output to use to get info
        String s = sc.nextLine(); // String for the input

        String string = ""; // empty string for output
        int pos = 0; // position mark starting at 0
        int count = 0; // count number for how many times needing to repeat
        String[] sc_arr = s.split(" "); // Take string and parse on white space

        for(int i=0;i<sc_arr.length;i++){ // loop through new array
            if(pos%2==0){ // every even number in array should be a number
               count = Integer.parseInt(sc_arr[i]); // assign count to the number
               pos++; // increment pos
            }
            else{ // if not even then odd number, should always be String that is to be repeated
                string = sc_arr[i];
                pos++; // increment pos

                //System.out.println("\n");

                for(int j=0;j<count;j++){
                    System.out.print(string);
                }
                System.out.print("\n");
            }
        }
    }
/* Write the showTwos method here. The method takes an int and prints
on the console factors of 2 in a given integer in the format
specified in the assignment. */
    public static void showTwos(int n){
        int org = n; // original number n
        int count = 0; // count of how many times n can be divided evenly by 2
        while(n%2==0){ // as long as n is even
            n = n/2; // new n is divided by 2
            count++; // increase number of times its divided by 2
        }

        System.out.print(org + " = "); // original number n input and equals sign
        for(int i=0;i<count;i++){ // for number count output 2 *
            System.out.print(2 + " * ");
        }
        System.out.println(n); // output final number that wasnt even
    }
}
