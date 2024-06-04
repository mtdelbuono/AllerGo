import javax.swing.*;
import java.awt.*;
import javax.swing.JTabbedPane;

public class GUIform {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Image Processing Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        // Main panel with dropdown menus


        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem m1 = new JMenuItem("Open");
        JMenuItem m2 = new JMenuItem("Save");
        JMenuItem m3 = new JMenuItem("Export");
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
}