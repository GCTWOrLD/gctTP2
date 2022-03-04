package com.tp1.persistence;

import com.tp1.model.Livre;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import java.sql.*;

public class JBDCLibrairie {

    private static final String DB_URL = "jdbc:h2:~/TP1Javatown";

    private static final String USER = "sa";
    private static final String PASS = "";

    private static Connection connection = null;
    private static Statement stmt = null;

    public static void createDatabase() {
        try {
            System.out.println("Connexion a la base de donnees...");
            connection = ConnectionH2.getConnection();

            System.out.println("Creation de la table dans la base de donnees...");
            stmt = connection.createStatement();
            String sql =  "CREATE TABLE   Livres " +
                    "(id INTEGER not NULL, " +
                    " Titre VARCHAR(255), " +
                    " Auteur VARCHAR(255), " +
                    " Annee INTEGER, " +
                    " Editeur VARCHAR(255), " +
                    " Genre VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Table cree dans la base de donnees...");

            stmt.close();
            connection.close();
        } catch(JdbcSQLSyntaxErrorException e) {
            handleException(e);
        } catch(SQLException se) {
            handleException(se);
        } catch(Exception e) {
            handleException(e);
        } finally {
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(connection!=null) connection.close();
            } catch(SQLException se){
                handleException(se);
            }
        }
    }

    public static void dropTable() {
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement();
        ) {
            String sql = "DROP TABLE Livres";
            stmt.executeUpdate(sql);
            System.out.println("Suppression de la table...");
        } catch (SQLException e) {
            handleException(e);
        }
    }

    public static Livre getLivre(int id) {
        Connection connection = ConnectionH2.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Livres WHERE Id=" + id);

            if(rs.next()) {
                Livre livre = new Livre();
                livre.setId(rs.getInt("Id"));
                livre.setTitre(rs.getString("Titre"));
                livre.setAuteur(rs.getString("Auteur"));
                livre.setAnnee(rs.getInt("Annee"));
                livre.setEditeur(rs.getString("Editeur"));
                livre.setGenre(rs.getString("Genre"));

                return livre;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return null;
    }

    public static boolean insertLivre(Livre livre) {
        Connection connection = ConnectionH2.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Livres VALUES (?,?,?,?,?,?)");
            ps.setInt(1, livre.getId());
            ps.setString(2, livre.getTitre());
            ps.setString(3, livre.getAuteur());
            ps.setInt(4, livre.getAnnee());
            ps.setString(5, livre.getEditeur());
            ps.setString(6, livre.getGenre());
            int i = ps.executeUpdate();
            System.out.println("Le livre a ete ajoute dans la table...");
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.println("Stacktrace: ");
        exception.printStackTrace();
    }
}
