/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapplication;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Dave
 */
public class FXMLDocumentController implements Initializable {
    static final String API_PROVIDER = "http://api.openweathermap.org/data/2.5/weather?q=";
    static final String API_KEY      = "&appid=06f067c1a6009b76f68f104080331dfb";
    JSONObject jSONObject;
    Image image;
    FileInputStream input;
    @FXML
    private TextField countryField;
    @FXML
    private TextField cityField;
    @FXML
    private Label countryCodeLabel;
    @FXML
    private Label coorLabel;
    @FXML
    private Label weatherIDLabel;
    @FXML
    private Label tempLabel;
    @FXML
    private Label rainDescriptionLabel;
    @FXML
    private ImageView imageID;
    @FXML
    private Label mainWeatherLabel;
    @FXML
    private Label descriptionWeatherLabel;
    @FXML
    private Label iconWeatherLabel;
    @FXML
    private Label tempratureLabel;
    @FXML
    private Label pressureLable;
    @FXML
    private Label humidityLabel;
    @FXML
    private Label minTempLabel;
    @FXML
    private Label maxTemoLabel;
    @FXML
    private Label windLabel;
    @FXML
    private Label speedLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getJsonData(ActionEvent event) {
        String result = "";
        try {
            URL url = new URL(API_PROVIDER + countryField.getText()+","+cityField.getText()+
                    API_KEY);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if(httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK){
                Alerts.displayConnectionSuccess();
                
                InputStreamReader inputStreamReader = new 
                          InputStreamReader(httpURLConnection.getInputStream());
                
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader,8192);
                
                String line = null;
                while ((line = bufferedReader.readLine()) !=null) {                    
                    result +=line;
                }
                bufferedReader.close();
                
                /********* show everything here ******/
                String parsedResult = "";
                jSONObject = new JSONObject(result);
                parsedResult += "Number of objects = "+ jSONObject.length()+"\n\n";
                
                // "coord"
                JSONObject jSONObject_coord = jSONObject.getJSONObject("coord");
                Double result_lon = jSONObject_coord.getDouble("lon");
                Double result_lat = jSONObject_coord.getDouble("lat");
                String result_lonsString = Double.toString(result_lon);
                String result_latsString = Double.toString(result_lat);
                coorLabel.setText("Coord:" + " Longitude: "+result_lonsString + 
                                  " " +"Latitude: "+ result_latsString);
                // "weather"
                String result_weather;
                JSONArray JSONArray_weather = jSONObject.getJSONArray("weather");
                if(JSONArray_weather.length() >0){
                    JSONObject JSONObject_weather = JSONArray_weather.getJSONObject(0);
                    int result_id = JSONObject_weather.getInt("id");
                    String result_main = JSONObject_weather.getString("main");
                    String result_description = JSONObject_weather.getString("description");
                    String result_icon = JSONObject_weather.getString("icon");
                    result_weather = "weather\tid: " + result_id +"\tmain: " + 
                                     result_main + "\tdescription: " + result_description 
                                     + "\ticon: " + result_icon;
                    weatherIDLabel.setText("WeatherId: " + result_id);
                    mainWeatherLabel.setText("Main: " + result_main);
                    descriptionWeatherLabel.setText("Description: " + result_description);
                    iconWeatherLabel.setText("Icon: " + result_icon); 
                    input = new FileInputStream("/Users/Dave/Desktop/WeaterApplication/WeatherApplication/WeatherApplication/resources/sunny.png");
                    image = new Image(input);
                    imageID.setImage(image);
                    
                }else{
                    Alerts.displayWeatherError();
                }
                // "base"
                String result_base = jSONObject.getString("base");
                
                // main
                JSONObject JSONObject_main = jSONObject.getJSONObject("main");
                Double result_temp = JSONObject_main.getDouble("temp");
                Double result_pressure = JSONObject_main.getDouble("pressure");
                Double result_humidity = JSONObject_main.getDouble("humidity");
                Double result_temp_min = JSONObject_main.getDouble("temp_min");
                Double result_temp_max = JSONObject_main.getDouble("temp_max");
                tempratureLabel.setText("Temprature: "+Double.toString(result_temp)+"F°");
                pressureLable.setText("Pressure: "+Double.toString(result_pressure));
                humidityLabel.setText("Humidity: "+Double.toString(result_humidity));
                minTempLabel.setText("Min Temp: "+Double.toString(result_temp_min)+"F°");
                maxTemoLabel.setText("Max Temp: "+Double.toString(result_temp_max)+"F°");
                
                //"wind"
                JSONObject JSONObject_wind = jSONObject.getJSONObject("wind");
                Double result_speed = JSONObject_wind.getDouble("speed");
                windLabel.setText("Wind: "+Double.toString(result_speed)+"km/hr");
                //Double result_gust = JSONObject_wind.getDouble("gust");
//                Double result_deg = JSONObject_wind.getDouble("deg");
//                String result_wind = "wind\tspeed: " + result_speed + "\tdeg: " + result_deg;
            }else{
                Alerts.displayError();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
