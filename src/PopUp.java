import javax.swing.*;
import java.awt.*;

public class PopUp {
    Image image1, image2, image3;

    /*
        This class needs a lot of work
        - add all of the images
        - finish the last two pop up windows
     */

    protected static void recolor(/*Image image1, Image image2, Image image3*/){
       /*
       @Todo
        1. Set frame to exit on save, cancel, close.
        2. Figure out sliderlisteners and make the RescaleOp for the sliders. (ChangeListener + ImageOp)
        3. Figure out how to populate said images. For next commit just add some random 3.
        */
        JFrame frmManualRecoloring = new JFrame("Manual Image Recolor");
        frmManualRecoloring.setSize(600, 500);
        frmManualRecoloring.setTitle("Manual Recoloring");
        frmManualRecoloring.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmManualRecoloring.getContentPane().setLayout(null);

        JButton save = new JButton("Save");
        save.setBounds(478, 397, 85, 21);
        frmManualRecoloring.getContentPane().add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(387, 397, 85, 21);
        frmManualRecoloring.getContentPane().add(cancel);

        JPanel imgpanel1 = new JPanel();
        imgpanel1.setBounds(10, 25, 160, 252);
        frmManualRecoloring.getContentPane().add(imgpanel1);
        imgpanel1.setLayout(null);

        JPanel redref1 = new JPanel();
        redref1.setBackground(new Color(255, 0, 0));
        redref1.setBounds(0, 242, 57, 10);
        imgpanel1.add(redref1);

        JPanel greenref1 = new JPanel();
        greenref1.setBackground(new Color(0, 255, 0));
        greenref1.setBounds(54, 242, 57, 10);
        imgpanel1.add(greenref1);

        JPanel photoholder1 = new JPanel();
        photoholder1.setBackground(new Color(192, 192, 192));
        photoholder1.setBounds(0, 10, 160, 222);
        imgpanel1.add(photoholder1);

        JPanel blueref1 = new JPanel();
        blueref1.setBackground(new Color(0, 128, 255));
        blueref1.setBounds(109, 242, 51, 10);
        imgpanel1.add(blueref1);

        JPanel imgpanel2 = new JPanel();
        imgpanel2.setBounds(180, 25, 160, 252);
        frmManualRecoloring.getContentPane().add(imgpanel2);
        imgpanel2.setLayout(null);

        JPanel greenref2 = new JPanel();
        greenref2.setBackground(Color.GREEN);
        greenref2.setBounds(54, 242, 57, 10);
        imgpanel2.add(greenref2);

        JPanel redref2 = new JPanel();
        redref2.setBackground(Color.RED);
        redref2.setBounds(0, 242, 57, 10);
        imgpanel2.add(redref2);

        JPanel photoholder2 = new JPanel();
        photoholder2.setBackground(new Color(192, 192, 192));
        photoholder2.setBounds(0, 10, 160, 222);
        imgpanel2.add(photoholder2);

        JPanel blueref2 = new JPanel();
        blueref2.setBackground(new Color(0, 128, 255));
        blueref2.setBounds(109, 242, 51, 10);
        imgpanel2.add(blueref2);

        JPanel imgpanel3 = new JPanel();
        imgpanel3.setBounds(350, 25, 160, 252);
        frmManualRecoloring.getContentPane().add(imgpanel3);
        imgpanel3.setLayout(null);

        JPanel photoholder3 = new JPanel();
        photoholder3.setBackground(new Color(192, 192, 192));
        photoholder3.setBounds(0, 10, 160, 222);
        imgpanel3.add(photoholder3);

        JPanel redref3 = new JPanel();
        redref3.setBackground(Color.RED);
        redref3.setBounds(0, 242, 57, 10);
        imgpanel3.add(redref3);

        JPanel greenref3 = new JPanel();
        greenref3.setBackground(Color.GREEN);
        greenref3.setBounds(54, 242, 57, 10);
        imgpanel3.add(greenref3);

        JPanel blueref3 = new JPanel();
        blueref3.setBackground(new Color(0, 128, 255));
        blueref3.setBounds(109, 242, 51, 10);
        imgpanel3.add(blueref3);

        JSlider red1 = new JSlider(-255,255);
        red1.setBounds(40, 287, 130, 26);
        frmManualRecoloring.getContentPane().add(red1);

        JSlider green1 = new JSlider(-255,255);
        green1.setBounds(40, 323, 130, 26);
        frmManualRecoloring.getContentPane().add(green1);

        JSlider blue1 = new JSlider(-255,255);
        blue1.setBounds(40, 362, 130, 26);
        frmManualRecoloring.getContentPane().add(blue1);

        JSlider blue2 = new JSlider(-255,255);
        blue2.setBounds(180, 362, 160, 26);
        frmManualRecoloring.getContentPane().add(blue2);

        JSlider green2 = new JSlider(-255,255);
        green2.setBounds(180, 323, 160, 26);
        frmManualRecoloring.getContentPane().add(green2);

        JSlider red2 = new JSlider(-255,255);
        red2.setBounds(180, 287, 160, 26);
        frmManualRecoloring.getContentPane().add(red2);

        JSlider blue3 = new JSlider(-255,255);
        blue3.setBounds(350, 361, 160, 26);
        frmManualRecoloring.getContentPane().add(blue3);

        JSlider green3 = new JSlider(-255,255);
        green3.setBounds(350, 322, 160, 26);
        frmManualRecoloring.getContentPane().add(green3);

        JSlider red3 = new JSlider(-255,255);
        red3.setBounds(350, 286, 160, 26);
        frmManualRecoloring.getContentPane().add(red3);

        JLabel redLabel1 = new JLabel("Red");
        redLabel1.setBounds(10, 287, 45, 13);
        frmManualRecoloring.getContentPane().add(redLabel1);

        JLabel beforePic = new JLabel("Before");
        beforePic.setBounds(10, 10, 45, 13);
        frmManualRecoloring.getContentPane().add(beforePic);

        JLabel after48Pic = new JLabel("48 Hr");
        after48Pic.setBounds(180, 10, 45, 13);
        frmManualRecoloring.getContentPane().add(after48Pic);

        JLabel after72Pic = new JLabel("72 Hr");
        after72Pic.setBounds(350, 10, 45, 13);
        frmManualRecoloring.getContentPane().add(after72Pic);

        JLabel lblGreen = new JLabel("Green");
        lblGreen.setBounds(10, 323, 45, 13);
        frmManualRecoloring.getContentPane().add(lblGreen);

        JLabel lblBlue = new JLabel("Blue");
        lblBlue.setBounds(10, 359, 45, 13);
        frmManualRecoloring.getContentPane().add(lblBlue);

        frmManualRecoloring.setVisible(true);
    }

    protected static void resize(Image image1, Image image2, Image image3) {
        /*
        @Todo
         Fill in entire method
         */
    }

    protected static void crop(Image image1, Image image2, Image image3) {
        /*
        @Todo
         Fill in entire method
         */
    }

}
