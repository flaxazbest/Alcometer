package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Alcoholmetre");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getScene().getStylesheets().add("sample/JMetroDarkTheme.css");
        runStage(primaryStage);
    }

    public static void runStage(Stage stage )
    {
        primaryStage = stage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
