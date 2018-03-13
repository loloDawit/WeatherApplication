/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapplication;

import javafx.scene.control.Alert;

/**
 *
 * @author Dave
 */
public class Alerts{
    public static Alert alert; 
    
    public Alerts(){
        
    }
    public static void displayConnectionSuccess(){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Connection to API is a success");
        alert.show();
    }
    public static void displayError(){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Connection to API is a success");
        alert.show();
    }
}
