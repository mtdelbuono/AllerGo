import java.awt.image.BufferedImage;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ImageOps {
    //keep these static because the class is what matters... no need for a fake object
    public static void recolor(float r, float g, float b, BufferedImage im){//void for now, later BI
        int height = im.getHeight();
        int width = im.getWidth();
       // BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int[] row = null;

        for (int y = 0; y < height; y++) {
            // I copy a full row of pixels at a time, for slightly better performance
            row = im.getRGB(0, y, width, 1, row, 0, width);

            for (int x = 0; x < width; x++) {
                int A = row[x] & 0xFF000000; // Just copy the alpha as-is

                int rNew = (row[x] >> 16) & 0xFF;
                int gNew = (row[x] >> 8) & 0xFF;
                int bNew = (row[x]) & 0xFF;

                // As you can see, a simple addition will increase/decrease
                // the channel values, just make sure you keep them in the
                // [0...255] range.
                int R = (int) max(min(rNew + r, 255), 0);
                int G = (int) max(min(gNew + g, 255), 0);
                int B = (int) max(min(bNew + b, 255), 0);

                row[x] = A | R << 16 | G << 8 | B;
                System.out.println(row[x]);
            }

            // And copy the entire row back (temporarily no copy)
           // dest.setRGB(0, y, width, 1, row, 0, width);
            im.setRGB(0,y,width,1,row,0, width);
        }

      //  return dest;

    }

    //public BufferedImage crop(BufferedImage im){/*no idea what to ad here*/}

}
