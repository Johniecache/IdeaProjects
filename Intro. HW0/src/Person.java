/*
    @Class: Person
    @Description: Creates an object that the student and teacher class will inherit from. sets the name of a person
    @Author: Caleb Thomas
 */
public class Person {
    private String _name;

    /*
        @Name: Person
        @Description: default constructor for the person object. no inputs.
        @Returns: nothing
     */
    public Person(){
        _name = "John Doe";
    }
    /*
        @Name: Person
        @Description: Default constructor for the person object. Takes name input.
        @Returns: nothing
     */
    public Person(String name){
        _name = name;
    }
    /*
        @Name: toString
        @Description: overrides the default java toString method
        @Returns: name of the instance person object
     */
    public String toString(){
        System.out.println(_name);
        return _name;
    }
    /*
        @Name: setName
        @Description: sets the name of the instance object
        @Returns: nothing
     */
    public void setName(String name){
        _name = name;
    }
    /*
        @Name: getName
        @Description: gets the name of the instance object
        @Returns: name
     */
    public String getName(){
        return _name;
    }
}
