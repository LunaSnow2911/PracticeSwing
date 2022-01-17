package PracticeSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Container;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Left extends JPanel {
    JPanel tempJPanel = new JPanel();

    public Left() {
        tempJPanel = new JPanel();
        tempJPanel.setLayout(new GridLayout(8, 1, 10, 10));
        tempJPanel.setBackground(new Color(50, 52, 54));
        tempJPanel.setOpaque(true);
        tempJPanel.setPreferredSize(new Dimension(200, 560));

        ImageIcon labelImageIcon = new ImageIcon("PracticeSwing/3.png");
        Icon labelIcon = SwingUtils.resizeIcon(labelImageIcon, 20, 20);

        JLabel label = new JLabel("QUẢN LÝ HỌC VIÊN", labelIcon, JLabel.CENTER);
        // label.setIcon(labelIcon);
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(200, 40));

        add(label);
        add(tempJPanel);
        // SwingUtils.SwingUtils.createButton(name, w, h, color, url, container);
        SwingUtils.createButton("Màn hình chính", 40, 40, Color.cyan, "PracticeSwing/7.png", tempJPanel);
        SwingUtils.createButton("Quản lý học viên", 40, 40, Color.green, "PracticeSwing/4.png", tempJPanel);
        SwingUtils.createButton("Quản lý khoá học", 40, 40, Color.green, "PracticeSwing/5.png", tempJPanel);
        SwingUtils.createButton("Quản lý lớp học", 40, 40, Color.green, "PracticeSwing/2.png", tempJPanel);
        SwingUtils.createButton("Thống kê dữ liệu", 40, 40, Color.green, "PracticeSwing/6.png", tempJPanel);
    }

    // public static void SwingUtils.createButton(String name, int w, int h, Color
    // color, String url, Container container) {
    // JButton button = new JButton(name);
    // button.setSize(w, h);
    // button.setBackground(color);
    // ImageIcon iconImageIcon = new ImageIcon(url);
    // Icon icon = resizeIcon(iconImageIcon, 40, 40);
    // button.setIcon(icon);

    // container.add(button);
    // }

    // public static Icon resizeIcon(ImageIcon imc, int weight, int height) {
    // Image img = imc.getImage();
    // Image resizeImage = img.getScaledInstance(weight, height,
    // Image.SCALE_SMOOTH);
    // return new ImageIcon(resizeImage);
    // }
}
