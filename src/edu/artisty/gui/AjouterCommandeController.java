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
@FXML
    private TextField idproduit;
    @FXML
    private TextField prix_tot1;

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
        ChoiceBox.getItems().addAll(paying_with);
    	ChoiceBox.setOnAction(this::getamount);
        
        // TODO
    }
    	public void getamount(ActionEvent event) {
		
		String paying_with = ChoiceBox.getValue();
		meth_paiment.setText(paying_with);
	}

    @FXML
    private void AjouterCommande()  {
        System.out.println(tfuserid.getText());
        if (tfuserid.getText().isEmpty()  || prix_tot1.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "votre id est invalide invalide", ButtonType.OK);
           a.showAndWait();
        } 
            try {
                
                ServiceCommande sc = new ServiceCommande();
               int i=Integer.valueOf(tfuserid.getText());
               
                Commande c = new Commande( i,Integer.valueOf(prix_tot1.getText()));
                sc.ajouter(c);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Commande ajoutée !", ButtonType.OK);
                a.showAndWait();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCommande.fxml"));
                Parent root = loader.load();
                tfuserid.getScene().setRoot(root);
                
                AfficherCommandeController acc = loader.getController();
                acc.setuserid(Integer.valueOf(tfuserid.getText()));
                acc.setPrix_Tot(Integer.valueOf(prix_tot1.getText()));
                
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
    

	}

   

    
 public void setIdProduit(int idproduit) {
        this.idproduit.setText(Integer.toString(idproduit));
    }
    
    
    public void setPrix_tot(int prix_tot){
        this.prix_tot1.setText(Integer.toString(prix_tot));
        
    }
}

    

