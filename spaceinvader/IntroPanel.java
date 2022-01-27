import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        intro.intro1.repaint(g);
    }
}
