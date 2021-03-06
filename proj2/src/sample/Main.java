package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        List<Clube> listaDeClientes = Clube.readAll("");

        for(Clube cl : listaDeClientes)
            System.out.println("ID " + cl.getId_clube() +
                    " chama-se " + cl.getNome() +
                    " sediado " + cl.getLocalizacao()+
                    " e tem "+ cl.getN_atletas()+" Atletas");

        System.out.println("----------------------------------------------------------------------------------------");
    }
}