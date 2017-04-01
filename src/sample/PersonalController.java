package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


import java.io.File;
import java.io.IOException;

public class PersonalController {

    @FXML
    TextField mass;
    @FXML
    RadioButton male;
    @FXML
    RadioButton female;

    @FXML
    public void initialize() throws IOException {

        ToggleGroup tg = new ToggleGroup();
        male.setToggleGroup(tg);
        female.setToggleGroup(tg);

        File f = new File("properties.data");
        if (f.exists()) {

            Human h = Human.readFromFile();
            mass.setText(String.valueOf(h.getP()));
            if (h.isMale())
                male.fire();
            else
                female.fire();

        }
    }

    @FXML
    public void openForm() throws IOException {

        Human h = new Human(Double.parseDouble(mass.getText()), male.isSelected());
        h.savetofile();

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("sample.fxml"));
        Main.primaryStage.setScene(new Scene(root));
        Main.primaryStage.getScene().getStylesheets().add("sample/JMetroDarkTheme.css");
        Controller fc = loader.getController();
        //       fc.button.setText(field.getText());

        Main.primaryStage.show();
    }
}
