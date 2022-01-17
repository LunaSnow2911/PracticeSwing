package PracticeSwing;

import java.awt.Image;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SwingUtils {
    public static void createButton(String name, int w, int h, Color color, String url, Container container) {
        JButton button = new JButton(name);
        button.setSize(w, h);
        button.setBackground(color);
        ImageIcon iconImageIcon = new ImageIcon(url);
        Icon icon = resizeIcon(iconImageIcon, w, h);
        button.setIcon(icon);

        container.add(button);
    }

    public static Icon resizeIcon(ImageIcon imc, int weight, int height) {
        Image img = imc.getImage();
        Image resizeImage = img.getScaledInstance(weight, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizeImage);
    }
}
