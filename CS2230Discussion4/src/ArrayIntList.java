// DO NOT REMOVE PACKAGE LINE
// Without this line the autograder will not run correctly
// You can comment it while you work on the problem
// When everything works - uncomment and submit!
package com.gradescope.lab4;
/* Header
Lab 4
Authors:
*/
public class ArrayIntList {
    // copyright https://www.buildingjavaprograms.com/supplements5.shtml
    private int[] list; // list of integers
    private int size; // current number of elements in the list
    public static final int DEFAULT_CAPACITY = 100;
    // Constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }
    // Constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
//throws IllegalArgumentException if negative capacity provided
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = new int[capacity];
        size = 0;
    }
    // Returns the current number of elements in the list (not size of the array)
    public int size() {
        return size;
    }
    // Returns the integer at the given index in the list
    public int get(int index) {
//checks index is in bounds and throws error otherwise
        checkIndex(index);
        return list[index];
    }
// Creates a string representation as comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + list[0];
            for (int i = 1; i < size; i++) {
                result += ", " + list[i];
            }
            result += "]";
            return result;
        }
    }
    // Returns the position of the first occurrence of the given
// returns value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }
    // Returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    // Returns true if the given value is contained in the list,
// returns false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }
    // Appends the given value to the end of the list
    public void add(int value) {
//checks we have space for one more element in array
        checkCapacity(size + 1);
        list[size] = value;
        size++;
    }
    // Inserts the given value at the given index, shifting subsequent values right
    public void add(int index, int value) {
//checks index is in bounds and throws error otherwise
        checkIndex(index);
//checks we have space for one more element in array
        checkCapacity(size + 1);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        size++;
    }
// Removes value at the given index, shifting subsequent values in the list left
    public void remove(int index) {
//checks index is in bounds and throws error otherwise
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }
    // Replaces the integer at the given index with the given value
    public void set(int index, int value) {
//checks index is in bounds and throws error otherwise
        checkIndex(index);
        list[index] = value;
    }
    // Removes all elements from the list (not array)
    public void clear() {
        size = 0;
    }
    // Checks that array has the given capacity
// throws an IllegalStateException otherwise
    private void checkCapacity(int capacity) {
//list.length is actual array list
        if (capacity > list.length) {
            throw new IllegalStateException("would exceed list capacity");
        }
    }
    //Checks if the index inside the bound of actual list size
//throws IndexOutOfBound exception otherwise
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
// Lab 4 part 1
// Write a method removeAll that takes an integer n as input and
// removes all occurrences of n from the list.
    public int[] removeAll(int n){
        int count = list.length; // total elements in the array
        for(int i=0;i<list.length;i++){ // loop through array
            if(list[i]==n){ // if the element does equal the input value
                count--; // subtract count
            }
        }
        int[] list2 = new int[count]; // create list 2 for return
        for(int i=0;i<list.length;i++){ // re-loop through original list
            if(list[i]!=n){ // if list at i element isn't input value
                list2[i] = list[i]; // put that number into the new list
            }
        }
        return list2; // return the new list
    }
// Write a method runningTotal that takes no input and returns
// a new ArrayIntList containing a running total of the original list.
    public void runningTotal(){
        int[] list = {1,2,3,5,7,9,27}; // {1,3,6,11,18,,27,54}
        int[] list2 = new int[list.length]; // create new list for input
        list2[0] = list[0];
        for(int i=1;i<list.length;i++){ // loop through list
            list[i] += list[i-1];
            list2[i] = list[i];
        }
        for(int i=0;i<list2.length;i++){
            System.out.println(list2[i]);
        }
    }
}
