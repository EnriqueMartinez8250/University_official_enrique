package edu.cudenver.university_official_enrique;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {
    public TextField textStudentName;
    public DatePicker dtpStudentDOB;
    public Button btnAddUndergraduate;
    public TextField txtPhdDissertation;
    public TextField txtCourseNumber;
    public ComboBox<String> seleCourseSubject;
    public TextField txtCourseTitle;
    public Button btnExit;
    public Tab tabListStudents;
    public ListView<Student> LstStudent;
    public ListView<Course> lstCourses;
    public Tab tabListcourses;


    private University university;

    public Controller(){

        university = new University();
        this.seleCourseSubject = new ComboBox<>();
        this.LstStudent = new ListView<>();
        this.lstCourses = new ListView<>();
    }

    public void initialize(){

        this.seleCourseSubject.setItems(FXCollections.observableArrayList("CSCI","MATH"));
        this.LstStudent.setItems(FXCollections.observableArrayList(university.getStudents()));
        this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
    }

    private void cleanAddStudent(){
        this.textStudentName.setText("");
        this.dtpStudentDOB.setValue(null);
        this.txtPhdDissertation.setText("");
    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void addUndergraduateStudent(ActionEvent actionEvent) {
        university.addUndergrad(this.textStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully!");
        alert.show();
        System.out.println(university);


    }

    public void addPhDStudent(ActionEvent actionEvent) {
        university.addPhD(this.textStudentName.getText(),this.dtpStudentDOB.getValue(),
                this.txtPhdDissertation.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully!");
        alert.show();
        System.out.println(university);
        cleanAddStudent();

    }

    public void addMasterStudent(ActionEvent actionEvent) {

        university.addMaster(this.textStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully!");
        alert.showAndWait();
        System.out.println(university);
        cleanAddStudent();

    }

    public void addCourse(ActionEvent actionEvent) {
        try {

            university.addCourse(this.seleCourseSubject.getValue(), Integer.parseInt(this.txtCourseNumber.getText()), this.txtCourseTitle.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Course added successfully!");
            alert.showAndWait();
            System.out.println(university);
        }
        catch (IllegalArgumentException iae){
            Alert alert = new Alert(Alert.AlertType.ERROR, iae.getMessage());
            alert.showAndWait();
        }

        }

    public void exitApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();

    }

    public void listStudentsUpdate(Event event) {
        if(this.tabListStudents.isSelected()) {
            this.LstStudent.setItems(FXCollections.observableArrayList(university.getStudents()));
        }
    }

    public void listCoursesUpdate(Event event) {
        if(this.tabListcourses.isSelected()){
            this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
        }
    }

    public void saveToFile(ActionEvent actionEvent) {
        university.saveToFile();
    }

    public void loadFromButton(ActionEvent actionEvent) {
        this.university = University.loadFromFile();
        this.initialize();
    }
}