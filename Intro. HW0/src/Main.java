/*
    @Class: Main
    @Description: used for testing the Classroom, Person, Teacher, and Student objects
    @Author: Caleb Thomas
 */
public class Main {
    public static void main(String[] args) {

        // Person / Teacher testing
        Person p1 = new Person();
        p1.setName("Jimmy");
        p1.toString();

        Teacher p2 = new Teacher();
        p2.setName("Jane");
        p2.setSubject("Physics");
        p2.setDegree("Astro. Physics");
        p2.setUniversity("University of Iowa");
        p2.setId(0);
        p2.toString();

        Teacher p3 = new Teacher();
        p3.setName("Doe");
        p3.setSubject("Gym");
        p3.setDegree("Physical");
        p3.setUniversity("University of Iowa");
        p3.setId(p2.getId());
        p3.toString();

        // Student testing
        Student s1 = new Student();
        s1.setName("Jarron");
        s1.setLunchPreference("Hot");
        s1.toString();

        Student s2 = new Student();
        s2.setName("Blake");
        s2.setLunchPreference("Cold");
        s2.toString();

        Student s3 = new Student();
        s3.setName("Blain");
        s3.setLunchPreference("Cold");
        s3.toString();

        Student s4 = new Student();
        s4.setName("Brian");
        s4.setLunchPreference("Hot");
        s4.toString();

        Student s5 = new Student();
        s5.setName("Connor");
        s5.setLunchPreference("Hot");
        s5.toString();

        Student s6 = new Student();
        s6.setName("Luke");
        s6.setLunchPreference("Hot");
        s6.toString();

        System.out.println("");

        // Classroom testing
        Classroom c1 = new Classroom();
        c1.setTeacher(p2);
        c1.setGradeLevel(7);
        Student[] s = {s1, s2, s3};
        c1.setStudentArray(s, 3);
        c1.rollCall();
        c1.generateLunchReport();
        c1.getID();
        c1.toString();

        System.out.println("");

        Classroom c2 = new Classroom();
        c2.setTeacher(p3);
        c2.setGradeLevel(2);
        Student[] d = {s4, s5, s6};
        c2.setStudentArray(d,3);
        c2.rollCall();
        c2.generateLunchReport();
        c2.getID();
        c2.toString();

        System.out.println("");

        Teacher nextT = new Teacher();
        nextT.setId(p3.getId());
        System.out.println("Next teacher ID would be: " + nextT.getId());
    }
}
