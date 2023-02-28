package edu.cudenver.university_official_enrique;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class University implements Serializable {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public static final String filename = "./university.ser";


    public University(){
        this.students = new ArrayList<>(100);
        this.courses = new ArrayList<>(100);

    }

    @Override
    public String toString(){
        return String.format("University with %d students and %d courses.",this.getStudents().size(),this.getCourses().size());

    }

    public Student getStudent(String name) throws IllegalArgumentException{
        for (Student s: students){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }

        throw new IllegalArgumentException("Student not in university");

    }

    public Course getCourse(String subject, int number) throws IllegalArgumentException{
        for (Course c: courses){
            if(c.getSubject().equalsIgnoreCase(subject) && c.getNumber()==number){
                return c;
            }
        }
        throw new IllegalArgumentException("Course not in the subjects.");

    }

    public void addUndergrad(String name, LocalDate dob){students.add(new Undergraduate(name,dob));}
    public void addMaster(String name, LocalDate dob){students.add(new Master(name, dob));}
    public void addPhD(String name, LocalDate dob, String topic){students.add(new PhD(name, dob, topic));}



    public void addCourse(String subject, int number, String title) throws IllegalArgumentException{
        try{
            this.getCourse(subject, number);
        }
        catch(IllegalArgumentException iae){
            this.courses.add(new Course(subject,number,title));
            return;
        }
        throw new IllegalArgumentException("The course is already in the Subjects.");
    }
    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void saveToFile(){
        String filename = "./university.ser";

        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(this);

        }
        catch(IOException ioe){
            ioe.printStackTrace();

        }
        finally{
            if (oos !=null){
                try{
                    oos.close();
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static University loadFromFile(){
        ObjectInputStream ois = null;
        University university = null;

        try{
            ois = new ObjectInputStream(new FileInputStream(University.filename));
            university = (University) ois.readObject();

        }
        catch(Exception e){
            e.printStackTrace();
            university = new University();
        }
        finally {
            if(ois != null){
                try{ois.close();}
                catch(IOException ioe){ioe.printStackTrace();}
            }
        }
        return university;
    }





}
