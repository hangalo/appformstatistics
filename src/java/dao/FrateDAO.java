/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbcutil.DBConnection;
import model.Frate;

/**
 *
 * @author informatica
 */
public class FrateDAO {

    private static final String INSERT = "INSERT INTO frate` (nomen, cognomen, oppidum_et_natio, dioecesis, patris, matris, nativ, vest, p_temp, ID_Circoscrizione) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void save(Frate frate) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (frate == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, frate.getNomen());
            ps.setString(2, frate.getCognomen());
            ps.setString(3, frate.getOppidum_et_natio());
            ps.setString(4, frate.getDioecesis());
            ps.setString(5, frate.getPatris());
            ps.setString(6, frate.getMatris());
            ps.setDate(7, new java.sql.Date(frate.getNativ().getTime()));
            ps.setDate(8, new java.sql.Date(frate.getVest().getTime()));
            ps.setDate(9, new java.sql.Date(frate.getProfTemp().getTime()));
            ps.setInt(10, frate.getIdCircoscrizione().getIdCircoscrizione());
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn, ps);
        }
    }
}
