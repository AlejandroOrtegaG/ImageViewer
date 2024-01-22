package imageViewer.swing;

import imageViewer.Image;
import imageViewer.NextCommand;
import imageViewer.PreviousCommand;
import imageViewer.impl.PathImageLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MainFrame mainframe = new MainFrame();
        PathImageLoader loader = new PathImageLoader(new File("/home/equipo/Imágenes/Screenshots"));
        Image image = loader.load();

        mainframe.getImageDisplay().show(image);
        mainframe.add("→", new NextCommand(mainframe.getImageDisplay()), false);
        mainframe.add("←", new PreviousCommand(mainframe.getImageDisplay()), true);

        mainframe.setVisible(true);
    }

}