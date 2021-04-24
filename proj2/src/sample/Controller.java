package sample;

import javax.swing.*;
import javafx.event.ActionEvent;

import java.util.List;

public class Controller {


    public  void btnVerClube(ActionEvent event){

        List<Clube> listaDeClientes = Clube.readAll("");

        for(Clube cl : listaDeClientes)
            System.out.println("||ID: " + cl.getId_clube() + " ||Clube : " + cl.getNome() + " ||Localização: " + cl.getLocalizacao()+ " ||Numero de Atletas: " + cl.getN_atletas());

        System.out.println("----------------------------------------------------------------------------------------");
    }
    public  void btnCatBarco(ActionEvent event){
        List<CategoriaBarco> listaDeClientes = CategoriaBarco.readAll("");
        for(CategoriaBarco categoriaBarco : listaDeClientes)
            System.out.println("||ID: " + categoriaBarco.getId_categoriaBarco() + " ||Nome do Barco : " + categoriaBarco.getNome());

        System.out.println("----------------------------------------------------------------------------------------");
    }
    public  void btnVerProvas(ActionEvent event){

        System.out.println("---------------------------------Ver Provas-------------------------------------------------------");
    }
    public  void btnInscreverClube(ActionEvent event){
        System.out.println("---------------------------------Inscrever Clube-------------------------------------------------------");
    }
    public  void btnCriarProva(ActionEvent event){
        System.out.println("---------------------------------Criar Prova-------------------------------------------------------");
    }
    public  void btnInscreverAtleta(ActionEvent event){
        System.out.println("---------------------------------Inscrever Atleta-------------------------------------------------------");
    }
}

