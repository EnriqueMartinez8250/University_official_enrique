package edu.cudenver.university_official_enrique;

import java.time.LocalDate;

public class Master extends Graduate{
    private String dissertationTopic;

    public Master(String name, LocalDate dob){
        super(name,dob);

    }

    @Override
    public String getStanding(){
        return "Master";
    }



}
