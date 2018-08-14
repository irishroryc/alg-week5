import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac PointSET.java
 * Execution:  java PointSET
 * Dependencies: SET, Point2D
 * 
 * A mutable data type for a set of points in a unit square.
 * 
 * @author Rory
 */

public class PointSET {
  private SET<Point2D> pointSet = new SET<>();
  
//construct an empty set of points
   public PointSET() {}
   
// is the set empty? 
   public boolean isEmpty() {
      return pointSet.isEmpty();
   }
   
   // number of points in the set
   public int size() {
     return pointSet.size();
   }
   
// add the point to the set (if it is not null or already in the set)
   public void insert(Point2D p) {
     if (p == null) {
       throw new IllegalArgumentException("Cannot insert null point!");
     }
     pointSet.add(p);
   }
   
// does the set contain point p?
   public boolean contains(Point2D p) {
     if (p == null) {
       throw new IllegalArgumentException("Cannot pass null point!");
     }
     return(pointSet.contains(p));
   }
   
// draw all points to standard draw
   public void draw() {
     for (Point2D p : pointSet) {
       StdDraw.point(p.x(), p.y());
     }
   }
   
// all points that are inside the rectangle (or on the boundary)
   public Iterable<Point2D> range(RectHV rect) {
     if (rect == null) {
       throw new IllegalArgumentException("Cannot use null RectHV!");
     }
     
     List<Point2D> containedPoints = new ArrayList<>();
     for (Point2D p : pointSet) {
       if (rect.contains(p)) {
         containedPoints.add(p);
       }
     }
     return containedPoints;
   }
   
// a nearest neighbor in the set to point p; null if the set is empty
   public Point2D nearest(Point2D p) {
     if (p == null) {
       throw new IllegalArgumentException("Cannot check null point!");
     }
     Point2D nearestPoint = null;
     for (Point2D evalPoint : pointSet) {
       if (nearestPoint == null || evalPoint.distanceTo(p) < evalPoint.distanceTo(nearestPoint)) {
         nearestPoint = evalPoint;
       }
     }
     return nearestPoint;
   }
   
// unit testing of the methods (optional)
   public static void main(String[] args) {
     PointSET mySet = new PointSET();
     Point2D pt1 = new Point2D(0.5, 0.5);
     Point2D pt2 = new Point2D(0.2, 0.8);
     Point2D pt3 = new Point2D(0.7, 0.7);
     mySet.insert(pt1);
     mySet.insert(pt2);
     mySet.insert(pt3);
     
     RectHV myRect = new RectHV(0.4, 0.4, 0.6, 0.6);
     
     for (Point2D point : (mySet.range(myRect))) {
       StdOut.println("Rect contains - " + point.toString());
     }
   }
}