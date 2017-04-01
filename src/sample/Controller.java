package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    Human h = null;
    PersonalWindow pw = null;
    final Stage dialog = new Stage();;

    @FXML
    public void initialize() throws IOException {

        File f = new File("properties.data");
        if (!f.exists()) {

        }
    }


    @FXML
    public RadioButton female;
    @FXML
    public RadioButton male;
    @FXML
    public TextField mass;
    @FXML
    public TextField procentOfAlchohol;
    @FXML
    public TextField time;
    @FXML
    public TextField amountOfDrunken;
    @FXML
    public Button submit;
    @FXML
    public TextField result;
    @FXML
    public Label lPersonsMass;
    @FXML
    public Label lProcentOfAlchohol ;
    @FXML
    public Label lAmountOfAlchohol;
    @FXML
    public Label lSelectYourGender;
    @FXML
    public Button personal;
    @FXML
    public void counter() {
        double c, a,p,r,t, procent;
        double b = 0.13;
        if (procentOfAlchohol.getText() == null)
            procent = 0;
        else
            procent = Double.valueOf(procentOfAlchohol.getText());
        double amount = Double.valueOf(amountOfDrunken.getText());
        if (male.isSelected()) {r = 0.68;} else {r = 0.55;}
        t = Double.valueOf(time.getText());
        a = amount * procent;
        p = Double.valueOf( mass.getText())/100;
        h = new Human(p,  male.isSelected());
        h.savetofile();

        c = a / (p * r) - b * t;
        result.setText(String.valueOf(c));


    }

    @FXML
    public void goToWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("personal.fxml"));
        Main.primaryStage.setScene(new Scene(root));

//        PersonalController fc = loader.getController();
//        fc.button.setText(field.getText());

        Main.primaryStage.show();
    }
}
