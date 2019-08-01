package eg.edu.alexu.cse.oop.draw;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

    Frame frame;

    public PaintPanel(Frame view) {
        this.frame = view;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        frame.getEngine().refresh(g);

    }
}
