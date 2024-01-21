package imageViewer.swing;

import imageViewer.Image;
import imageViewer.ImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image im;
    private BufferedImage bufferedImage;

    @Override
    public void show(Image image) {
        this.im = image;
        this.bufferedImage=getBuff(im.path());
    }

    private BufferedImage getBuff(String path) {
        try {
            File file = new File(path);
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image getImage() {
        return im;
    }
    @Override
    public void paint(Graphics g){
        BufferedImage newImage = null;

        double gWidth = (double)(this.getWidth()/bufferedImage.getWidth());
        double gHeight = (double)(this.getHeight()/bufferedImage.getHeight());
        double s;

        if (gWidth <= gHeight){
            s=gWidth;
        }else{
            s=gHeight;
        }

        int[] resizedSize = new int[] {(int) (bufferedImage.getWidth()*s), (int)(bufferedImage.getHeight() *s)};

        newImage = newImage(bufferedImage, resizedSize[0], resizedSize[1]);


        g.drawImage(newImage,0,0,null);
        g.dispose();
    }

    private BufferedImage newImage(BufferedImage oldImage, int newWidth, int newHeight) {
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, 1);
        Graphics g = newImage.createGraphics();
        g.drawImage(oldImage, 0,0, newWidth, newHeight, null);

        return newImage;
    }
}
