package edu.cudenver.university_official_enrique;

import java.time.LocalDate;

public class PhD extends Graduate{
    private String dissertationTopic;

    public PhD(String name, LocalDate dob, String dissertationTopic){
        super(name,dob);
        this.dissertationTopic = dissertationTopic;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format(" - dissertation is about %s", this.getDissertationTopic()));
        return sb.toString();
    }

    @Override
    public String getStanding(){
        return "PhD";
    }

    public String getDissertationTopic() {
        return dissertationTopic;
    }
}
