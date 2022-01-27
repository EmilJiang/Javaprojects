import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class intro extends JPanel implements ActionListener {
    private final JFrame frame;
    private final IntroPanel panel1;
    public static intro intro1;
    private final JButton easy;
    private final JButton medium;
    private final JButton hard;
    private final JButton impossible;
    private final JButton quit;
    private final Rectangle invader;
    private int xincrement;
    private int yincrement;
    public intro()
    {
        xincrement = 3;
        yincrement = 4;
        frame = new JFrame();
        panel1 = new IntroPanel();
        panel1.setLayout(null);
        invader = new Rectangle(1,1,100,100);
        Timer timer = new Timer(20, this);

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
        panel1.add(quit);

        easy = new JButton("Easy");
        easy.setOpaque(true);
        easy.setBorderPainted(false);
        easy.setContentAreaFilled(false);
        easy.setFont(new Font("Arial", Font.PLAIN, 50));
        easy.setForeground(Color.GREEN);
        easy.setBackground(Color.BLACK);
        easy.setBounds(310,350,175,100);
        easy.addActionListener(this);
        easy.setActionCommand("easy");
        easy.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel1.add(easy);

        medium = new JButton("Medium");
        medium.setOpaque(true);
        medium.setBorderPainted(false);
        medium.setContentAreaFilled(false);
        medium.setFont(new Font("Arial", Font.PLAIN, 50));
        medium.setForeground(Color.GREEN);
        medium.setBackground(Color.BLACK);
        medium.setBounds(278,425,225,100);
        medium.addActionListener(this);
        medium.setActionCommand("medium");
        medium.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel1.add(medium);

        hard = new JButton("Hard");
        hard.setOpaque(true);
        hard.setBorderPainted(false);
        hard.setContentAreaFilled(false);
        hard.setFont(new Font("Arial", Font.PLAIN, 50));
        hard.setForeground(Color.GREEN);
        hard.setBackground(Color.BLACK);
        hard.setBounds(310,500,175,100);
        hard.addActionListener(this);
        hard.setActionCommand("hard");
        hard.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel1.add(hard);

        impossible = new JButton("Impossible");
        impossible.setOpaque(true);
        impossible.setBorderPainted(false);
        impossible.setContentAreaFilled(false);
        impossible.setFont(new Font("Arial", Font.PLAIN, 50));
        impossible.setForeground(Color.GREEN);
        impossible.setBackground(Color.BLACK);
        impossible.setBounds(255,575,285,100);
        impossible.addActionListener(this);
        impossible.setActionCommand("impossible");
        impossible.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        panel1.add(impossible);



        frame.add(panel1).setBackground(Color.black);
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
        if(invader.x < 0 || invader.y > 750 || invader.x > 750 || invader.y < 0){
            xincrement = (int)((Math.random()*10)+1);
            yincrement = (int)((Math.random()*10)+1);
            if(invader.x < 0){
                invader.x = 1;
                if((int) (Math.random()*2) == 0){
                    yincrement *= -1;
                }
            }
            else if(invader.y>750){
                invader.y = 749;
                yincrement *= -1;
                if((int) (Math.random()*2) == 0){
                    xincrement *= -1;
                }
            }
            else if(invader.x>750){
                invader.x = 749;
                xincrement *= -1;
                if((int) (Math.random()*2) == 0){
                    yincrement *= -1;
                }
            }
            else if(invader.y<0){
                invader.y = 1;
                if((int) (Math.random()*2) == 0){
                    xincrement *= -1;
                }
            }
        }
        invader.x += xincrement;
        invader.y += yincrement;
        String eventName = e.getActionCommand();
        if(Objects.equals(eventName, "quit")){
            System.exit(0);
        }
        if(Objects.equals(eventName, "easy")){
            frame.dispose();
            gamescreen.artp = new gamescreen("easy");
        }
        if(Objects.equals(eventName, "medium")){
            frame.dispose();
            gamescreen.artp = new gamescreen("medium");
        }
        if(Objects.equals(eventName, "hard")){
            frame.dispose();
            gamescreen.artp = new gamescreen("hard");
        }
        if(Objects.equals(eventName, "impossible")){
            frame.dispose();
            gamescreen.artp = new gamescreen("impossible");
        }

        panel1.repaint();
    }
    private void invaderdraw(Graphics g, int x, int y){
        g.setColor(Color.GREEN);
        g.fillRect(x,y,15,15);
        g.fillRect(x,y+9,15,15);
        g.fillRect(x+9,y+9,15,6);
        g.fillRect(x-9,y+9,15,6);
        g.fillRect(x+6,y+15,27,9);
        g.fillRect(x-18,y+15,27,9);

        g.fillRect(x+24,y+21,9,33);
        g.fillRect(x-18,y+21,9,33);

        g.fillRect(x+21,y+24,21,21);
        g.fillRect(x-27,y+24,21,21);

        g.fillRect(x,y+18,15,15);
        g.fillRect(x,y+27,15,27);
        g.fillRect(x-12,y+33,21,15);
        g.fillRect(x+6,y+33,21,15);

        g.fillRect(x+33,y+54,9,9);
        g.fillRect(x-27,y+54,9,9);

        g.fillRect(x+24,y+63,9,9);
        g.fillRect(x-18,y+63,9,9);
    }
    protected void repaint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 150));

        g.drawString("Space", 175,200);
        g.drawString("Invaders", 85,325);

        g.setColor(Color.white);
        for(int i = 0; i<150; i++){
            double x = Math.random()*800;
            double y = Math.random()*800;
            g.fillOval((int)x, (int) y, 3,3);
        }
        invaderdraw(g,invader.x, invader.y);
    }
    public static void main(String args[]){
        intro1 = new intro();
    }
}
