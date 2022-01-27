import javax.swing.*;
import java.awt.*;

public class gamescreenPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        gamescreen.artp.repaint(g);
    }
}
