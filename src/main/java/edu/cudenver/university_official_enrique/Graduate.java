package edu.cudenver.university_official_enrique;


import java.time.LocalDate;

public class Graduate extends Student {

    public Graduate(String name, LocalDate dob) {
      super(name,dob);
    }

    public String getStanding(){
        return "Graduate";
    };

}
