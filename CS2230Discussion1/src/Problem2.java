//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
package com.gradescope.lab1pr2;

public class Problem2 {
    /*This program generates numbers 1 through 20 inclusive using for loop
    / and prints either the number itself, if it is even or
    / prints double of the value if it is odd 
     */
    public static void main(String[] args){
        //Create a for loop that generates numbers 1 to 20 inclusive
        for(int i = 1; i<21; i++){
            //if i is even
            if(i%2==0){
                //print i using println
                System.out.println(i);
            }
            else{ //i is odd
                //print using println value of i doubled: 2i
                int r = 2 * i;
                System.out.println(r);
            }
        }
    }
}