package sample;

import javax.swing.*;

import com.sun.glass.ui.Screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        Parent criarProvas_parent = FXMLLoader.load(getClass().getResource("CriarProva.fxml"));
        Scene criarProvas_scene = new Scene(criarProvas_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(criarProvas_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

