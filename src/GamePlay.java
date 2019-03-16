import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {

    //set the size of the window
    private static int WIDTH = 600, HEIGHT = 700;
    static List<Button> buttons = new ArrayList<>();

    public static void main(String[] args) {

        /*
        * Set the app to dont be a priority so other programs can run in background as well
        * */
        SwingUtilities.invokeLater(GamePlay::createAndShowGUI);

    }

    private static void createAndShowGUI() {

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

        //creates the window
        JFrame frame = createFrame("Cock Game", WIDTH, HEIGHT);

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

        topLeft.addActionListener(event -> {

            if (topLeftVar.AddPlay(shift)) {

                showResultScreen(shift);
                topLeft.setIcon(getPlayIcon(shift));

            }

        });

        top.addActionListener(event -> {

            if (topVar.AddPlay(shift)) {

                showResultScreen(shift);
                top.setIcon(getPlayIcon(shift));

            }

        });

        topRight.addActionListener(event -> {

            if (topRightVar.AddPlay(shift)) {

                showResultScreen(shift);
                topRight.setIcon(getPlayIcon(shift));

            }

        });

        midLeft.addActionListener(event -> {

            if (midLeftVar.AddPlay(shift)) {

                showResultScreen(shift);
                midLeft.setIcon(getPlayIcon(shift));

            }

        });

        mid.addActionListener(event -> {

            if (midVar.AddPlay(shift)) {

                showResultScreen(shift);
                mid.setIcon(getPlayIcon(shift));

            }

        });

        midRight.addActionListener(event -> {

            if (midRightVar.AddPlay(shift)) {

                showResultScreen(shift);
                midRight.setIcon(getPlayIcon(shift));

            }

        });

        botLeft.addActionListener(event -> {

            if (botLeftVar.AddPlay(shift)) {

                showResultScreen(shift);
                botLeft.setIcon(getPlayIcon(shift));

            }

        });

        bot.addActionListener(event -> {

            if (botVar.AddPlay(shift)) {

                showResultScreen(shift);
                bot.setIcon(getPlayIcon(shift));

            }

        });

        botRight.addActionListener(event -> {

            if (botRightVar.AddPlay(shift)) {

                showResultScreen(shift);
                botRight.setIcon(getPlayIcon(shift));

            }

        });

    }

    private static ImageIcon getIcon() {

        //return the image with that specific name
        return new ImageIcon(GamePlay.class.getResource("Board.gif"));

    }

    private static ImageIcon getPlayIcon(Shift shift) {

        //add a unit to the shift counter
        shift.nextShift();

        //if the shift counter is par
        if (shift.getShiftCounter() % 2 == 0) {

            //return the X image
            return new ImageIcon(GamePlay.class.getResource("X.png"));

        }

        //return the O image
        return new ImageIcon(GamePlay.class.getResource("O.png"));

    }

    private static JFrame createFrame(String name, int WIDTH, int HEIGHT) {

        /*
         * Declares and initialize a frame (window) with the name "Cock Game"
         * Set the frame to close when click on the "X" of the window it self
         * Set the frame as not resizable
         * Create a layout of the contentPane where the border layout with no margins between components
         * Set the frame in the middle of the screen
         * */
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        return frame;

    }

    private static void showResultScreen(Shift shift) {

        if (gameOver()) {

            JFrame resultFrame = createFrame("Winner", 400, 100);
            JLabel winner;
            Font font = new Font("Jokerman", Font.PLAIN, 35);

            if (shift.getShiftCounter() % 2 == 0) {

                winner = new JLabel("Winner is the O team!");

            }else {

                winner = new JLabel("Winner is the X team!");

            }

            winner.setFont(font);
            resultFrame.add(winner);

            resultFrame.setVisible(true);

        }

    }

    private static boolean gameOver() {

        char charToCheck;

        for (Button button : buttons) {

            if (button.getName().equals("topLeft") && button.getHasAPlayInIt()) {

                charToCheck = button.getCharInIt();

                for (Button button2 : buttons) {

                    if(button2.getCharInIt() == charToCheck) {

                        if (button2.getName().equals("top")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("topRight") && button3.getCharInIt() == charToCheck) {

                                    return true;

                                }

                            }

                        } else if (button2.getName().equals("mid")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("botRight") && button3.getCharInIt() == charToCheck) {

                                    return true;

                                }

                            }

                        } else if (button2.getName().equals("midLeft")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("botLeft") && button3.getCharInIt() == charToCheck) {

                                    return true;

                                }

                            }

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

                                    return true;

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

                                    return true;

                                }

                            }

                        } else if (button2.getName().equals("mid")) {

                            for (Button button3 : buttons) {

                                if (button3.getName().equals("topRight") && button3.getHasAPlayInIt()) {

                                    return true;

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

                                    return true;

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

                                    return true;

                                }

                            }

                        }

                    }

                }

            }

        }

        return false;

    }

}
