package camera;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

import entity.*;

public class Camera extends Rectangular {
    private int scale;
    private GameMap map;
    private BufferedImage image;

    public Camera(int w, int h, GameMap m) {
        super(0, w, 0, h);
        scale = 1;
        map = m;
        image = new BufferedImage(width(), height(), BufferedImage.TYPE_INT_ARGB);
    }

    public BufferedImage image() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width(), height());
        g.setColor(Color.black);
        for (int column = 0; column <= map.tileWidth(); column++) {
            int x = column * scale * 30 - left();
            if (x >= 0 && x <= width()) {
                g.drawLine(x, 0, x, height());
            }
        }
        for (int row = 0; row <= map.tileHeight(); row++) {
            int y = row * scale * 30 - top();
            if (y >= 0 && y <= height()) {
                g.drawLine(0, y, width(), y);
            }
        }
        return image;
    }
}