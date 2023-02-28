package edu.cudenver.university_official_enrique;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml")); //Loads the application.fxml
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720); //Size of the window
        stage.setTitle("University Application!"); //Title
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}