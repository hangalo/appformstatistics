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
import java.util.ArrayList;
import java.util.List;
import jdbcutil.DBConnection;
import model.Circoscrizioni;
import model.Frate;
import model.StatisticaOrdinis;

/**
 *
 * @author informatica
 */
public class FrateDAO {

    private static final String INSERT = "INSERT INTO frate (nomen, cognomen, oppidum, dioecesis, patris, matris, nativ, vest, p_temp, ID_Circoscrizione, ID_Nazione) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String LIST_BY_CIRCOSCRIZIONE = "SELECT id_frate, nomen, cognomen, oppidum, dioecesis, patris, matris, nativ, vest, p_temp, ID_Circoscrizione, ID_Nazione FROM frate WHERE ID_Circoscrizione = ?";

    public void save(Frate frate) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (frate == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(INSERT);
            /*
            1 -nomen, 
            2- cognomen, 
            3- oppidum, 
            4- dioecesis, 
            5- patris, 
            6- matris, 
            7 - nativ, 
            8 - vest, 
            9 - p_temp, 
            10 - ID_Circoscrizione, 
            11- ID_Nazione
            */
            System.out.println(">>>>>>>>>>>>>>>>>>>> 00"+frate.getProfTemp());
//            System.out.println(">>>>>>>>>\n>>>>>>>>>>>01 "+frate.getIdCircoscrizione().getIdCircoscrizione());
            ps.setString(1, frate.getNomen());
            ps.setString(2, frate.getCognomen());
            ps.setString(3, frate.getOppidum());
            ps.setString(4, frate.getDioecesis());
            ps.setString(5, frate.getPatris());
            ps.setString(6, frate.getMatris());
            ps.setDate(7, new java.sql.Date(frate.getNativ().getTime()));
            ps.setDate(8, new java.sql.Date(frate.getVest().getTime()));
            ps.setDate(9, new java.sql.Date(frate.getProfTemp().getTime()));
            ps.setInt(10, frate.getIdCircoscrizione().getIdCircoscrizione());
            ps.setInt(11, frate.getNazione().getIdNazione());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn, ps);
        }
    }

    
    public List<Frate> findFrateByCircoDomicilio(Integer circoDomicilio) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Frate> frates = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(LIST_BY_CIRCOSCRIZIONE);
            ps.setInt(1, circoDomicilio);
            rs = ps.executeQuery();
            while (rs.next()) {
                Frate frate = new Frate();
                fillData(frate, rs);
                frates.add(frate);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return frates;
    }
    
    private void fillData(Frate frate, ResultSet rs) {
        try {
        
            
         //   Circoscrizioni c = new Circoscrizioni();
       //     c.setNomeLatino(rs.getString("c.Nome_latino"));
            
            frate.setIdFrate(rs.getInt("id_frate"));
            frate.setNomen(rs.getString("nomen"));
            frate.setCognomen(rs.getString("cognomen"));
            frate.setOppidum(rs.getString("oppidum"));
            frate.setDioecesis(rs.getString("dioecesis"));

            frate.setPatris(rs.getString("patris"));
            frate.setMatris(rs.getString("matris"));

            frate.setNativ(rs.getDate("nativ"));
            frate.setVest(rs.getDate("vest"));
            frate.setProfTemp(rs.getDate("p_temp"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

    private void fillDataCircoscrizioni(Circoscrizioni circoscrizioni, ResultSet rs) {
        try {
            circoscrizioni.setIdCircoscrizione(rs.getInt(1));
            circoscrizioni.setNomeItaliano(rs.getString(2));
            circoscrizioni.setNomeLatino(rs.getString(3));

        } catch (SQLException ex) {
            System.err.println("Error:fillDataCircoscrizioni: " + ex.getLocalizedMessage());
        }
    }

}
