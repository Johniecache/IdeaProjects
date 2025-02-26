/*
    @Class: Teacher
    @Description: extends the person class to fit better a teacher which will also take a subject, degree, uni, and ID
    @Author: Caleb Thomas
 */
public class Teacher extends Person{
    private String _subject;
    private String _degree;
    private String _university;
    private int _id;

    /*
        @Name: Teacher
        @Description: Default constructor for the teacher class, no inputs.
        @Returns: nothing
     */
    public Teacher(){
        _subject = "N/A";
        _degree = "N/A";
        _university = "N/A";
        _id = -1;
    }
    /*
        @Name: Teacher
        @Description: Default constructor for the teacher class, takes input.
        @Returns: nothing
     */
    public Teacher(String subject, String degree, String university, int id){
        _subject = subject;
        _degree = degree;
        _university = university;
        _id = id;
    }
    /*
        @Name: toString
        @Description: Overrides the default java toString method.
        @Returns: a nicely put together sting of the teacher object instance with all info about the teacher.
     */
    public String toString(){
        System.out.println("I am " + getName() + ", a teacher of " + getSubject() +
                            ". I hold a " + getDegree() + " degree from " + getUniversity() +
                            ", and my ID is " + getId());
        return getName();
    }

    /*
        @Name: setId
        @Description: sets the ID of the teacher instance and increments if from the previous one as input
        @Returns: nothing
     */
    public void setId(int id){
        _id = id + 1;
    }
    /*
        @Name: setSubject
        @Description: takes string as input and sets it for the instance class
        @Returns: nothing
     */
    public void setSubject(String subject){
        _subject = subject;
    }
    /*
        @Name: setDegree
        @Description: takes string as input and sets it as the degree for instance class
        @Returns: nothing
     */
    public void setDegree(String degree){
        _degree = degree;
    }
    /*
        @Name: setUniversity
        @Description: takes a string as input and sets it as the uni. the instance teacher graduated from
        @Returns: nothing
     */
    public void setUniversity(String university){
        _university = university;
    }

    /*
        @Name: getId
        @Description: gets the id of the teacher instance
        @Returns: id
     */
    public int getId(){
        return _id;
    }
    /*
        @Name: getSubject
        @Description: gets the subject of the teacher instance
        @Returns: subject
     */
    public String getSubject(){
        return _subject;
    }
    /*
        @Name: getDegree
        @Description: gets the degree of the teacher instance
        @Returns: degree
     */
    public String getDegree(){
        return _degree;
    }
    /*
        @Name: getUniversity
        @Description: gets the uni. of the teacher instance
        @Returns: university
     */
    public String getUniversity(){
        return _university;
    }
}
