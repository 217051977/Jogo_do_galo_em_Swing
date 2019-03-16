import javax.swing.*;
import java.awt.*;

public class ToolBarImage extends JToolBar {

    private ImageIcon image;

    ToolBarImage(ImageIcon image) {

        this.image = image;
        setOpaque(true);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (image != null) {

            Dimension size = this.getSize();
            g.drawImage(image.getImage(), 0,0, size.width, size.height, this);

        }

    }

}
