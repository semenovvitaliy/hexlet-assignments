package exercise;

// BEGIN
class Circle {

    private final int radiusOfCircle;
    public Circle(Point centerOfCircle, int radiusOfCircle) {
        this.radiusOfCircle = radiusOfCircle;
    }

    public int getRadius() {
        return radiusOfCircle;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radiusOfCircle < 0) {
            throw new NegativeRadiusException("Ошибка! радиус окружности не может быть отрицательным.");
        }
        return Math.PI * radiusOfCircle * radiusOfCircle;
    }
}
// END
