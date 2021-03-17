package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaBarco {

    private int id_catbarco;
    private String nome;

    CategoriaBarco() {
    }

    public int getId_categoriaBarco() {
        return id_catbarco;
    }

    public void setId_categoriaBarco(int id_catbarco) {
        this.id_catbarco = id_catbarco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //GOOD
    public void create() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO catbarco nome VALUES(?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.nome);
            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public void read(int id_catbarco) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT nome FROM catbarco WHERE id_catbarco = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, id_catbarco);


            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.id_catbarco = id_catbarco;
                if (rs.getString("NOME") != null) this.nome = rs.getString("NOME");
                else this.nome = "";
            } else {
                System.out.println("ERRO: Não existe essa categoria com o ID definido ");
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<CategoriaBarco> readAll() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_catbarco, nome, localizacao, n_atletas FROM catbarco";

        List<CategoriaBarco> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                CategoriaBarco cli = new CategoriaBarco();

                cli.setId_categoriaBarco(rs.getInt("id_catbarco"));
                if (rs.getString("nome") != null) cli.setNome(rs.getString("nome"));
                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public static List<CategoriaBarco> readAll(String nome) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_catbarco, nome FROM catbarco WHERE NOME LIKE ?";

        List<CategoriaBarco> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, "%" + nome + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                CategoriaBarco cli = new CategoriaBarco();

                cli.setId_categoriaBarco(rs.getInt("id_catbarco"));
                if (rs.getString("nome") != null) cli.setNome(rs.getString("nome"));
                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    //GOOD
    public void update() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "UPDATE catbarco SET nome = ? WHERE id_catbarco = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.nome);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    //GOOD
    public void delete() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "DELETE catBarco WHERE id_catBarco = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_catbarco);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
