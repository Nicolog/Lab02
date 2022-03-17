package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import it.polito.tdp.alien.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Dizionario model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btmClear;

    @FXML
    private Button btmTranslate;

    @FXML
    private TextArea txtDizionario;

    @FXML
    private TextField txtTesto;


    @FXML
    void handleTranslate(ActionEvent event) {
    	
    	String testo = txtTesto.getText().toLowerCase();
    	String alphaRegex = "[a-zA-Z]*";	
    	String nospace = testo.replace(" ", "");
    	
    	if(!nospace.matches(alphaRegex)) {
    		txtDizionario.setText("ERRORE");
    		return;
    	}
    	
    	if(!testo.contains(" ")) {
    		LinkedList<String> l = new LinkedList<String>(model.search(testo));
    		String s= "";
    		for(String ss: l)
    			s+= ss+"; ";
    		
    		txtDizionario.setText(s);
    		return;
    	}
    	
    	String array[] = testo.split(" ");
    	if(array.length==2) {
    		Parola p;
    		if(!model.getDizionario().containsKey(array[0])) {
    			p = new Parola(array[0]);
    			p.getTraduzioni().add(array[1]);
    			model.add(p);
    		}
    		else
    			model.getDizionario().get(array[0]).getTraduzioni().add(array[1]);
    	
    	} else {
    		txtDizionario.setText("ERRORE");
    		return;
    	}
    	
    	
    	
    }
    
     @FXML
    void handleClearText(ActionEvent event) {

    }
     
    public void setModel(Dizionario model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmTranslate != null : "fx:id=\"btmTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
