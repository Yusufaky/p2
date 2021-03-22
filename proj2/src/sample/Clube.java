package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clube {

    private int id_clube;
    private String nome;
    private String localizacao;
    private String n_atletas;


    Clube() {
    }

    public int getId_clube() {
        return id_clube;
    }

    public void setId_clube(int id_clube) {
        this.id_clube = id_clube;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getN_atletas() {
        return n_atletas;
    }

    public void setN_atletas(String n_atletas) {
        this.n_atletas = n_atletas;
    }


    //GOOD
    public void create() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO clube nome, localizacao, n_atletas VALUES(?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.nome);
            st.setString(2, this.localizacao);
            st.setString(3, this.n_atletas);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public void read(int id_clube) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT nome, localizacao, n_atletas FROM clube WHERE id_clube = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, id_clube);


            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.id_clube = id_clube;
                if (rs.getString("NOME") != null) this.nome = rs.getString("NOME");
                else this.nome = "";
                //
                if (rs.getString("Localizacao") != null) this.localizacao = rs.getString("MORADA");
                else this.localizacao = "";
                if (rs.getString("Numero de Atletas") != null) this.n_atletas = rs.getString("Numero de Atletas");
                else this.n_atletas = "";
            } else {
                System.out.println("ERRO: Não existe Clubes com o ID definido ");
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Clube> readAll() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_clube, nome, localizacao, n_atletas FROM clube";

        List<Clube> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Clube cli = new Clube();

                cli.setId_clube(rs.getInt("id_clube"));
                if (rs.getString("nome") != null) cli.setNome(rs.getString("nome"));
                //
                if (rs.getString("localizacao") != null) cli.setLocalizacao(rs.getString("localizacao"));
                //
                if (rs.getString("n_atletas") != null) cli.setN_atletas(rs.getString("n_atletas"));

                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public static List<Clube> readAll(String nome) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_clube, nome, localizacao, n_atletas FROM clube WHERE NOME LIKE ?";

        List<Clube> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, "%" + nome + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Clube cli = new Clube();

                cli.setId_clube(rs.getInt("id_clube"));
                if (rs.getString("nome") != null) cli.setNome(rs.getString("nome"));
                //
                if (rs.getString("localizacao") != null) cli.setLocalizacao(rs.getString("localizacao"));
                //
                if (rs.getString("n_atletas") != null) cli.setN_atletas(rs.getString("n_atletas"));

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

        String sqlCommand = "UPDATE clube SET nome = ?, localizacao = ?, n_atletas = ? WHERE id_clube = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.nome);
            st.setString(2, this.localizacao);
            st.setString(3, this.n_atletas);
            st.setInt(4, this.id_clube);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    //GOOD
    public void delete() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "DELETE clube WHERE id_clube = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_clube);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
