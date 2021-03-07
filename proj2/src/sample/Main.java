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
        /*
        Cliente cli = new Cliente();
        cli.setNome("Amália Silva");
        cli.setMorada("Rua ANKFF, 123");
        cli.setCpostal("6745-213");

        cli.create();

        System.out.println("ID criado: " + cli.getIdCliente());


        Cliente cl2 = new Cliente();
        cl2.read(43);
        System.out.println("ID " + cl2.getIdCliente() + " chama-se " + cl2.getNome() + " e mora em " + cl2.getMorada());
        */

        List<Clube> listaDeClientes = Clube.readAll("");

        for(Clube cl : listaDeClientes)
            System.out.println("ID " + cl.getId_clube() + " chama-se " + cl.getNome() + " e mora em " + cl.getLocalizacao()+ " e nAtletas em " + cl.getN_atletas());

        System.out.println("----------------------------------------------------------------------------------------");
        /*
        Cliente cl3 = new Cliente();
        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.setNome("Josefina d'Alenquer");
        cl3.setMorada("Praça da Liberdade");
        cl3.update();
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.delete();
        */
    }

}