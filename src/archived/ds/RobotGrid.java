package archived.ds;

public class RobotGrid {

    public static void main(String[] args) {
        RobotGrid robotGrid = new RobotGrid();
        robotGrid.robotWalk(4,3);
    }

    public void robotWalk(int x, int y) {
        robotWalkInternal(Point.create(x, y));
    }

    private Point robotWalkInternal(Point p) {

        if(p.x == 1 || p.y == 1) {
            return new Point(1,1).print();
        }

        Point res = robotWalkInternal(Point.create(p.x-1, p.y-1));
        while (!res.check(p)){
            res.move(p);
        }
        return res;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Point p) {
        this.right(p);
        this.down(p);
    }

    private void down(Point p) {
        if(x + 1 <= p.x) {
            x += 1;
            this.print();
        }
    }

    private void right(Point p) {
        if(y + 1 <= p.y) {
            y += 1;
            this.print();
        }
    }

    public boolean check(Point p) {
        return p.x == this.x && p.y == this.y;
    }

    public Point print() {
        System.out.printf("(%d, %d)\n", x, y);
        return this;
    }

    public static Point create(int x, int y) {
        return new Point(x, y);
    }
}
