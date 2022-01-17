package PracticeSwing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiMain extends JFrame {
    Top topPane;
    Left leftPane;
    Center centerPane;

    public GuiMain() {
        // setSize(1000, 600);
        JPanel mainPane = new JPanel();
        // mainPane.setSize(800, 600);

        JPanel pane = new JPanel();
        // pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.setBackground(Color.gray);
        topPane = new Top();
        leftPane = new Left();
        centerPane = new Center();

        leftPane.setPreferredSize(new Dimension(200, 600));
        pane.setPreferredSize(new Dimension(700, 600));
        topPane.setPreferredSize(new Dimension(700, 100));
        centerPane.setPreferredSize(new Dimension(700, 500));

        pane.add(topPane);
        pane.add(centerPane);
        mainPane.add(leftPane);
        mainPane.add(pane);
        add(mainPane);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        new GuiMain();
    }
}
