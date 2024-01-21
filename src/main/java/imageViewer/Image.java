package imageViewer;

public interface Image {

    String id();

    Image next();

    Image previous();

}