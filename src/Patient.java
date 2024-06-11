import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Patient {
    // Global Variables (patient information)

    // All variables are strings for now
    String patientName, patientAddress, patientID, patientDOB, chiefComplaint;

    // Images (not sure about the type)
    BufferedImage imageBefore, image48hr, image72hr;

    /*
        @Todo
        Check type for image files and type for patient information
        Add any extra patient information
        Make variables final??
        Get from the server/send to the server??
     */

    // Temporary method that allows us to create a patient object
    public Patient(String patientName, String patientAddress, String patientID, String patientDOB) {
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.patientID = patientID;
        this.patientDOB = patientDOB;
    }

    // Get methods
    public String getPatientName() {
        return patientName;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public BufferedImage getImage48hr() {
        return image48hr;
    }

    public BufferedImage getImage72hr() {
        return image72hr;
    }

    public BufferedImage getImageBefore() {
        return imageBefore;
    }

    // Set Methods
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public void setImage48hr(BufferedImage image48hr) {
        this.image48hr = image48hr;
    }

    public void setImage72hr(BufferedImage image72hr) {
        this.image72hr = image72hr;
    }

    public void setImageBefore(BufferedImage imageBefore) {
        this.imageBefore = imageBefore;
    }
}
