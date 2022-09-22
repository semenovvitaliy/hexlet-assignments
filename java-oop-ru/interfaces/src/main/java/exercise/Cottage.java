package exercise;

// BEGIN
class Cottage implements Home {

    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }

    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }
}
// END
