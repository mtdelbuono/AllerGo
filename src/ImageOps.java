import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ImageOps {

    //keep these static because the class is what matters... no need for a fake object
    public static BufferedImage recolor(float r, float g, float b, BufferedImage im) throws IOException {
        final BufferedImageOp op = new RescaleOp(new float[] { 1, 1, 1 }, new float[] { r, g, b }, null);
            BufferedImage result = op.filter(im, null);
            return result;
    }

    //public BufferedImage crop(BufferedImage im){/*no idea what to ad here*/}

    //this be temp.
    /*
    public static void main(final String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("C:\\Users\\milan\\IdeaProjects\\AllerGo\\images\\hand.jpg"));

        SwingUtilities.invokeLater(() -> {
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            BoundedRangeModel red = new DefaultBoundedRangeModel(0, 1, -255, 255);
            BoundedRangeModel green = new DefaultBoundedRangeModel(0, 1, -255, 255);
            BoundedRangeModel blue = new DefaultBoundedRangeModel(0, 1, -255, 255);

            ChangeListener sliderListener = e -> new SwingWorker<BufferedImage, BufferedImage>() {
                final BufferedImageOp op = new RescaleOp(new float[] { 1, 1, 1 }, new float[] { red.getValue(), green.getValue(), blue.getValue() }, null);

                /*@Override protected BufferedImage doInBackground() {
                    BufferedImage result = op.filter(image, null);
                    publish(result);
                    imageLabel.setIcon(new ImageIcon(result));
                    return result;
                }



                //@Override protected void process(List<BufferedImage> chunks) {
                    //imageLabel.setIcon(new ImageIcon(chunks.get(0)));
               // }
            }.execute();

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

            JPanel main = new JPanel(new BorderLayout());
            main.add(imageLabel);
            main.add(sliders, BorderLayout.SOUTH);

            JFrame test = new JFrame("Test");
            test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            test.getContentPane().add(main);
            test.pack();
            test.setLocationRelativeTo(null);

            test.setVisible(true);
        });
    }

     */
}
