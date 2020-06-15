/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author informatica
 */
public class DBConnection {
/*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();*/
    public static Connection getConnection() {
        Connection con;
       // String driver = "com.mysql.jdbc.Driver";
       String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.0.105:3306/statistica?serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro na conexao com a base de dados: " + ex.getMessage());
            return null;
        }
        return con;
    }

    public static void closeConnection(Connection conn){
        close(conn, null, null);    
    }
    
     public static void closeConnection(Connection conn, PreparedStatement ps){
        close(conn, ps, null);    
    }
     
      public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        close(conn, ps, rs);    
    }
    
    
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            System.err.println("Error:getConnection:DBConnection "+ex.getMessage());
        }

    }

    /*
    public static void main(String[] args) {

        // creates three different Connection objects
        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        try {
            // connect way #1
            String url1 = "jdbc:mysql://192.168.0.105:3306/statistica";
            String user = "root";
            String password = "root";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

            // connect way #2
            String url2 = "jdbc:mysql://192.168.0.105:3306/statistica?user=root&password=root";
            conn2 = DriverManager.getConnection(url2);
            if (conn2 != null) {
                System.out.println("Connected to the database test2");
            }

            // connect way #3
            String url3 = "jdbc:mysql://192.168.0.105:3306/sigofmcap";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "root");

            conn3 = DriverManager.getConnection(url3, info);
            if (conn3 != null) {
                System.out.println("Connected to the database sigofmcap");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
*/
}
