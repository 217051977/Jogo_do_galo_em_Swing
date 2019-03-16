import javax.swing.*;
import java.awt.*;

public class GamePlay {

    static int WIDTH = 600, HEIGHT = 700;

    Shift shift = new Shift();

    public static void main(String[] args) {

        /*
        * Set the app to dont be a priority so other programs can run in background as well
        * */
        SwingUtilities.invokeLater(GamePlay::createAndShowGUI);

    }

    private static void createAndShowGUI() {

        /*
        * Declares and initialize a frame (window) with the name "Cock Game"
        * Set the frame to close when click on the "X" of the window it self
        * Set the frame as not resizable
        * Create a layout of the contentPane where the border layout with no margins between components
        * */
        JFrame frame = new JFrame("Cock Game");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        /*
        * Declares and initialize a toolbar so it can get the buttons
        * Set his layout as 3x3 with 5 units as horizontal and vertical gap
        * Set as non floatable
        * Set the boarders non painted
        * Set the distance between the bar and the buttons in it
        * */
        JToolBar playGround = new ToolBarImage(getIcon("Board.gif"));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(playGround, BorderLayout.CENTER);
        playGround.setLayout(new GridLayout(3, 3, 10, 10));
        playGround.setFloatable(false);
        playGround.setBorderPainted(false);
        playGround.setMargin(new Insets(50, 35, 45, 30));

        /*
        * Declares and initialize all 9 buttons
        * Add them to the playGround
        * */
        JButton topLeft = new JButton();
        JButton top = new JButton();
        JButton topRight = new JButton();
        JButton midLeft = new JButton();
        JButton mid = new JButton();
        JButton midRight = new JButton();
        JButton botLeft = new JButton();
        JButton bot = new JButton();
        JButton botRight = new JButton();
        playGround.add(topLeft);
        playGround.add(top);
        playGround.add(topRight);
        playGround.add(midLeft);
        playGround.add(mid);
        playGround.add(midRight);
        playGround.add(botLeft);
        playGround.add(bot);
        playGround.add(botRight);

        /*
        * Set the window visible
        * */
        frame.setVisible(true);

    }

    static ImageIcon getIcon(String iconName) {

        return new ImageIcon(GamePlay.class.getResource(iconName));
        
    }

}
