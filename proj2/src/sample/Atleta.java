package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Atleta {
    public static List<Resultados> alteta() {
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
            // System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
}
