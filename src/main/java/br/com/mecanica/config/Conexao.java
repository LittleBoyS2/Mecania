<<<<<<< HEAD
package br.com.mecanica.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3307/mecanica?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
=======
package config;

public class Conexao {
}
>>>>>>> 8d9e572fe163169de2b9a9a897dd5cf79d506a58
