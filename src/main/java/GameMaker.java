import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import input.*;
import entity.*;
import camera.Camera;

public class GameMaker extends JFrame {
    private int windowWidth = 1600, windowHeight = 900, fps = 60;
    private GameMap map;
    private Camera camera;
    private Insets insets;
    private InputHandler input;
    private BufferedImage backbuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_ARGB);

    public static void main(String[] args) throws Exception {
        System.out.println("Now running GameMaker in directory:\n" + System.getProperty("user.dir"));
        GameMaker gm = new GameMaker();
        gm.initialize();
        gm.run();
    }

    public void initialize() {
        setTitle("GameMaker");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);   
        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right,
                insets.top + windowHeight + insets.bottom);
        input = new InputHandler(this);
        map = new GameMap();
        camera = new Camera(windowWidth, windowHeight, map);
    }

    public void run() throws Exception {
        while(true) {
            long time = System.currentTimeMillis();
            update();
            render();
            long delay = (1000 / fps) - (System.currentTimeMillis() - time);
            if (delay > 0) {
                Thread.sleep(delay);
            }
        }
    }

    public void update() {

    }

    public void render() {
        Graphics2D g = (Graphics2D) backbuffer.getGraphics();
        g.drawImage(camera.image(), 0, 0, null);
        getGraphics().drawImage(backbuffer, insets.left, insets.top, this);
    }
}