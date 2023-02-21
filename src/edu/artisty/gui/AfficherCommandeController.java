package edu.artisty.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Date;

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
    private Label userid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setMethPaiment(String meth_paiment) {
        this.meth_paiment.setText(meth_paiment);
    }

    public void setIdProduit(int idproduit) {
        this.idproduit.setText(Integer.toString(idproduit));
    }

    public void setPrix_Tot(int prix_tot) {
        this.prix_tot.setText(Integer.toString(prix_tot));
    }

    public void setDateCreation(Date date) {
        this.date.setText(date.toString());
    }

    void setuserid(int userid) {
            this.userid.setText(Integer.toString(userid));   

 
    }


}
