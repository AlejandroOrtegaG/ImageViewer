package imageViewer.swing;

import imageViewer.Command;
import imageViewer.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;

    public MainFrame() {
        setTitle("ImageViewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        add(imageDisplay());
    }

    private Component createButton(String s, Command command) {
        JButton button = new JButton(s);
        button.addActionListener(x -> {
            command.execute();
        });
        return button;
    }

    private Component imageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    public void add(String name, Command command, boolean toLeft) {
        add(createButton(name, command),toLeft ? BorderLayout.LINE_START: BorderLayout.LINE_END);
    }
}
