/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisty.entities;
import java.util.Date;

/**
 *
 * @author yessmine
 */
public class Commande {
    private int idproduit, prix_tot, userid;
    private String payment ; 
    private Date date_creation ;

    public Commande() {
    }
    
    public  Commande(int prix_tot, int userid, String payment) {
        this.prix_tot = prix_tot ;
        this.userid= userid;
        this.payment= payment;
    }
    

    public  Commande(int idproduit, int prix_tot, int userid, String payment, Date date_creation) {
        this.idproduit = idproduit;
        this.prix_tot = prix_tot;
        this.userid = userid;
        this.payment= payment;
        this.date_creation = date_creation;
        
    }

    public Commande(int idproduit, int prix_tot, int userid) {
        this.idproduit = idproduit;
        this.prix_tot = prix_tot;
        this.userid = userid;    }

    public Commande(int userid, String payment) {
        this.userid=userid;
        this.payment=payment;
    }

    public Commande(int idproduit, int prix_tot, int userid, String payment) {
        this.idproduit = idproduit;
        this.prix_tot = prix_tot;
        this.userid = userid;
        this.payment= payment;
    }



    public int getId() {
        return idproduit;
    }

    public int getPrix_tot() {
        return prix_tot;
    }

    public String getPayment() {
        return payment;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    

    public int getuserid() {
        return userid;
    }

    public void setId(int idproduit) {
        this.idproduit = idproduit;
    }

    public void setPrix_tot(int prix_tot) {
        this.prix_tot = prix_tot;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }


    @Override
    public String toString() {
        return "Commande{" + "idproduit=" + idproduit + ", prix_tot=" + prix_tot + ", userid=" + userid + ", payment=" + payment + ", date_creation=" + date_creation + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (this.idproduit != other.idproduit) {
            return false;
        }
        return true;
    }
    
}
