package entity;

public abstract class Rectangular {
    private int left, right, top, bottom;

    public Rectangular(int l, int r, int t, int b) {
        left = l;
        right = r;
        top = t;
        bottom = b;
    }

    public int left() {
        return left;
    }

    public int right() {
        return right;
    }

    public int top() {
        return top;
    }

    public int bottom() {
        return bottom;
    }

    public int height() {
        return Math.abs(bottom - top);
    }

    public int width() {
        return Math.abs(right - left);
    }

    public int[] rect() {
        return new int[] {left(), top(), width(), height()};
    }

    public double[] center() {
        return new double[] {left() + width() / 2.0, top() + height() / 2.0};
    }
}