module edu.cudenver.university_official_enrique {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.cudenver.university_official_enrique to javafx.fxml;
    exports edu.cudenver.university_official_enrique;
}