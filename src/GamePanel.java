
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{

    JButton characterButton, gameOverButton;
    int score, timeTick, boxWidth, boxHeight, delay = 0;
    Timer tim;
    JProgressBar progressBar;
    JLabel label;

    public GamePanel()
    {
        super();
        setLayout(null);
        setBackground(Color.white);
        characterButton = new JButton("click me");

        addKeyListener(this);

        delay = 1000;
        tim = new Timer(delay, this);

        boxWidth = 100;
        boxHeight = 100;

        label = new JLabel();
        label.setBounds(new Rectangle(0, 0, 1200, 2));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label);

        characterButton.addActionListener(this);
        characterButton.setBounds(new Rectangle(350, 200, boxWidth, boxHeight));
        add(characterButton);
        characterButton.setEnabled(false);

        progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 60);
        progressBar.setStringPainted(true);
        timeTick = 60;
        progressBar.setBounds(new Rectangle(1150, 0, 50, 600));
        add(progressBar);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //paintComponent will be useful in this lab.
        //read more about it in the paiting the screen lesson 
        //and also the keyboard listener method
        g.drawString("score = " + score, 10, 520);
        g.drawString("Press Spacebar to start the game", 10, 540);
        g.drawString("You have 60 seconds to keep clicking on the button to score", 10, 560);

        requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object obj = event.getSource();
        if (obj == characterButton)
        {
            score = score + 1;
            repaint();
            boxWidth = boxWidth - 1;
            boxHeight = boxHeight - 1;
            characterButton.setSize(boxWidth, boxHeight);

        }
        if (obj == tim)
        {
            timeTick = timeTick - 1;
            progressBar.setValue(timeTick);
            progressBar.setString("" + timeTick);

            delay = delay - 10;
            tim.setDelay(delay);

            int x = (int) (Math.floor(Math.random() * 1000));
            int y = (int) (Math.floor(Math.random() * 400));
            characterButton.setLocation(x, y);

            if (timeTick == 0)
            {
                tim.stop();
                characterButton.setVisible(false);

                gameOverButton = new JButton("Game Over Score: " + score);
                gameOverButton.setBounds(new Rectangle(350, 200, 200, 200));
                add(gameOverButton);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        int k = event.getKeyCode();
        if (k == event.VK_SPACE)
        {
            tim.start();
            characterButton.setEnabled(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}
