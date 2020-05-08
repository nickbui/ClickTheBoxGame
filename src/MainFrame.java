
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{

    GamePanel game;

    public MainFrame()
    {
        super("Lab 09 - A Game");
        MacLayoutSetup();
        game = new GamePanel();
        getContentPane().add(game, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
    }

    public void MacLayoutSetup()
    {
        // On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear 
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
