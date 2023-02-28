package edu.cudenver.university_official_enrique;

import java.time.LocalDate;

public class Undergraduate extends Student{


    public Undergraduate(String name, LocalDate dob){
        super(name,dob);
    }


    @Override
    public String getStanding(){
        return "undergraduate";
    };



}
