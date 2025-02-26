/*
    @Class: Classroom
    @Description: Creates a classroom environment that takes in an array of students and a primary teacher.
                    It returns roll call, number of hot and cold lunches, grade leve, primary teacher and their ID.
    @Author: Caleb Thomas
 */

public class Classroom {
    private int _gradeLevel;
    private Teacher _t;
    private int _numStudents;
    private Student[] _studentArray;

    // Default constructor for the classroom object, no input variables
    public Classroom(){
        _gradeLevel = 0;
        _t = null;
        _numStudents = 0;
        _studentArray = new Student[0];
    }
    // Constructor for the classroom object, assigns input varibles
    public Classroom(int gradeLevel, Teacher t, int numStudents, Student[] studentArray){
        _gradeLevel = gradeLevel;
        _t = t;
        _numStudents = numStudents;
        _studentArray = studentArray;
    }

    /*
        @name: rollCall
        @Description: Takes no input, goes through the student array that is initialized earlier,
                        gets the name of the student and their lunch preference.
        @returns: the students name and the lunch pref. they choose.
     */
    public void rollCall(){
        for(int i = 0; i<_studentArray.length; i++){
            System.out.println(_studentArray[i].getName() + " " + _studentArray[i].getLunchPreference());
        }
    }
    /*
        @name: generateLunchReport
        @Description: takes no input, runs through the student array created earlier and checks each students
                        pref. lunch type either "Hot" or "Cold"
        @Returns: the total number of Hot lunches and Cold lunches
     */
    public void generateLunchReport(){
        int hot = 0;
        int cold = 0;
        for(int i=0;i<_studentArray.length;i++){
            if(_studentArray[i].getLunchPreference() == "Hot"){
                hot++;
            }
            if(_studentArray[i].getLunchPreference() == "Cold"){
                cold++;
            }
        }
        System.out.println("Hot: " + hot);
        System.out.println("Cold: " + cold);
    }
    /*
        @name: toString
        @Description: Overrides the default toString method in java and grabs multiple variable of the instance
        @Returns: To the terminal the grade level, teachers name, and number of students all in a nice looking string
     */
    public String toString(){
        System.out.println("This classroom has grade " + _gradeLevel + " students. It is taught by " + _t.getName() + ". There are " +
                            _numStudents + " students.");
        return "";
    }

    /*
            @name: setGradeLevel
            @Description: sets the grade level
            @Returns: nothing
         */
    public void setGradeLevel(int lvl){
        _gradeLevel = lvl;
    }
    /*
        @name: setTeacher
        @Description: sets the primary teacher
        @Returns: nothing
     */
    public void setTeacher(Teacher t){
        _t = t;
    }
    /*
        @name: setStudentArray
        @Description: sets the new array of students, takes in an array of students and the number of
                        students in the array. runs through input array and assigns to instance array.
        @Returns: nothing
     */
    public void setStudentArray(Student[] s, int numStudent){
        _numStudents = numStudent;
        _studentArray = new Student[_numStudents];
        for(int i = 0; i<s.length;i++){
            _studentArray[i] = s[i];
        }
    }

    /*
        @name: getGradeLevel
        @Description: gets the grade level of the instance object
        @Returns: grade level
     */
    public int getGradeLevel(){
        return _gradeLevel;
    }
    /*
        @name: getID
        @Description: splits the string of the teacher and takes only the first element or the first
                        letter of the teachers name.
        @Returns: returns first letter of the teachers name and the grade level.
     */
    public int getID(){
        String[] s = _t.getName().split("");
        System.out.println(s[0] + " " + _gradeLevel);

        return _t.getId();
    }
    /*
        @name: getNumStudents
        @Description: gets the number of students in instance object
        @Returns: number of students
     */
    public int getNumStudents(){
        return _numStudents;
    }
    /*
        @name: getStudentArray
        @Description: gets the pointer to the student array
        @Returns: pointer to student array.
     */
    public Student[] getStudentArray(){
        return _studentArray;
    }


}
