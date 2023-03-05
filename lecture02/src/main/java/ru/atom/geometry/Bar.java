package ru.atom.geometry;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static jdk.nashorn.internal.objects.NativeMath.abs;

public class Bar implements Collider {
    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public Bar(int x1, int y1, int x2, int y2) {
        this.firstCornerX = x1;
        this.firstCornerY = y1;
        this.secondCornerX = x2;
        this.secondCornerY = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Bar bar = (Bar) o;

        return
                (this.firstCornerX == bar.firstCornerX
                        && this.firstCornerY == bar.firstCornerY
                        && this.secondCornerX == bar.secondCornerX
                        && this.secondCornerY == bar.secondCornerY)
                        ||
                        (this.firstCornerX == bar.secondCornerX
                                && this.firstCornerY == bar.secondCornerY
                                && this.secondCornerX == bar.firstCornerX
                                && this.secondCornerY == bar.firstCornerY)
                        ||
                        (this.firstCornerX == bar.secondCornerX
                                && this.firstCornerY == bar.firstCornerY
                                && this.secondCornerX == bar.firstCornerX
                                && this.secondCornerY == bar.secondCornerY)
                        ||
                        (this.firstCornerX == bar.firstCornerX
                                && this.firstCornerY == bar.secondCornerY
                                && this.secondCornerX == bar.secondCornerX
                                && this.secondCornerY == bar.firstCornerY);

        // your code here
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Bar) {
            return this.equals(other) || this.intersects(this, (Bar) other);
        }

        if (other instanceof Point) {
            return this.containsPoint(this, (Point) other);
        }

        return false;
    }

    private boolean intersects(Bar firstBar, Bar secondBar) {
        int firstBarLeftBorder = min(firstBar.firstCornerX, firstBar.secondCornerX);
        int firstBarRightBorder = max(firstBar.firstCornerX, firstBar.secondCornerX);
        int firstBarTopBorder = max(firstBar.firstCornerY, firstBar.secondCornerY);
        int firstBarBottomBorder = min(firstBar.firstCornerY, firstBar.secondCornerY);

        int secondBarLeftBorder = min(secondBar.firstCornerX, secondBar.secondCornerX);
        int secondBarRightBorder = max(secondBar.firstCornerX, secondBar.secondCornerX);
        int secondBarTopBorder = max(secondBar.firstCornerY, secondBar.secondCornerY);
        int secondBarBottomBorder = min(secondBar.firstCornerY, secondBar.secondCornerY);

        return !(secondBarLeftBorder > firstBarRightBorder
                || firstBarLeftBorder > secondBarRightBorder
                || firstBarTopBorder < secondBarBottomBorder
                || secondBarTopBorder < firstBarBottomBorder);
    }

    private boolean containsPoint(Bar bar, Point point) {
        int minX = min(bar.firstCornerX, secondCornerX);
        int minY = min(bar.firstCornerY, secondCornerY);
        int maxX = max(bar.firstCornerX, secondCornerX);
        int maxY = max(bar.firstCornerY, secondCornerY);
        return ((minX <= point.getX() && point.getX() <= maxX) && (minY <= point.getY() && point.getY() <= maxY));
    }
}
