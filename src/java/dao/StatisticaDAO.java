/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Circoscrizioni;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbcutil.DBConnection;
import model.StatisticaOrdinis;

/**
 *
 * @author informatica
 */
public class StatisticaDAO {

    //  String VIEW_ALL = "SELECT * FROM statistica_ordinis";
    String VIEW_ALL = "SELECT ID_Statistica, Anno,Corrente,ID_CircoDomicilio, c.Nome_latino, Tipo_Appartenenza, ID_CircoAppartenenza,"
            + " ID_Nazione,Domii, Episcopi, Sacerdoti_ProfPerp, Sacerdoti_ProfTemp,DiacPerm_ProfPerp,DiacPerm_ProfTemp,"
            + " DiacTrans_ProfPerp, DiacTrans_ProfTemp, Laici_ProfPerp, Laici_ProfTemp, Novicii, Postulantes, "
            + "Tertiarii_Perpetui, Seminaristi "
            + "FROM statistica_ordinis s INNER JOIN circoscrizioni c ON s.ID_CircoDomicilio = c.ID_Circoscrizione "
            + "LIMIT 20";

    String INSERT = "INSERT INTO statistica_ordinis(ID_Statistica, Anno, Corrente, ID_CircoDomicilio, Tipo_Appartenenza, ID_CircoAppartenenza, ID_Nazione, Domii, Episcopi, Sacerdoti_ProfPerp, Sacerdoti_ProfTemp, DiacPerm_ProfPerp, DiacPerm_ProfTemp, DiacTrans_ProfPerp,DiacTrans_ProfTemp,Laici_ProfPerp,Laici_ProfTemp,Novicii,Postulantes,Tertiarii_Perpetui,Seminaristi)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String VIEW_BY_ANNO_CIRCODOMICILIO= "SELECT ID_Statistica, Anno, Corrente,ID_CircoDomicilio, Tipo_Appartenenza, ID_CircoAppartenenza,"
            + " ID_Nazione,Domii, Episcopi, Sacerdoti_ProfPerp, Sacerdoti_ProfTemp,DiacPerm_ProfPerp,DiacPerm_ProfTemp,"
            + " DiacTrans_ProfPerp, DiacTrans_ProfTemp, Laici_ProfPerp, Laici_ProfTemp, Novicii, Postulantes, "
            + "Tertiarii_Perpetui, Seminaristi "
            + "FROM statistica_ordinis"
            + " WHERE Anno = ? AND ID_CircoDomicilio = ? ";
    
     String VIEW_BY_ANNO = "SELECT ID_Statistica, Anno, Corrente,ID_CircoDomicilio, Tipo_Appartenenza, ID_CircoAppartenenza,"
            + " ID_Nazione,Domii, Episcopi, Sacerdoti_ProfPerp, Sacerdoti_ProfTemp,DiacPerm_ProfPerp,DiacPerm_ProfTemp,"
            + " DiacTrans_ProfPerp, DiacTrans_ProfTemp, Laici_ProfPerp, Laici_ProfTemp, Novicii, Postulantes, "
            + "Tertiarii_Perpetui, Seminaristi "
            + "FROM statistica_ordinis"
            + " WHERE Anno = ? ";
    
     String VIEW_BY_CIRCODOMICILIO  = "SELECT ID_Statistica, Anno, Corrente,ID_CircoDomicilio, Tipo_Appartenenza, ID_CircoAppartenenza,"
            + " ID_Nazione,Domii, Episcopi, Sacerdoti_ProfPerp, Sacerdoti_ProfTemp,DiacPerm_ProfPerp,DiacPerm_ProfTemp,"
            + " DiacTrans_ProfPerp, DiacTrans_ProfTemp, Laici_ProfPerp, Laici_ProfTemp, Novicii, Postulantes, "
            + "Tertiarii_Perpetui, Seminaristi "
            + "FROM statistica_ordinis WHERE ID_CircoAppartenenza = ? ";

    String LIST_CIRCOSCRIZIONI = "SELECT ID_Circoscrizione, Nome_latino, Nome_Italiano FROM circoscrizioni WHERE Soppressa !=1 order by Nome_Italiano";

    public void save(StatisticaOrdinis st) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (st == null) {
            System.err.println("Value can't be null");
        }
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(INSERT);
           
            ps.setInt(1, st.getAnno());
            ps.setBoolean(2, st.getCorrente());
         //   ps.setInt(3, st.getIdCircoDomicilio());
            ps.setString(4, st.getTipoAppartenenza());
            ps.setInt(5, st.getiDCircoAppartenenza());
            ps.setInt(6, st.getIdNazione());
            ps.setInt(7, st.getDomii());
            ps.setInt(8, st.getEpiscopi());
            ps.setInt(9, st.getSacerdotiProfPerp());
            ps.setInt(10, st.getSacerdotiProfTemp());
            ps.setInt(11, st.getDiacPermProfPerp());
            ps.setInt(12, st.getDiacPermProfTemp());
            ps.setInt(13, st.getDiacTransProfPerp());
            ps.setInt(14, st.getDiacTransProfTemp());
            ps.setInt(15, st.getLaiciProfPerp());
            ps.setInt(16, st.getLaiciProfTemp());
            ps.setInt(17, st.getNovicii());
            ps.setInt(18, st.getPostulantes());
            ps.setInt(19, st.getTertiariiPerpetui());
            ps.setInt(20, st.getSeminaristi());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error:DAO:save: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn, ps);
        }
    }

    public List<StatisticaOrdinis> findByAnnoCircoDomicilio(Integer anno, Integer circoDomicilio) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<StatisticaOrdinis> statisticaOrdinis = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(VIEW_BY_ANNO_CIRCODOMICILIO);
            ps.setInt(1, anno);
            ps.setInt(2, circoDomicilio);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatisticaOrdinis statisticaOrdini = new StatisticaOrdinis();
                fillData(statisticaOrdini, rs);
                statisticaOrdinis.add(statisticaOrdini);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return statisticaOrdinis;
    }
    
    
     public List<StatisticaOrdinis> findByAnno(Integer anno) {
         
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<StatisticaOrdinis> statisticaOrdinis = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(VIEW_BY_ANNO);
            ps.setInt(1, anno);
              rs = ps.executeQuery();
            while (rs.next()) {
                StatisticaOrdinis statisticaOrdini = new StatisticaOrdinis();
                fillData(statisticaOrdini, rs);
                statisticaOrdinis.add(statisticaOrdini);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return statisticaOrdinis;
    }
    
    
     public List<StatisticaOrdinis> findByCircoDomicilio(Integer circoDomicilio) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<StatisticaOrdinis> statisticaOrdinis = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(VIEW_BY_CIRCODOMICILIO);
            ps.setInt(1, circoDomicilio);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatisticaOrdinis statisticaOrdini = new StatisticaOrdinis();
                fillData(statisticaOrdini, rs);
                statisticaOrdinis.add(statisticaOrdini);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return statisticaOrdinis;
    }


    public List<StatisticaOrdinis> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<StatisticaOrdinis> statisticaOrdinis = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(VIEW_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatisticaOrdinis statisticaOrdini = new StatisticaOrdinis();
                fillData(statisticaOrdini, rs);
                statisticaOrdinis.add(statisticaOrdini);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return statisticaOrdinis;
    }

    public List<Circoscrizioni> findAllCircoscrizioni() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Circoscrizioni> circoscrizionis = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(LIST_CIRCOSCRIZIONI);
            rs = ps.executeQuery();
            while (rs.next()) {
                Circoscrizioni circoscrizioni = new Circoscrizioni();
                fillDataCircoscrizioni(circoscrizioni, rs);
                circoscrizionis.add(circoscrizioni);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
        return circoscrizionis;
    }

    private void fillData(StatisticaOrdinis statistica, ResultSet rs) {
        try {
              
         
            
           // Circoscrizioni c = new Circoscrizioni();
         //   c.setNomeLatino(rs.getString("c.Nome_latino"));
            
            statistica.setIdStatistica(rs.getInt("ID_Statistica"));
            statistica.setAnno(rs.getInt("Anno"));
            statistica.setCorrente(rs.getBoolean("Corrente"));
          //  statistica.setCircoscrizioni(c);
            statistica.setTipoAppartenenza(rs.getString("Tipo_Appartenenza"));
            statistica.setiDCircoAppartenenza(rs.getInt("ID_CircoAppartenenza"));
            statistica.setIdNazione(rs.getInt("ID_Nazione"));
            statistica.setDomii(rs.getInt("Domii"));
            statistica.setEpiscopi(rs.getInt("Episcopi"));
            statistica.setSacerdotiProfPerp(rs.getInt("Sacerdoti_ProfPerp"));
            statistica.setSacerdotiProfTemp(rs.getInt("Sacerdoti_ProfTemp"));
            statistica.setDiacPermProfPerp(rs.getInt("DiacPerm_ProfPerp"));
            statistica.setDiacPermProfTemp(rs.getInt("DiacPerm_ProfTemp"));
            statistica.setDiacTransProfPerp(rs.getInt("DiacTrans_ProfPerp"));
            statistica.setDiacTransProfTemp(rs.getInt("DiacTrans_ProfTemp"));
            statistica.setLaiciProfPerp(rs.getInt("Laici_ProfPerp"));
            statistica.setLaiciProfTemp(rs.getInt("Laici_ProfTemp"));
            statistica.setNovicii(rs.getInt("Novicii"));
            statistica.setPostulantes(rs.getInt("Postulantes"));
            statistica.setTertiariiPerpetui(rs.getInt("Tertiarii_Perpetui"));
            statistica.setSeminaristi(rs.getInt("Seminaristi"));

            
          
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
