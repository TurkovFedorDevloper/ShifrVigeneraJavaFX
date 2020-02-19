package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    String alph = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField massField;

    @FXML
    private PasswordField keyField;

    @FXML
    private Button cryptButton;

    @FXML
    private Button deCryptButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField exitMassField;

    @FXML
    void initialize() {

        deleteButton.setOnAction(event -> {
            massField.setText(null);
            keyField.setText(null);
            exitMassField.setText(null);
        });

        cryptButton.setOnAction(event -> {

            if (keyField.getText().trim().length() == 0) {
                keyField.setText("А");
            }

            char[] alphChar = alph.toCharArray();
            char[] massFieldChar = massField.getText().toCharArray();
            char[] keyFieldChar = keyField.getText().toCharArray();
            String cryptMass = "";

            for (int i = 0, k = 0; i < massFieldChar.length; i++, k++) {

                int flag = 0;

                if (k == keyFieldChar.length) {
                    k -= keyFieldChar.length;
                }
                for (int j = 0; j < alphChar.length; j++) {
                    if (massFieldChar[i] == alphChar[j]) {
                        for (int j1 = 0; j1 < alphChar.length; j1++) {
                            if (keyFieldChar[k] == alphChar[j1]) {
                                flag++;
                                if (flag == 1) {
                                    cryptMass += alphChar[j + j1];
                                }
                            }
                        }
                    }
                }
            }
            exitMassField.setText(cryptMass);
        });

        deCryptButton.setOnAction(event -> {

            if (keyField.getText().trim().length() == 0) {
                keyField.setText("А");
            }

            char[] alphChar = alph.toCharArray();
            char[] massFieldChar = massField.getText().toCharArray();
            char[] keyFieldChar = keyField.getText().toCharArray();
            String cryptMass = "";

            for (int i = 0, k = 0; i < massFieldChar.length; i++, k++) {

                int flag = 0;

                if (k == keyFieldChar.length) {
                    k -= keyFieldChar.length;
                }
                for (int j = 33; j < alphChar.length; j++) {
                    if (massFieldChar[i] == alphChar[j]) {
                        for (int j1 = 0; j1 < alphChar.length; j1++) {
                            if (keyFieldChar[k] == alphChar[j1]) {
                                flag++;
                                if (flag == 1) {
                                    cryptMass += alphChar[j - j1];
                                }
                            }
                        }
                    }
                }
            }
            exitMassField.setText(cryptMass);
        });
    }
}

