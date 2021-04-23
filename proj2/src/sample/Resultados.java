package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Resultados {

    private int id_resultado;
    private String Classificacao;
    private int id_prova;
    private int id_atleta;


    Resultados() {
    }

    public int getId_Resultado() {
        return id_resultado;
    }

    public String getClassificacao() {
        return Classificacao;
    }

    public int getId_prova() {
        return id_prova;
    }

    public int getId_atleta() {
        return id_atleta;
    }

    public void setId_Resultado(int id_resultados) {
        this.id_resultado = id_resultados;
    }

    public void setClassificacao(String classificacao) {
        Classificacao = classificacao;
    }

    public void setId_prova(int id_prova) {
        this.id_prova = id_prova;
    }

    public void setId_atleta(int id_atleta) {
        this.id_atleta = id_atleta;
    }

  /*  //GOOD
    public void create() {
        // PreparedStatement
        Connection conn = Util.criarConexao();

        String sqlCommand = "INSERT INTO resultados classificacao, id_prova, id_atleta VALUES(?, ?, ?)";

    }

    public void read(int id_clube) {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT nome, localizacao, n_atletas FROM clube WHERE id_clube = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, id_clube);


            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                this.id_resultados = id_resultados;
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
    }*/

    public static List<Resultados> readAll() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_resultado, classificacao, id_prova, id_atleta FROM resultado";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_resultado"));
                if (rs.getString("classificacao") != null) cli.setClassificacao(rs.getString("classificacao"));
                //
                if (rs.getString("id_prova") != null) cli.setId_prova(rs.getInt("id_prova"));
                //
                if (rs.getString("id_atleta") != null) cli.setId_atleta(rs.getInt("id_atleta"));

                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

   /* //GOOD
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
    }*/
}
