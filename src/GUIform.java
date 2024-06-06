import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;

public class GUIform implements ActionListener {
    // Declare global variables
    JFrame frame, openPatientMenu;
    JMenuItem m1, m2, m3;
    JFrame exportPatientMenu, dateMenu, newPatientMenu;
    JButton exportOK, openOK, newPatientButton, loadOK, newPatientOK;

    public static void main(String[] args) {
            GUIform guiForm = new GUIform();
            guiForm.createAndShowGUI();
    }


    public void createAndShowGUI() {
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

        JButton color = new JButton("Color");
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

        JComponent panel1 = makeTextPanel("Panel #1");
        imagePane.addTab("Before", panel1);

        JComponent panel2 = makeTextPanel("Panel #2");
        imagePane.addTab("48hrs", panel2);


        JComponent panel3 = makeTextPanel("Panel #3");
        imagePane.addTab("72hrs", panel3);
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

    public void export() {
        exportPatientMenu = new JFrame("Export Patient");
        exportPatientMenu.setSize(500, 400);
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

        exportOK = new JButton("Export");
        exportPatientMenu.add(exportOK, BorderLayout.AFTER_LAST_LINE);
        exportOK.addActionListener(this);

        exportPatientMenu.add(exportNamePanel, BorderLayout.NORTH);
        exportPatientMenu.add(exportLocationPanel, BorderLayout.CENTER);

        // Set Visible
        exportPatientMenu.setVisible(true);
    }

    public void openPatient() {
        // Edit format + functionality once Patient class created/server added
        openPatientMenu = new JFrame("Open Patient");
        openPatientMenu.setSize(500, 400);

        JLabel openName = new JLabel("Patient Name: ");
        JTextField openPatientName = new JTextField(30);
        openPatientName.setEditable(true);
        JPanel openNamePanel = new JPanel();
        openNamePanel.add(openName);
        openNamePanel.add(openPatientName);

        // Replace with file system
        JLabel openID = new JLabel("Patient ID: ");
        JTextField openPatientID = new JTextField(30);
        openPatientID.setEditable(true);
        JPanel openIDPanel = new JPanel();
        openIDPanel.add(openID);
        openIDPanel.add(openPatientID);

        openPatientMenu.add(openNamePanel, BorderLayout.NORTH);
        openPatientMenu.add(openIDPanel, BorderLayout.CENTER);

        JPanel openPatientButtons = new JPanel();

        newPatientButton = new JButton("New Patient");
        openPatientButtons.add(newPatientButton, BorderLayout.NORTH);
        newPatientButton.addActionListener(this);

        openOK = new JButton("Open Patient");
        openPatientButtons.add(openOK, BorderLayout.SOUTH);
        openOK.addActionListener(this);

        openPatientMenu.add(openPatientButtons, BorderLayout.SOUTH);

        openPatientMenu.setVisible(true);
    }

    public void loadPatient() {
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

    public void newPatient() {
        openPatientMenu.setVisible(false);

        newPatientMenu = new JFrame();
        newPatientMenu.setSize(500, 400);

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

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4,0);
        panel.setLayout(layout);
        panel.add(namePanel);
        panel.add(IDPanel);
        panel.add(DOBPanel);
        panel.add(addressPanel);

        newPatientOK = new JButton("Create Patient");
        newPatientMenu.add(newPatientOK, BorderLayout.SOUTH);
        newPatientOK.addActionListener(this);

        newPatientMenu.add(panel, BorderLayout.CENTER);
        newPatientMenu.setVisible(true);

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == m1) {
            openPatient();
        }
        if (a.getSource() == m2) {
            JOptionPane.showMessageDialog(frame, "Done", null, JOptionPane.PLAIN_MESSAGE);
        }
        if (a.getSource() == m3) {
            this.export();
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