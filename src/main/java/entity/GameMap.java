package entity;

public class GameMap extends Rectangular {
    private int tileWidth, tileHeight;

    public GameMap() {
        this(100, 100);
    }

    public GameMap(int w, int h) {
        super(0, w * 10, 0, h * 10);
        tileWidth = w;
        tileHeight = h;
    }

    public int tileWidth() {
        return tileWidth;
    }

    public int tileHeight() {
        return tileHeight;
    }

    public int tileTotal() {
        return tileWidth * tileHeight;
    }
}