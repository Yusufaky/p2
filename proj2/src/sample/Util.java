
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
                Class.forName("http://127.0.0.1:63572/browser/");
            } catch (ClassNotFoundException e) {
                System.out.println("Oops! Can't find class");
                System.exit(-1);
            }

            try {
                conn = DriverManager.getConnection(
                        "http://127.0.0.1:63572/browser/", "root", "1");
            } catch (Exception e) {
                System.out.println("ERRO " + e.getMessage());
                System.exit(-2);
            }

            return conn;
        }
    }

}
