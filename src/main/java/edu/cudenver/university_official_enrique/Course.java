package edu.cudenver.university_official_enrique;

import java.io.Serializable;

public class Course implements Serializable {

    private String subject; //CSCI
    private int number; //3920
    private String title; //Adv Programming


    public Course(String subject, int number, String title){
        this.subject = subject.toUpperCase();
        this.number = number;
        this.title = title;
    }

    @Override
    public String toString(){
        return String.format("%s%04d - %s", this.subject, this.number, this.title);
    }

    public String getSubject(){
        return subject;
    }

    public int getNumber(){
        return number;
    }

    public String getTitle(){
        return title;
    }
}
