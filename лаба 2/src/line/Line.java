package line;

public class Line {

    private Point start;

    private Point end;

    public Line() {
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1,y1);
        this.end = new Point(x2, y2);
    }

    public double getGradient() {
        double cos = Math.round((start.getX() * end.getX() + start.getY() * end.getY()) / (Math.sqrt(start.getX() * start.getX() + start.getY() * start.getY()) * Math.sqrt(end.getX() * end.getX() + end.getY()* end.getY())));
        return cos * 180 / Math.PI;
    }

    public double distance(int x, int y) {
        double double_area = Math.abs((end.getY()-start.getY())*x - (end.getX()-start.getY())*y + end.getX()*start.getY() - end.getY()*start.getX());
        double line_segment_length = Math.sqrt((end.getX()-start.getX())*(end.getX()-start.getX()) + (end.getY()-start.getY())*(end.getY()-start.getY()));
        return double_area / line_segment_length;
    }

    public double distance(Point point) {
        double double_area = Math.abs((end.getY()-start.getY())*point.getX() - (end.getX()-start.getY())*point.getY() + end.getX()*start.getY() - end.getY()*start.getX());
        double line_segment_length = Math.sqrt((end.getX()-start.getX())*(end.getX()-start.getX()) + (end.getY()-start.getY())*(end.getY()-start.getY()));
        return double_area / line_segment_length;
    }

    public boolean intersects(Line line) {
        double A1 = (start.getY() - end.getY()) / (start.getX() - end.getX());
        double A2 = (line.start.getY() - line.end.getY()) / (line.start.getX() - line.end.getX());
        double b1 = start.getY() - A1 * start.getX();
        double b2 = line.start.getY() - A2 * line.start.getX();

        double Xa = (b2 - b1) / (A1 - A2);
        if ((Xa < Math.max(start.getX(), line.start.getX())) || (Xa > Math.min(end.getX(), line.end.getX()))) {
            return false;
        }
        else {
            return true;
        }

    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int[] getStartXY() {
        return new int[]{start.getX(),start.getY()};
    }

    public void setStartXY(int x, int y) {
        start = new Point(x,y);
    }

    public int[] getEndXY() {
        return new int[]{end.getX(),end.getY()};
    }

    public void setEndXY(int x, int y) {
        end = new Point(x,y);
    }

}
