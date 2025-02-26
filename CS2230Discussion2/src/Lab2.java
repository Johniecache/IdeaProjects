//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
package main.java.com.gradescope.lab2;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.*;
/* Please make sure to use good practices of coding
indent, write comment, use meaningful variable names */
public class Lab2 {
    public static void main(String[] args){
    /*possible test from the lab handout
    directly from Examples */

        //count tests
        int[] arr = {3,5,1,92,38,3,14,5,73,5};
        count(arr,3);
        count(arr, 5);
        count(arr,12);

        //duplicates tests
        duplicates(new String[] {});
        duplicates(new String[] {"Hello"});
        duplicates(new String[] {"Hello","hello"});
        duplicates(new String[] {"Hello","apple","winter","Apple","Hello"});


        //stretch
        stretch(new int[] {});
        stretch(new int[] {13});
        stretch(new int[] {-9});
        stretch(new int[] {5,8,3,2});
    }
/* The count method takes an array of integers a
and a target value t, and returns the number of times t
occurs in a */

    public static int count(int[] a, int t){
        int total = 0; // Set a total to increment
        for(int i = 0; i<a.length; i++){ // loop through input array
            if(a[i]==t){ // if it equals the input target increment total
                total++;
            }
        }
        // Outputs
        System.out.println(total);
        return total;
    }

/* The duplicates method takes an array of Strings s.
The method returns true if there are duplicate values
in the array s, and false otherwise.
Treat all string values as case sensitive. */

    public static boolean duplicates(String[] s){
        boolean bool = false; // create a boolean value and set to false by default
        for(int i = 0; i<s.length;i++){ // increment through input array
            for(int j=i+1; j<s.length;j++){ // increment through input array again
                if(i==j){ // check if at same position and if so break the loop
                    break;
                }
                if (Objects.equals(s[i], s[j])) { // check if array at i and at j are the same value
                    bool = true; // set bool to true if values in array at i and j are equal
                    break; // break loop
                }
            }
        }
        // Outputs
        System.out.println(bool);
        return bool;
    }

/* The stretch method takes an integer array a.
and returns a new array that has twice as many elements
as the original a. Each element n of the original array
corresponds to two elements in the new array. If n is at
position i in a, the two new elements are at position
2*i and 2*i + 1 in the new array.
Moreover, if n is even, the two new elements are each half
of n. If n is odd, the first element is equal to the second
plus 1, and their sum equals n. */

    public static int[] stretch(int[] a){
        int[] f = new int[a.length*2]; //Initialize new array
        int pos = 0; //Initialize position number of the new array
        for(int i=0;i<a.length;i++){ //Cycle through input array
            if(a[i]%2==0){ //Even number
                int num = a[i] / 2; //Set num to the number wanted to input in new array
                f[pos] = num; //Put num into new array
                f[pos+1] = num; //Put num into next pos in new array
                pos += 2; // Increment pos by 2 for next open spot
            }
            else{ //Odd number
                if(a[i]>=0) { //Check if positive integer
                    int num = a[i] / 2; //Set num to the number wanted in new array
                    f[pos] = num + 1; //Put num into new array at pos
                    f[pos + 1] = num; //Put num into new array at next pos
                    pos += 2; //Increment pos by 2 for next open spot
                }
                else{ //Negative integer
                    int num = a[i] / 2; //Set num to the number wanted in new array
                    f[pos] = num; //subtract one from number since its negative and set in next pos
                    f[pos+1] = num - 1; // set num in next pos
                    pos += 2; //Increment pos by 2 for next open spot
                }
            }
        }

        //Output
        for(int i=0;i<f.length;i++){
            System.out.println(f[i]);
        }
        return f;
    }

}