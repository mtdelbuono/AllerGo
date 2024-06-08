import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import javax.swing.JOptionPane;

/*2
    @Todo
    1. Change all methods to take advantage of the patient class
        - add function to text boxes to save information to patient object
    2. Add function (action listener) to all buttons and elements

 */

public class GUIform implements ActionListener {
    // Declare global variables
    JFrame frame, openPatientMenu, exportPatientMenu, dateMenu, newPatientMenu;
    JMenuItem m1, m2, m3;
    JButton exportOK, openOK, newPatientButton, loadOK, newPatientOK;
    JButton color;
    ChangeListener sliderListener;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIform GUI = new GUIform();
        });
    }

    public GUIform() {
        frame = new JFrame("Image Processing Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        // Main panel with dropdown menus

        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        m1 = new JMenuItem("Open");
        m2 = new JMenuItem("Save");
        m3 = new JMenuItem("Export");
        file.add(m1);
        file.add(m2);
        file.add(m3);

        mb.add(file);

        color = new JButton("Color");
        color.addActionListener(this);
        JButton crop = new JButton("Crop");
        JButton size = new JButton("Size");
        JButton patientInfo = new JButton("Patient Info");

        mb.add(color);
        mb.add(crop);
        mb.add(size);
        mb.add(patientInfo);

        frame.setJMenuBar(mb);


        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);


        // Image panels, later set to remove and add tab buttons. Later, and set to change image.
        JTabbedPane imagePane = new JTabbedPane();

        JPanel panel1 = new JPanel();

        //test this panel layout REPLACE WITH IMAGE
        JPanel panelTester = new JPanel();
        panelTester.setBackground(Color.BLACK);
        panelTester.setPreferredSize(new Dimension(450, 500));//change these to desired Aspect Ratio
        panel1.add(panelTester, BorderLayout.CENTER);

        JButton panel1b = new JButton("Close");
        panel1.add(panel1b, BorderLayout.SOUTH);
        panel1b.addActionListener(this);

        imagePane.addTab("Before", panel1);

        JPanel panel2 = new JPanel();
        JButton panel2b = new JButton("Close");
        panel2b.addActionListener(this);
        panel2.add(panel2b, BorderLayout.SOUTH);
        imagePane.addTab("48hrs", panel2);


        JPanel panel3 = new JPanel();
        JButton panel3b = new JButton("Close");
        panel3b.addActionListener(this);
        panel3.add(panel3b, BorderLayout.SOUTH);
        imagePane.addTab("72hrs", panel3);

        JPanel tabOpenPanel = new JPanel();
        tabOpenPanel.setLayout(new GridBagLayout());
        JButton tabOpen = new JButton("Open");
        tabOpenPanel.add(tabOpen, new GridBagConstraints());
        tabOpen.addActionListener(this);
        imagePane.addTab("Open", tabOpenPanel);

        imagePane.setPreferredSize(new Dimension(450,450));
        frame.getContentPane().add(imagePane, BorderLayout.WEST);
        imagePane.setVisible(true);

        // Textboxes and add to JPanel to JFrame
        JTextArea resultsTextArea = new JTextArea(20, 30);
        resultsTextArea.append("1:\n2:\n3:\n4:\n5:\n6:\n7:\n8:\n9:\nControl:");
        JTextArea impressionTextArea = new JTextArea(12, 30);
        impressionTextArea.append("Add Impression here");
        JPanel texts = new JPanel(new BorderLayout());
        texts.add(resultsTextArea, BorderLayout.NORTH);
        texts.add(impressionTextArea, BorderLayout.CENTER);
        JButton saveImpression = new JButton("Save report and impression");
        texts.add(saveImpression, BorderLayout.SOUTH);
        texts.setPreferredSize(new Dimension(500,500));
        frame.getContentPane().add(texts, BorderLayout.EAST);


        frame.setVisible(true);

    }

    protected static JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    // Method to make export pop up window, called when 'export' button is pressed
    private void export() {
        // Make the frame
        exportPatientMenu = new JFrame("Export Patient");
        exportPatientMenu.setSize(500, 400);

        // Create 'Name' text box
        JLabel exportName = new JLabel("Name: ");
        JTextField exportFileName = new JTextField(30);
        exportFileName.setEditable(true);
        JPanel exportNamePanel = new JPanel();
        exportNamePanel.add(exportName);
        exportNamePanel.add(exportFileName);

        // Replace with file system
        JLabel exportLocation = new JLabel("Location: ");
        JTextField exportFileLocation = new JTextField(30);
        exportFileLocation.setEditable(true);
        JPanel exportLocationPanel = new JPanel();
        exportLocationPanel.add(exportLocation);
        exportLocationPanel.add(exportFileLocation);

        // Export Button that exports the file

        exportOK = new JButton("Export");
        exportPatientMenu.add(exportOK, BorderLayout.AFTER_LAST_LINE);
        exportOK.addActionListener(this);


        // Add components and set Visible
        exportPatientMenu.add(exportNamePanel, BorderLayout.NORTH);
        exportPatientMenu.add(exportLocationPanel, BorderLayout.CENTER);
        exportPatientMenu.setVisible(true);
    }


    // Method that generates the open pop up window, called when 'open' is pressed
    private void openPatient() {

        // Edit format + functionality once Patient class created/server added
        openPatientMenu = new JFrame("Open Patient");
        openPatientMenu.setSize(500, 400);

        // Text fields for patient name and ID

        JLabel openName = new JLabel("Patient Name: ");
        JTextField openPatientName = new JTextField(30);
        openPatientName.setEditable(true);
        JPanel openNamePanel = new JPanel();
        openNamePanel.add(openName);
        openNamePanel.add(openPatientName);

        JLabel openID = new JLabel("Patient ID: ");
        JTextField openPatientID = new JTextField(30);
        openPatientID.setEditable(true);
        JPanel openIDPanel = new JPanel();
        openIDPanel.add(openID);
        openIDPanel.add(openPatientID);

        // Add text box components
        openPatientMenu.add(openNamePanel, BorderLayout.NORTH);
        openPatientMenu.add(openIDPanel, BorderLayout.CENTER);

        // New patient or open existing patient buttons
        JPanel openPatientButtons = new JPanel();

        newPatientButton = new JButton("New Patient");
        openPatientButtons.add(newPatientButton, BorderLayout.NORTH);
        newPatientButton.addActionListener(this);

        openOK = new JButton("Open Patient");
        openPatientButtons.add(openOK, BorderLayout.SOUTH);
        openOK.addActionListener(this);

        openPatientMenu.add(openPatientButtons, BorderLayout.SOUTH);

        // Set the menu to be visible
        openPatientMenu.setVisible(true);
    }

    // Method for creating pop up window that asks for the date and loads existing patient
    // Method may be unnecessary -- do we need that pop up window?
    private void loadPatient() {
        openPatientMenu.setVisible(false);

        dateMenu = new JFrame();
        dateMenu.setSize(500, 400);
        JLabel date = new JLabel("Date: ");
        JTextField dateField= new JTextField(30);
        dateField.setEditable(true);
        JPanel datePanel = new JPanel();
        datePanel.add(date);
        datePanel.add(dateField);

        dateMenu.add(datePanel, BorderLayout.NORTH);

        loadOK = new JButton("Open Patient");
        dateMenu.add(loadOK, BorderLayout.SOUTH);
        loadOK.addActionListener(this);

        dateMenu.setVisible(true);

    }

    // Method to generate pop up window to create a new patient
    private void newPatient() {
        openPatientMenu.setVisible(false);

        newPatientMenu = new JFrame();
        newPatientMenu.setSize(500, 400);

        // Text boxes for patient name, id, dob, address

        JLabel patientName = new JLabel("Patient Name: ");
        JTextField nameField= new JTextField(30);
        nameField.setEditable(true);
        JPanel namePanel = new JPanel();
        namePanel.add(patientName);
        namePanel.add(nameField);

        JLabel patientID = new JLabel("Patient ID: ");
        JTextField IDField = new JTextField(30);
        IDField.setEditable(true);
        JPanel IDPanel = new JPanel();
        IDPanel.add(patientID);
        IDPanel.add(IDField);

        JLabel DOBName = new JLabel("Patient DOB: ");
        JTextField DOBField = new JTextField(30);
        DOBField.setEditable(true);
        JPanel DOBPanel = new JPanel();
        DOBPanel.add(DOBName);
        DOBPanel.add(DOBField);

        JLabel addressName = new JLabel("Patient Name: ");
        JTextField addressField = new JTextField(30);
        addressField.setEditable(true);
        JPanel addressPanel = new JPanel();
        addressPanel.add(addressName);
        addressPanel.add(addressField);

        // Add text boxes to frame
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4,0);
        panel.setLayout(layout);
        panel.add(namePanel);
        panel.add(IDPanel);
        panel.add(DOBPanel);
        panel.add(addressPanel);

        // Button to create the new patient
        newPatientOK = new JButton("Create Patient");
        newPatientMenu.add(newPatientOK, BorderLayout.SOUTH);
        newPatientOK.addActionListener(this);

        newPatientMenu.add(panel, BorderLayout.CENTER);
        newPatientMenu.setVisible(true);

    }

    public void actionPerformed(ActionEvent a) {
      if(a.getSource().equals(color)){
            PopUp.recolor();
        }
      
        if (a.getSource() == m1) {
            openPatient();
        }
        if (a.getSource() == m2) {
            JOptionPane.showMessageDialog(frame, "Done", null, JOptionPane.PLAIN_MESSAGE);
        }
        if (a.getSource() == m3) {
            export();
        }
        if (a.getSource() == exportOK) {
            exportPatientMenu.setVisible(false);
            JOptionPane.showMessageDialog(frame, "Done", null, JOptionPane.PLAIN_MESSAGE);
        }
        if (a.getSource() == openOK) {
            loadPatient();
        }
        if (a.getSource() == loadOK) {
            dateMenu.setVisible(false);
        }
        if (a.getSource() == newPatientButton) {
            newPatient();
        }
        if (a.getSource() == newPatientOK) {
            newPatientMenu.setVisible(false);
        }

    }



}