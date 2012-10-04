/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SauProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thai
 */
public class JConnection {
    
        static Connection con = null;
        static PreparedStatement pst = null;
        static ResultSet rs = null;

        final static String url = "jdbc:mysql://mysql.stud.ntnu.no/tommno_sau";
        final static String user = "tommno_it1901";
        final static String password = "sau1901";
        
        
        public static void leggTilSau(String navn, int fodt, int beite, String kommentar){
            try {

                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement("INSERT INTO Sau(Navn,Foedt,beite_id) VALUES(?,?,?)");
                
                pst.setString(1, navn);
                pst.setInt(2, fodt);
                pst.setInt(3, beite);
                pst.executeUpdate();

            } catch (Exception ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {

                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (con != null) {
                        con.close();
                    }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
           
    }
        public static String hentBeite(){
            String beite = "";
            try {

                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement("SELECT Navn, ID FROM beite)");
                rs = pst.executeQuery();
                while (rs.next()) {
                    beite += rs.getString(1);
                    beite += " ";
                    beite += rs.getInt(2);
                    beite += "\n";
                
                 }

            } catch (Exception ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {

                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (con != null) {
                        con.close();
                    }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
            return beite;
    }
        public static String hentSau(int id){
            String sau = "";
            try {

                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement("SELECT Navn FROM Sau WHERE ID ="+id);
                rs = pst.executeQuery();
                
                while (rs.next()){ 
                    sau += "Id: ";
                    sau += id;
                    sau += " navn: ";
                    sau += rs.getString(1);
                
                 }

            } catch (Exception ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {

                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (con != null) {
                        con.close();
                    }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
            return sau;
    }
        public static void slettSau(int id){
            try {

                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement("DELETE FROM Sau WHERE ID=?");
                pst.setInt(1, id);
                pst.executeUpdate();

            } catch (Exception ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {

                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (con != null) {
                        con.close();
                    }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(JConnection.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
