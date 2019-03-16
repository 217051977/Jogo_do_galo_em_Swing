import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {

    /*
    * Set the size of the window
    * Create a button List
    * Create a String to keep the Winner
    * */
    private static int WIDTH = 600, HEIGHT = 700;
    private static List<Button> buttons = new ArrayList<>();
    private static String gameResult = "";

    public static void main(String[] args) {

        /*
        * Set the app to dont be a priority so other programs can run in background as well
        * */
        SwingUtilities.invokeLater(GamePlay::createAndShowGUI);

    }

    private static void createAndShowGUI() {

        /*
        * Creates a Shift type object
        * Creates nine Button type objects to keep the track of each one in the game
        * Add this 9 Button type objects to the buttons list
        * */
        Shift shift = new Shift();
        Button topLeftVar = new Button("topLeft");
        Button topVar = new Button("top");
        Button topRightVar = new Button("topRight");
        Button midLeftVar = new Button("midLeft");
        Button midVar = new Button("mid");
        Button midRightVar = new Button("midRight");
        Button botLeftVar = new Button("botLeft");
        Button botVar = new Button("bot");
        Button botRightVar = new Button("botRight");
        buttons.add(topLeftVar);
        buttons.add(topVar);
        buttons.add(topRightVar);
        buttons.add(midLeftVar);
        buttons.add(midVar);
        buttons.add(midRightVar);
        buttons.add(botLeftVar);
        buttons.add(botVar);
        buttons.add(botRightVar);

        /*
        * Creates the window
        * Set the frame in the middle of the screen
        * */
        JFrame frame = createFrame("Cock Game", WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        /*
        * Declares and initialize a toolbar so it can get the buttons
        * Set his layout as 3x3 with 5 units as horizontal and vertical gap
        * Set as non floatable
        * Set the boarders non painted
        * Set the distance between the bar and the buttons in it
        * */
        JToolBar playGround = new ToolBarImage(getIcon());
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

        /*
        * For every JButton, adds an Action Lister so every time the button is pressed:
        * - Check if that same button has already been activated, and if not,
        * - Set an image of the player move (X or O)
        * - Check if the game has ended
        * */
        topLeft.addActionListener(event -> {

            if (topLeftVar.AddPlay(shift)) {

                topLeft.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        top.addActionListener(event -> {

            if (topVar.AddPlay(shift)) {

                top.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        topRight.addActionListener(event -> {

            if (topRightVar.AddPlay(shift)) {

                topRight.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        midLeft.addActionListener(event -> {

            if (midLeftVar.AddPlay(shift)) {

                midLeft.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        mid.addActionListener(event -> {

            if (midVar.AddPlay(shift)) {

                mid.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        midRight.addActionListener(event -> {

            if (midRightVar.AddPlay(shift)) {

                midRight.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        botLeft.addActionListener(event -> {

            if (botLeftVar.AddPlay(shift)) {

                botLeft.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        bot.addActionListener(event -> {

            if (botVar.AddPlay(shift)) {

                bot.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

        botRight.addActionListener(event -> {

            if (botRightVar.AddPlay(shift)) {

                botRight.setIcon(getPlayIcon(shift));
                showResultScreen(shift, frame);

            }

        });

    }

    private static ImageIcon getIcon() {

        /*
        * Return the image with that specific name
        * */
        return new ImageIcon(GamePlay.class.getResource("Board.gif"));

    }

    private static ImageIcon getPlayIcon(Shift shift) {

        /*
        * Add a unit to the shift counter
        * Check if the shiftCounter is par, and if so:
        * - Get and return the image with the name "X.png"
        * If the shiftCounter is odd:
        * - Get and return the image with the name "O.png"
        * */
        shift.nextShift();

        if (shift.getShiftCounter() % 2 == 0) {

            return new ImageIcon(GamePlay.class.getResource("X.png"));

        }

        return new ImageIcon(GamePlay.class.getResource("O.png"));

    }

    private static JFrame createFrame(String name, int WIDTH, int HEIGHT) {

        /*
         * Declares and initialize a frame (window) with the name "Cock Game"
         * Set the frame to close when click on the "X" of the window it self
         * Set the frame as not resizable
         * Create a layout of the contentPane where the border layout with no margins between components
         * Return the frame
         * */
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        return frame;

    }

    private static void showResultScreen(Shift shift, JFrame frame) {

        /*
        * Creates an int type variable called gameOverReturned to keep the value of the return of the function gameOver
        * Check if the gameOverReturned has the value different of 0 (the game has ended), and if so:
        * - Creates an JFrame called resultFrame
        * - Set the position of the resultFrame relative to the frame received as a parameter (game window)
        * - Set the resultFrame always on top of the frame
        * - Creates an JLabel called winner
        * - Creates a Font
        * - Checks if the gameResult variable is empty, and if so:
        * - - Check if the value of the gameOverReturned is 1, and if so:
        * - - - Check if the shiftCounter is par, and if so:
        * - - - - Set the value of the gameResult variable as "Winner is the X team!"
        * - - - If the shiftCounter is odd:
        * - - - - Set the value of the gameResult variable as "Winner is the O team!"
        * - - If is the value of the variable gameOverReturned is not an 0 or an 1:
        * - - - Set the value of the gameResult variable as "Is a Draw!"
        * - Initialize the winner JLabel with the gameResult variable
        * - Set the font to the winner JLabel
        * - Add the winner to the resultFrame
        * - Set the resultFrame visible
        * */

        int gameOverReturned = gameOver();

        if (gameOverReturned != 0) {

            JFrame resultFrame = createFrame("Winner", 400, 100);
            resultFrame.setLocationRelativeTo(frame);
            resultFrame.setAlwaysOnTop(true);
            JLabel winner;
            Font font = new Font("Jokerman", Font.PLAIN, 35);

            if (gameResult.equals("")) {

                if (gameOverReturned == 1) {

                    if (shift.getShiftCounter() % 2 == 0) {

                        gameResult = "Winner is the X team!";

                    } else {

                        gameResult = "Winner is the O team!";

                    }

                } else {

                    gameResult = "Is a Draw!";

                }

            }

            winner = new JLabel(gameResult);
            winner.setFont(font);
            resultFrame.add(winner);
            resultFrame.setVisible(true);

        }

    }

    private static int gameOver() {

        /*
         * Creates a char type variable so it knows which character to look for
         * Creates an int type variable so it can keep the number of buttons that have a play in it
         * Check if there is 3 button with the same character in it
         *
         * - After checking the first button
         * - Keeps the value of character in it in the charToCheck variable
         * - search for that same character in the next 3 buttons. This is the order of this searching:
         * - - topLeft -> top -> topRight
         * - - topLeft -> mid -> botRight
         * - - topLeft -> midLeft -> botLeft
         * - - midLeft -> mid -> midRight
         * - - botLeft -> bot -> botRight
         * - - botLeft -> mid -> topRight
         * - - topLeft -> mid -> botRight
         * - - topLeft -> midLeft -> botLeft
         * - - top -> mid -> bot
         * - - topRight -> midRight -> botRight
         *
         * Check how many buttons have a play in it already
         * If the value of the buttonsWithPlayInIt variable is 9 then:
         * - Return 2
         * Return 0
         * */
        char charToCheck;
        int buttonsWithPlayInIt = 0;

        for (Button button : buttons) {

            if (button.getName().equals("topLeft") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        switch (button2.getName()) {
                            case "top":

                                for (Button button3 : buttons) {

                                    if (button3.getName().equals("topRight") && button3.getCharInIt() == charToCheck) {

                                        return 1;

                                    }

                                }

                                break;
                            case "mid":

                                for (Button button3 : buttons) {

                                    if (button3.getName().equals("botRight") && button3.getCharInIt() == charToCheck) {

                                        return 1;

                                    }

                                }

                                break;
                            case "midLeft":

                                for (Button button3 : buttons) {

                                    if (button3.getName().equals("botLeft") && button3.getCharInIt() == charToCheck) {

                                        return 1;

                                    }

                                }

                                break;
                        }

                    }

                }

            } else if (button.getName().equals("midLeft") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        if (button2.getName().equals("mid")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("midRight") && button3.getCharInIt() == charToCheck) {

                                    return 1;

                                }

                            }

                        }

                    }

                }

            } else if (button.getName().equals("botLeft") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        if (button2.getName().equals("bot")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("botRight") && button3.getCharInIt() == charToCheck) {

                                    return 1;

                                }

                            }

                        } else if (button2.getName().equals("mid")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("topRight") && button3.getHasAPlayInIt()) {

                                    return 1;

                                }

                            }

                        }

                    }

                }

            } else if (button.getName().equals("top") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        if (button2.getName().equals("mid")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("bot") && button3.getCharInIt() == charToCheck) {

                                    return 1;

                                }

                            }

                        }

                    }

                }

            } else if (button.getName().equals("topRight") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        if (button2.getName().equals("midRight")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("botRight") && button3.getCharInIt() == charToCheck) {

                                    return 1;

                                }

                            }

                        }

                    }

                }

            }

        }

        for (Button button : buttons) {

            if (button.getHasAPlayInIt()) {

                buttonsWithPlayInIt++;

            }

        }

        if (buttonsWithPlayInIt == 9) {

            return 2;

        }

        return 0;

    }

}
