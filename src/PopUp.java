import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PopUp implements ActionListener, ChangeListener {
    BufferedImage image1, image2, image3;
    JPanel photoholder1, photoholder2, photoholder3;
    JLabel picture1, picture2, picture3;
    JSlider red1, red2, red3, blue1, blue2, blue3, green1, green2, green3;
    JFrame frmManualRecoloring;
    JButton saveRecolor, cancelRecolor;
//temp:
    BufferedImage img;

    /*
        This class needs a lot of work
        - add all of the images
        - finish the last two pop up windows
     */

    public PopUp(BufferedImage i1, BufferedImage i2, BufferedImage i3){
        image1 = i1;
        image2 = i2;
        image3 = i3;
    }

    protected void recolor(){
        frmManualRecoloring = new JFrame("Manual Image Recolor");
        frmManualRecoloring.setSize(600, 500);
        frmManualRecoloring.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmManualRecoloring.getContentPane().setLayout(null);

        saveRecolor = new JButton("Save");
        saveRecolor.setBounds(478, 397, 85, 21);
        saveRecolor.addActionListener(this);
        frmManualRecoloring.getContentPane().add(saveRecolor);

        cancelRecolor = new JButton("Cancel");
        cancelRecolor.setBounds(387, 397, 85, 21);
        cancelRecolor.addActionListener(this);
        frmManualRecoloring.getContentPane().add(cancelRecolor);

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

        photoholder1 = new JPanel();
        photoholder1.setBackground(new Color(192, 192, 192));
        photoholder1.setBounds(0, 10, 160, 222);
        imgpanel1.add(photoholder1);

        picture1 = new JLabel(new ImageIcon(image1));
        photoholder1.add(picture1);

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

        photoholder2 = new JPanel();
        photoholder2.setBackground(new Color(192, 192, 192));
        photoholder2.setBounds(0, 10, 160, 222);
        imgpanel2.add(photoholder2);

        picture2 = new JLabel(new ImageIcon(image2));
        photoholder2.add(picture2);

        JPanel blueref2 = new JPanel();
        blueref2.setBackground(new Color(0, 128, 255));
        blueref2.setBounds(109, 242, 51, 10);
        imgpanel2.add(blueref2);

        JPanel imgpanel3 = new JPanel();
        imgpanel3.setBounds(350, 25, 160, 252);
        frmManualRecoloring.getContentPane().add(imgpanel3);
        imgpanel3.setLayout(null);

        photoholder3 = new JPanel();
        photoholder3.setBackground(new Color(192, 192, 192));
        photoholder3.setBounds(0, 10, 160, 222);
        imgpanel3.add(photoholder3);

        picture3 = new JLabel(new ImageIcon(image3));
        photoholder3.add(picture3);

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

        //limits each slider to -255,255 range, init. at 0
        BoundedRangeModel slider = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider1 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider2 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider3 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider4 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider5 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider6 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider7 = new DefaultBoundedRangeModel(0,1,-255,255);
        BoundedRangeModel slider8 = new DefaultBoundedRangeModel(0,1,-255,255);


        red1 = new JSlider(slider);
        red1.setBounds(40, 287, 130, 26);
        frmManualRecoloring.getContentPane().add(red1);

        green1 = new JSlider(slider1);
        green1.setBounds(40, 323, 130, 26);
        frmManualRecoloring.getContentPane().add(green1);

        blue1 = new JSlider(slider2);
        blue1.setBounds(40, 362, 130, 26);
        frmManualRecoloring.getContentPane().add(blue1);

        blue2 = new JSlider(slider3);
        blue2.setBounds(180, 362, 160, 26);
        frmManualRecoloring.getContentPane().add(blue2);

        green2 = new JSlider(slider4);
        green2.setBounds(180, 323, 160, 26);
        frmManualRecoloring.getContentPane().add(green2);

         red2 = new JSlider(slider5);
        red2.setBounds(180, 287, 160, 26);
        frmManualRecoloring.getContentPane().add(red2);

        blue3 = new JSlider(slider6);
        blue3.setBounds(350, 361, 160, 26);
        frmManualRecoloring.getContentPane().add(blue3);

        green3 = new JSlider(slider7);
        green3.setBounds(350, 322, 160, 26);
        frmManualRecoloring.getContentPane().add(green3);

        red3 = new JSlider(slider8);
        red3.setBounds(350, 286, 160, 26);
        frmManualRecoloring.getContentPane().add(red3);

        //should consider making these fuckers an arraylist and iterating but nah
        red1.addChangeListener(this);
        red2.addChangeListener(this);
        red3.addChangeListener(this);
        green1.addChangeListener(this);
        green2.addChangeListener(this);
        green3.addChangeListener(this);
        blue1.addChangeListener(this);
        blue2.addChangeListener(this);
        blue3.addChangeListener(this);

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

    protected void resize(Image image1, Image image2, Image image3) {
        /*
        @Todo
         Fill in entire method
         */
    }

    protected void crop(Image image1, Image image2, Image image3) {
        /*
        @Todo
         Fill in entire method
         */
    }

    public void export(){
       //use setters in GUIForm to change the images loaded in to this class
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(saveRecolor)){
            //set the class images
            //do it here

            //invoke export to send the 3 redone images back to the original GUIform class
            export();
            frmManualRecoloring.dispose();
        }
        if(e.getSource().equals(cancelRecolor)){
            frmManualRecoloring.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //check which image manipulated and change color. RECOLOR SECTION
        if(e.getSource().equals(red1) || e.getSource().equals(blue1) || e.getSource().equals(green1)){
            try {
                //run the other overloaded recolor method
                BufferedImage imageNew = ImageOps.recolor(red1.getValue(), green1.getValue(), blue1.getValue(), image1);//keep as img
                //set the JLabel to have the new updated image, but do not change the original images img.
                picture1.setIcon(new ImageIcon(imageNew));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource().equals(red2) || e.getSource().equals(blue2) || e.getSource().equals(green2)){
            try {
                BufferedImage imageNew = ImageOps.recolor(red2.getValue(), green2.getValue(), blue2.getValue(), image2);
                picture2.setIcon(new ImageIcon(imageNew));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource().equals(red3) || e.getSource().equals(blue3) || e.getSource().equals(green3)){
            try {
                BufferedImage imageNew = ImageOps.recolor(red3.getValue(), green3.getValue(), blue3.getValue(), image3);
                picture3.setIcon(new ImageIcon(imageNew));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }




    }
}
