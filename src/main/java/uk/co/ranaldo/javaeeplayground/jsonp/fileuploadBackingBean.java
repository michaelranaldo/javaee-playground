package uk.co.ranaldo.javaeeplayground.jsonp;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
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
 * Backing bean for the json-p demo. Delightfully simple to use - just create a field or method here and set the
 * action / method on the page.
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Named("fileUploadBackingBean")
@RequestScoped
public class fileuploadBackingBean {

    private Part file;
    private String text;
    private String formattedText;
    private String rawText;
    private String key;
    private String value;

    /**
     * Upload the file from the form, stick it here
     *
     */
    public void formatFile() {
        if (file != null) {
            try {
                InputStream inputStream = file.getInputStream();
                text = new Scanner(inputStream).useDelimiter("\\A").next();
            } catch (IOException ex) {
                System.out.println("Argh, " + ex.getMessage());
            }
        }
    }

    public void formatText() {
        if (rawText != null) {
            JsonReader jsonReader = Json.createReader(new StringReader(rawText));
            JsonObject jsonObject = jsonReader.readObject();
            formattedText = jsonObject.toString();
        }
    }

    /**
     * Using the magic, read in our json object and spit it out as clean test
     */
    public void convertTextFromJSON() {
        try {
            // Use JsonReader to read the stream
            JsonReader jsonReader = Json.createReader(file.getInputStream());
            // create an object from the stream
            JsonObject jsonObject = jsonReader.readObject();
            // print the object
            formattedText = jsonObject.toString();
        } catch (IOException ex) {
            Logger.getLogger(fileuploadBackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createJson() {
        JsonObject jsonObject = Json.createObjectBuilder().add(key, value).build();
        formattedText = jsonObject.toString();
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

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
