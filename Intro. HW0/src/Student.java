/*
    @Class: Student
    @Description: creates a student object inherited from the person class, also sets a lunch pref. and
                    returns such values
    @Author: Caleb Thomas
 */
public class Student extends Person{
    private String _lunchPreference;
    /*
        @Name: Student
        @Description: Default constructor for the student object with default lunch pref. set to hot
        @Returns: nothing
     */
    public Student(){
        _lunchPreference = "Hot";
    }
    /*
        @Name: Student
        @Description: Default constructor for the student object, takes string as input and sets it as lunch pref.
        @Returns: nothing
     */
    public Student(String lunchPreference){
        _lunchPreference = lunchPreference;
    }
    /*
        @Name: toString
        @Description: overrides the default toString in java
        @Returns: "nicely" put together string with general overview of Student instance
     */
    public String toString() {
        System.out.println("I am " + getName() + ", who prefers " +
                            getLunchPreference() + " lunch.");

        return getName();
    }
    /*
        @Name: setLunchPreference
        @Description: inputs a string and sets it as a lunch pref. of student instance
        @Returns: nothing
     */
    public void setLunchPreference(String lunchPreference) {
        _lunchPreference = lunchPreference;
    }
    /*
        @Name: getLunchPreference
        @Description: gets the value of the Student instance lunch pref.
        @Returns: lunchPreference
     */
    public String getLunchPreference(){
        return _lunchPreference;
    }
}
