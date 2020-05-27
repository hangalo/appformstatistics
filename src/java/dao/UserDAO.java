/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbcutil.DBConnection;
import model.Circoscrizioni;
import model.User;

/**
 *
 * @author informatica
 */
public class UserDAO {

    String FINDUSER = "SELECT id_user, login, password, nome, cognome, c.id_circoscrizione, c.Nome_latino, c.Nome_Italiano FROM user u INNER JOIN circoscrizioni c ON u.id_circoscrizioni = c.ID_Circoscrizione WHERE login =? AND password = ?";
    // String FINDUSER = "SELECT id_user, login, password, nome, cognome FROM user  WHERE login = ? AND password = ?";

    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT id_user, login, password, nome, cognome, c.id_circoscrizione, c.Nome_latino, c.Nome_Italiano FROM user u INNER JOIN circoscrizioni c ON u.id_circoscrizioni = c.ID_Circoscrizione WHERE login =? AND password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection(con);
        }
        return false;
    }

    public User findUser(String username, String password) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        User user = new User();
        System.err.println(" User e pass: DAO\t" + username + ">>>>>>" + password);

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(FINDUSER);
            ps.setString(1, username);
            ps.setString(2, password);
            System.err.println("Passou: DAO >>>> 01");
            rs = ps.executeQuery();
            if (rs.next()) {
               fillData(user, rs);
            }
                     
        } catch (SQLException ex) {
            System.err.println("Error:UserDAO:findUser: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn, ps, rs);
        }

        return user;

    }

    private void fillData(User user, ResultSet rs) {

        Circoscrizioni circoscrizioni = new Circoscrizioni();
        try {
            user.setIdUser(rs.getInt("id_user"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setNome(rs.getString("nome"));
            user.setCognome(rs.getString("cognome"));
            circoscrizioni.setNomeLatino(rs.getString("c.Nome_latino"));
            circoscrizioni.setNomeItaliano(rs.getString("c.Nome_Italiano"));
            circoscrizioni.setIdCircoscrizione(rs.getInt("c.id_circoscrizione"));
            user.setCircoscrizioni(circoscrizioni);

        } catch (SQLException ex) {
            System.err.println("Error:UserDAO:fillData: " + ex.getLocalizedMessage());
        }

    }
}
