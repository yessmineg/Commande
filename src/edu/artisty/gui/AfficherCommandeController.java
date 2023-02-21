package edu.artisty.gui;

import edu.artisty.entities.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * This class is responsible for displaying details about a customer's order.
 */
public class AfficherCommandeController implements Initializable {

    @FXML 
    private Label meth_paiment;
    @FXML 
    private Label idproduit;
    @FXML
    private Label prix_tot;
    @FXML
    private Label date;
    @FXML
    private Label userid;
    @FXML
    private Button OK;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMeth_Paiment(String meth_paiment) {
        this.meth_paiment.setText(meth_paiment);
    }

    public void setIdProduit(int idproduit) {
        this.idproduit.setText(Integer.toString(idproduit));
    }

    public void setPrix_Tot(int prix_tot) {
        this.prix_tot.setText(Integer.toString(prix_tot));
    }

    public void setDateCreation(String date) {
        this.date.setText(date);
    }

    void setuserid(int userid) {
    this.userid.setText(Integer.toString(userid));  
            
    }          


}
