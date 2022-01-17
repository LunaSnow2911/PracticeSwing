package PracticeSwing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Top extends JPanel {
    public Top() {
        setLayout(new GridLayout(1, 3, 5, 5));

        SwingUtils.createButton("Khoá học", 50, 60, new Color(240, 58, 76), "PracticeSwing/calender.png", this);
        SwingUtils.createButton("Học viên", 50, 60, new Color(58, 234, 240), "PracticeSwing/3.png", this);
        SwingUtils.createButton("Học viên", 50, 60, new Color(66, 140, 36), "PracticeSwing/1.png", this);

    }
}
