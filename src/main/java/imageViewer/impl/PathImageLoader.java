package imageViewer.impl;

import imageViewer.Image;
import imageViewer.ImageLoader;

import java.io.File;
import java.io.FilenameFilter;

public class PathImageLoader implements ImageLoader {
    private final File [] images;
    private static final String[] imageExtensions = new String[]{"jpg", "png"};

    public PathImageLoader(File path) {
        this.images=path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("png") || name.endsWith("jpg");
            }
        });

    }

    @Override
    public Image load() {
        return linkImages(0);
    }

    private Image linkImages(int i) {
        return new Image() {
            @Override
            public String path() {
                return images[i].toString();
            }

            @Override
            public Image next() {
                return linkImages((i+1) % images.length);
            }

            @Override
            public Image previous() {
                return linkImages((i-1+ images.length) % images.length);
            }
        };
    }
}
