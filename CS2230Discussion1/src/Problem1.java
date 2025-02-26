//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
package com.gradescope.lab1pr1;

public class Problem1 {
    /*Find all the problems (bugs)
    / fix the errors (explain in comments what you did to fix it!)
    / When the program is fixed. Run it.

    /Correct run will print:
    /Hello Class!
    / 12
    /This is 17
    */

    public static void main(String[] args) {
        String x = "Hello Class!";
        System.out.println(x);
        int z = 7 + 5; // changed x to z
        System.out.println(z); // changed x to z
        int y; // defined y
        y = z + 4; // added semicolon
        y += 1;
        System.out.println("This is " + y);
    }
}