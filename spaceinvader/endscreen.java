import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class endscreen extends JPanel implements ActionListener {

    public static endscreen ends;
    private JPanel panel;
    private JFrame frame;
    private boolean Win;
    private JButton quit;
    private JButton menu;
    private JButton playagain;
    public endscreen(boolean win)
    {
        Timer timer = new Timer(30, this);
        panel = new endscreenPanel();
        frame = new JFrame();
        Win = win;
        panel.setLayout(null);
        quit = new JButton("quit");
        quit.setOpaque(true);
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFont(new Font("Arial", Font.PLAIN, 25));
        quit.setForeground(Color.GREEN);
        quit.setBackground(Color.BLACK);
        quit.setBounds(700,675,100,100);
        quit.addActionListener(this);
        quit.setActionCommand("quit");
        quit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel.add(quit);

        menu = new JButton("menu");
        menu.setOpaque(true);
        menu.setBorderPainted(false);
        menu.setContentAreaFilled(false);
        menu.setFont(new Font("Arial", Font.PLAIN, 25));
        menu.setForeground(Color.GREEN);
        menu.setBackground(Color.BLACK);
        menu.setBounds(0,675,107,100);
        menu.addActionListener(this);
        menu.setActionCommand("menu");
        menu.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel.add(menu);

        playagain = new JButton("Play Again");
        playagain.setOpaque(true);
        playagain.setBorderPainted(false);
        playagain.setContentAreaFilled(false);
        playagain.setFont(new Font("Arial", Font.PLAIN, 65));
        playagain.setForeground(Color.GREEN);
        playagain.setBackground(Color.BLACK);
        playagain.setBounds(200,450,400,100);
        playagain.addActionListener(this);
        playagain.setActionCommand("playagain");
        playagain.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel.add(playagain);

        frame.add(panel).setBackground(Color.black);
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setFocusable(true);
        String eventName = e.getActionCommand();
        if(Objects.equals(eventName, "quit")){
            System.exit(0);
        }
        if(Objects.equals(eventName, "menu")){
            frame.dispose();
            intro.intro1 = new intro();
        }
        if(Objects.equals(eventName, "playagain")){
            frame.dispose();
            gamescreen.artp = new gamescreen(gamescreen.artp.level);
        }
        panel.repaint();
    }

    protected void repaint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 200));
        if(Win){
            g.drawString("You",200,250);
            g.drawString("Win",215,425);
        }
        else{
            g.drawString("You",200,250);
            g.drawString("Lose",175,425);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.setColor(Color.white);
            g.drawString("Aliens Left: ", 325,725);
            g.drawString(String.valueOf(gamescreen.artp.score), 465,725);
        }
        for(int i = 0; i<150; i++){
            double x = Math.random()*800;
            double y = Math.random()*800;
            g.fillOval((int)x, (int) y, 3,3);
        }
    }
    public static void main(String args[]){
        ends = new endscreen(false);
    }
}
