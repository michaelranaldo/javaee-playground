/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.ranaldo.javaeeplayground.jsonp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.Part;

/**
 * 
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named("fileUploadBackingBean")
@RequestScoped
public class fileuploadBackingBean {
    private Part file;
    private String text;
    private String parsedText;
    
    /**
     * Upload the file from the form, stick it here
     */
    public void upload() {
        if (file != null) {
            try {
                InputStream inputStream = file.getInputStream();
                text = new Scanner(inputStream).useDelimiter("\\A").next();
            } catch (IOException ex) {
                System.out.println("Argh, " + ex.getMessage());
            }
        }
    }
    
    /**
     * Using the magic, read in our json object and spit it out as clean test
     */
    public void convertTextFromJSON() {
        try {
            JsonReader jsonReader = Json.createReader(file.getInputStream());
            JsonObject jobj = jsonReader.readObject();
            parsedText = jobj.toString();
        } catch (IOException ex) {
            Logger.getLogger(fileuploadBackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParsedText() {
        return parsedText;
    }

    public void setParsedText(String parsedText) {
        this.parsedText = parsedText;
    }
}

