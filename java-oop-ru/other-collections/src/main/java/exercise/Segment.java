package exercise;

// BEGIN
class Segment {

    final private Point startPoint;
    final private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return this.startPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getMidPoint() {
        int midPointX = (startPoint.getX() + endPoint.getX()) / 2;
        int midPointY = (startPoint.getY() + endPoint.getY()) / 2;
        return new Point(midPointX, midPointY);
    }
}
// END
