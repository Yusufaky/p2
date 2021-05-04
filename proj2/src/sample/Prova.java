package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prova {
    public static List<Resultados> prova() {
        Connection conn = Util.criarConexao();

        String sqlCommand = "SELECT id_prova, id_catprova, descricao FROM prova";


        List<Resultados> lista = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resultados cli = new Resultados();

                cli.setId_Resultado(rs.getInt("id_prova"));
                if (rs.getString("descricao") != null) cli.setClassificacao(rs.getString("descricao"));
                //


                lista.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
}
