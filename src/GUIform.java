import javax.swing.*;
import java.awt.*;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;



public class GUIform implements ActionListener {
    JButton color;
    ChangeListener sliderListener;
    JFrame frame;


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
        JMenuItem m1 = new JMenuItem("Open");
        JMenuItem m2 = new JMenuItem("Save");
        JMenuItem m3 = new JMenuItem("Export");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(color)){
            recolor();
        }
    }

    protected void recolor(){// mega debug this shit..
        //get the content from the three panels. (later)
        JInternalFrame recolorFrame = new JInternalFrame("Manual Image Recolor", true,true,true,true);
        recolorFrame.setLayout(new BorderLayout());
        recolorFrame.setSize(2000, 800);
        frame.add(recolorFrame);

        BoundedRangeModel red = new DefaultBoundedRangeModel(0, 1, -255, 255);
        BoundedRangeModel green = new DefaultBoundedRangeModel(0, 1, -255, 255);
        BoundedRangeModel blue = new DefaultBoundedRangeModel(0, 1, -255, 255);
        // these to be replaced by images (getter from the JTabbedPane)
        JPanel recolorImages = new JPanel();
        recolorImages.setLayout(new BoxLayout(recolorImages, BoxLayout.X_AXIS));

        //fake images
        JPanel panel1, panel2, panel3;
        panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        panel1.setPreferredSize(new Dimension(400,500));
        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(400,500));
        panel2.setBackground(Color.RED);
        panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setPreferredSize(new Dimension(400,500));

        recolorImages.add(panel1);
        recolorImages.add(panel2);
        recolorImages.add(panel3);

        sliderListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //nothing yet.
            }
        };

        red.addChangeListener(sliderListener);
        green.addChangeListener(sliderListener);
        blue.addChangeListener(sliderListener);

        JSlider redSlider = new JSlider(red);
        JSlider greenSlider = new JSlider(green);
        JSlider blueSlider = new JSlider(blue);

        JPanel sliders = new JPanel();
        sliders.add(redSlider);
        sliders.add(greenSlider);
        sliders.add(blueSlider);


        recolorFrame.getContentPane().add(recolorImages);
        recolorFrame.getContentPane().add(sliders, BorderLayout.SOUTH);
        recolorFrame.setVisible(true);
    }

}