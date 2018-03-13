/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaterapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dave
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField countryField;
    @FXML
    private TextField cityField;
    @FXML
    private Label tempLabel;
    @FXML
    private Label humudityLabel;
    @FXML
    private Label pressureLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getJsonData(ActionEvent event) {
    }
    
}
