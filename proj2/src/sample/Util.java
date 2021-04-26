
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
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Oops! Can't find class org.postgresql.Driver");
                System.exit(-1);
            }

            try {
                conn = DriverManager.getConnection(
                        //p22021
                        "jdbc:postgresql://localhost:5432/P2", "postgres", "p22021");
            } catch (Exception e) {
                System.out.println("ERRO " + e.getMessage());
                System.exit(-2);
            }

            return conn;
        }
    }

}
