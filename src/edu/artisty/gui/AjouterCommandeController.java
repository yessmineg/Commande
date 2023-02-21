/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisty.gui;

import edu.artisty.services.ServiceCommande;
import edu.artisty.entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;



       /**
 * FXML Controller class
 *
 * @author 
 */
public class AjouterCommandeController implements Initializable {
@FXML
    private TextField tfuserid;
@FXML 
    private Label meth_paiment; 
    private Label idproduit;
    private Label prix_tot;

@FXML 
    private ChoiceBox <String> ChoiceBox;
    private final String [] paying_with ={"cash","Card"};
 @FXML
    private DatePicker DatePicker;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    @FXML
    private void AjouterCommande(ActionEvent event) throws IOException {
        
        if (tfuserid.getText().isEmpty() || !tfuserid.getText().trim().matches("\\d+") || prix_tot.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "votre id ou la méthode de paiment est invalide invalide(s)", ButtonType.OK);
            a.showAndWait();
        } else {
            try {
                ServiceCommande sc = new ServiceCommande();
                
                Commande c = new Commande( Integer.parseInt(tfuserid.getText()), prix_tot.getText());
                sc.ajouter(c);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Commande ajoutée !", ButtonType.OK);
                a.showAndWait();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCommande.fxml"));
                Parent root = loader.load();
                tfuserid.getScene().setRoot(root);
                
                AfficherCommandeController acc = loader.getController();
                acc.setuserid(Integer.parseInt(tfuserid.getText()));
                acc.setPrix_Tot(Integer.parseInt(prix_tot.getText()));
                
            } catch (NumberFormatException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
    
}
        ChoiceBox.getItems().addAll(paying_with);
    	ChoiceBox.setOnAction(this::getamount);
		
	}
	
	public void getamount(ActionEvent event) {
		
		String paying_with = ChoiceBox.getValue();
		meth_paiment.setText(paying_with);
	}
        

    
 public void setIdProduit(int idproduit) {
        this.idproduit.setText(Integer.toString(idproduit));
    }
    
    
    public void setPrix_tot(int prix_tot){
        this.prix_tot.setText(Integer.toString(prix_tot));
        
    }
}

    

