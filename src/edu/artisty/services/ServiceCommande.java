/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisty.services;

import edu.artisty.entities.Commande;
import edu.artisty.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yessmine
 */
public class ServiceCommande implements IService<Commande> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
      public void ajouter(Commande c) {
        try {
            String req = "INSERT INTO `commande` ( `prix_tot`, `userid`, `payment`) VALUES ('"+c.getPrix_tot()+"', '"+c.getuserid()+"','"+c.getPayment()+"')" ;
             Statement st = cnx.createStatement();
             st.executeUpdate(req);
          System.out.println("commande ajoutée !");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `commande` WHERE `idproduit` = ?" ;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commande supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commande c) {
        try {
       //     String req = "UPDATE `commande` SET `payment` = ? WHERE `idproduit` = ?";
            //String req = "UPDATE collection SET nom_col`='" + t.getNom_col() + "',id_p`='" + t.getId_p() + "',`nom_p`='" + t.getNom_p() + "' WHERE `id_col`= '" + t.getId_col() + "';";
         //   PreparedStatement ps = cnx.prepareStatement(req);
          //  ps.setString(1, c.getPayment());
           // ps.setInt(2, c.getId());
            //ps.executeUpdate();
            //System.out.println("Commande updated !");
        //} catch (SQLException ex) {
          //  System.out.println(ex.getMessage());
          
        String req = "UPDATE commande SET `prix_tot` = '" + c.getPrix_tot()+ "',`userid`='" + c.getuserid()+ "',`payment`='" + c.getPayment()+ "' WHERE `idproduit`= '" + 1+ "';";

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne updated successfully !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
           

    @Override
    public List<Commande> getAll() {
        List<Commande> list = new ArrayList<>();
        try {
            String req = "Select * from `Commande`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
            Commande c = new Commande(rs.getInt("idproduit"), rs.getInt("prix_tot"), rs.getInt("userid"), rs.getString("payment"), rs.getDate("date_creation"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Commande getOneById(int idproduit) {
        Commande c = null;
        try {
            String req = "SELECT * FROM `commande` WHERE `idproduit` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idproduit);
            ResultSet rs = ps.executeQuery();

            while (rs.next() )
                c = new Commande (rs.getInt("id"),rs.getInt("prix_tot"),rs.getInt("userid"));
            System.out.println(c);
            
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

     
    @Override
     public String afficher (int idproduit, int prix_tot, int userid, String payment, Date date_creation) {
         String s;
        return s =" Votre Commande classée qui a comme id" + idproduit + "coute" + prix_tot + "pour l'utlilisateur dont l'id est" + userid + "et il va payer par" + payment + "le" + date_creation + '}';
    }
}

    
