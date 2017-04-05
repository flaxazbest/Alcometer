package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;


import javax.swing.event.DocumentEvent;
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
    ChoiceBox<String> choice;
    @FXML
    ComboBox<String> combo;

    @FXML
    public void initialize() throws IOException {

        choice.getItems().add("Something");
        choice.getItems().addAll("Something else", "Anytjing");
        choice.setValue("Something");

        combo.getItems().addAll("a", "b", "c");
        combo.setEditable(false);
        combo.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ENTER) {
                String text = combo.getValue();
                combo.getItems().add(text);
                combo.setValue("");
            }
        });

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
