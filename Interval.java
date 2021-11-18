// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

public class Interval {
    public double left = 0;
    public double right = 0;

    public Interval(double left, double right) {
        if (left <= right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean contains(double x) {
        return (left <= x) && (x <= right);
    }

    public boolean intersects(Interval b) {
        if (this.left < b.left && b.right < this.left)
            return false;
        return true;
    }

    public double length() {
        return right - left;
    }

    public String toString() {
        return left + ", " + right;
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double d = Double.parseDouble(args[3]);
        Interval interval1 = new Interval(a, b);
        Interval interval2 = new Interval(c, d);
        System.out.println("length1: " + interval1.length());
        System.out.println("length2: " + interval2.length());
        System.out.println("intersect: " + interval1.intersects(interval2));
        System.out.println("interval1 contains 0: " + interval1.contains(0));
        System.out.println("interval2 contains 0: " + interval2.contains(0));
    }
}
