package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Federacao {

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

}
