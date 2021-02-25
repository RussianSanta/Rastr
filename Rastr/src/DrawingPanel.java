import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    public DrawingPanel() {
        setOpaque(true);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}