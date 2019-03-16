import javax.swing.*;
import java.awt.*;

public class ToolBarImage extends JToolBar {

    private ImageIcon bgImage;

    ToolBarImage(ImageIcon image) {

        this.bgImage = image;
        setOpaque(true);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (bgImage != null) {

            Dimension size = this.getSize();
            g.drawImage(bgImage.getImage(), 0,0, size.width, size.height, this);

        }

    }

}
