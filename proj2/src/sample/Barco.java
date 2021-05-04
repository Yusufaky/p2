package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Barco {
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
            // System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }
}
