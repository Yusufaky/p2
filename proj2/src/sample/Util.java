
package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    private static Connection conn = null;

    public static Connection criarConexao() {

        if (conn != null) {
            return conn;
        } else {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:postgresql:127.0.0.1:63572/browser/", "", "1");
            } catch (Exception e) {
                System.out.println("ERRO " + e.getMessage());
                System.exit(-2);
            }

            return conn;
        }
    }

}
