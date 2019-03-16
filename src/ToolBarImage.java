import javax.swing.*;
import java.awt.*;

public class ToolBarImage extends JToolBar {

    /*
    * Create an ImageIcon variable called image to keep the image
    * */
    private ImageIcon image;

    /*
    * Constructor that receives an ImageIcon
    * */
    ToolBarImage(ImageIcon image) {

        /*
        * Set the value of the ImageIcon received on the object image variable
        * */
        this.image = image;

    }

    /*
    * Paint the image in the JToolBar
    * */
    public void paintComponent(Graphics g) {

        /*
        * Call the paintComponent() function from the super (JComponent)
        * Checks if there is an image to print, and if so:
        * - Get the size of the component
        * - Print the image in the JToolBar
        * */
        super.paintComponent(g);

        if (image != null) {

            Dimension size = this.getSize();
            g.drawImage(image.getImage(), 0,0, size.width, size.height, this);

        }

    }

}
