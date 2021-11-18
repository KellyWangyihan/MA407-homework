// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

public class Rectangle {
    private double width = 0;
    private double height = 0;
    Interval xinterval;
    Interval yinterval;
    private double xinterval_left;
    private double xinterval_right;
    private double yinterval_left;
    private double yinterval_right;

    public Rectangle(Interval xinterval, Interval yinterval) {
        if ((xinterval.length() > 0) && (yinterval.length() > 0)) {
            this.width = xinterval.length();
            this.height = yinterval.length();
        }
        this.xinterval = xinterval;
        this.yinterval = yinterval;
        this.xinterval_left = xinterval.left;
        this.xinterval_right = xinterval.right;
        this.yinterval_left = yinterval.left;
        this.yinterval_right = yinterval.right;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return width * 2 + height * 2;
    }

    public boolean intersectRectangle(Rectangle b) {
        if (xinterval.intersects(b.xinterval) && yinterval.intersects(b.yinterval)) {
            return true;
        }
        return false;
    }

    public boolean containRectangle(Rectangle b) {
        if (this.xinterval.contains(b.xinterval_left) && this.xinterval.contains(b.xinterval_right)
                &&
                this.yinterval.contains(b.yinterval_left) && this.yinterval
                .contains(b.yinterval_right)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Interval xinterval1 = new Interval(1, 10);
        Interval yinterval1 = new Interval(3, 13);
        Rectangle rectangle1 = new Rectangle(xinterval1, yinterval1);

        Interval xinterval2 = new Interval(4, 5);
        Interval yinterval2 = new Interval(6, 30);
        Rectangle rectangle2 = new Rectangle(xinterval2, yinterval2);

        System.out.println(
                "Rectangle 1: [" + xinterval1.toString() + "] * [" + yinterval1.toString() + "]");
        System.out.println("Rectangle 1 area: " + rectangle1.area());
        System.out.println("Rectangle 1 perimeter: " + rectangle1.perimeter());
        System.out.println(
                "Rectangle 2: [" + xinterval2.toString() + "] * [" + yinterval2.toString() + "]");
        System.out.println("Rectangle 2 area: " + rectangle2.area());
        System.out.println("Rectangle 2 perimeter: " + rectangle2.perimeter());
        System.out.println(
                "Rectangle 1 intersects Rectangle 2: " + rectangle1.intersectRectangle(rectangle2));
        System.out.println(
                "Rectangle 1 contains Rectangle 2: " + rectangle1.containRectangle(rectangle2));
    }
}
