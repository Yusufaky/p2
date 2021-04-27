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
    private String nome;



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
    public String getNome() {
        return nome;
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

    public void setNome(String nome) {
        this.nome = nome; }

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

        String sqlCommand = "SELECT resultado.id_resultado, resultado.classificacao, resultado.id_prova, resultado.id_atleta, atleta.nome FROM resultado INNER JOIN atleta on resultado.id_atleta = atleta.id_atleta ";


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
                if (rs.getString("nome") != null) cli.setNome(rs.getString("nome"));

                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
    public static List<Resultados> federacao() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_federacao, nome FROM federacao";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_federacao"));
                if (rs.getString("nome") != null) cli.setClassificacao(rs.getString("nome"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
    public static List<Resultados> prova() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT prova.id_prova, prova.id_catprova, catprova.distancia FROM prova INNER JOIN catprova on prova.id_catprova = catprova.id_catprova";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_prova"));
                if (rs.getString("distancia") != null) cli.setClassificacao(rs.getString("distancia"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }    public static List<Resultados> alteta() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT atleta.id_atleta, atleta.nome FROM atleta";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_atleta"));
                if (rs.getString("nome") != null) cli.setClassificacao(rs.getString("nome"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
    public static List<Resultados> barco() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT barco.id_barco, barco.id_catbarco , catbarco.nome FROM barco INNER JOIN catbarco ON barco.id_catbarco= catbarco.id_catbarco ";



        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_barco"));
                if (rs.getString("nome") != null) cli.setClassificacao(rs.getString("nome"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
    public static List<Resultados> categoria() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_catprova, distancia , descricao FROM catprova";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_catprova"));
                if (rs.getString("descricao") != null) cli.setClassificacao(rs.getString("descricao"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public static boolean insert(String federacao, String categoria,String ano,String mes,String dias, String horas) {
        Connection conn = Util.criarConexao();

        String sqlCat = "SELECT id_catprova FROM catprova where descricao = ? ";
        String sqlFed = "SELECT id_federacao FROM federacao where nome = ?  ";
        String sqlInsert =  "INSERT INTO prova (id_catprova, id_federacao, hora, datadia)  values ( ?, ?, ?,?)";

        boolean inserido = true;

        try {
            PreparedStatement stf = conn.prepareStatement(sqlFed);
            stf.setString(1, federacao);
            PreparedStatement stc = conn.prepareStatement(sqlCat);
            stc.setString(1, categoria);

            ResultSet rsf = stf.executeQuery();
            ResultSet rsc = stc.executeQuery();

            while (rsf.next()) {
                int fed_id = rsf.getInt("id_federacao");


                System.out.println("Teste id_ federacap:"  + fed_id);
            }
            while (rsc.next()) {
                  int cat_id = rsc.getInt("id_catprova");


                System.out.println("Teste id_cat:"  + cat_id);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        String data= ano +"-"+mes+"-"+dias;
        //System.out.println("ERRO: "+data);
       int teste = 1;
        int teste1 = 1;
        try {
            PreparedStatement sti = conn.prepareStatement(sqlInsert);
            sti.setInt(1, teste);
            sti.setInt(2, teste1);
            sti.setString(3, horas);
            sti.setString(4, data);
            sti.executeUpdate();






        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            inserido = false;
        }

        System.out.println(" isnert: " +federacao + " "+ categoria+ " "+data+" " + horas);

        return inserido;
    }
    //ADICIONAR RESULTADOS
    /*public static boolean insertResultado(String atleta, String prova,String tempo,String barco,String classificacao) {
        Connection conn = Util.criarConexao();

        String sqlProv = "SELECT prova.id_prova FROM prova INNER JOIN catprova on prova.id_catprova = catprova.id_catprova";
        String sqlAtl = "SELECT id_atleta FROM atleta where nome = ?  ";
        String sqlInsert =  "INSERT INTO resultado (classificacao, id_prova, id_atleta)  values ( ?, ?, ?)";

        boolean inserido = true;

        try {
            PreparedStatement stf = conn.prepareStatement(sqlAtl);
            stf.setString(1, atleta);
            PreparedStatement stc = conn.prepareStatement(sqlProv);
            stc.setString(1, prova);

            ResultSet rsf = stf.executeQuery();
            ResultSet rsc = stc.executeQuery();

            while (rsf.next()) {
                int atleta_id = rsf.getInt("id_atleta");


                System.out.println("Teste id_ id_atleta:"  + atleta_id);
            }
            while (rsc.next()) {
                  int prova_id = rsc.getInt("id_prova");


                System.out.println("Teste id_prova:"  + prova_id);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        //System.out.println("ERRO: "+data);
       int teste = 1;
        int teste1 = 1;
        try {
            PreparedStatement sti = conn.prepareStatement(sqlInsert);
            sti.setInt(1, teste);
            sti.setInt(2, teste1);
            sti.setString(3, classificacao);
            sti.executeUpdate();



        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            inserido = false;
        }

        //System.out.println(" isnert: " +sqlAtl + " "+prova+ " "+tempo+" " + barco+ " "+ classificacao);

        return inserido;
    }*/ //ADICIONAR RESULTADOS
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
