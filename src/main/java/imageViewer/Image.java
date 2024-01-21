package imageViewer;

public interface Image {

    String path();

    Image next();

    Image previous();

}