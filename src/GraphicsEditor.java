import java.util.*;

public class GraphicsEditor {

    public static class Circle {
        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Circle circle = (Circle) o;
            return radius == circle.radius;
        }

        public int hashCode() {
            return Objects.hash(radius);
        }

        public String toString() {
            return "Circle{" +
                    "radius=" + radius +
                    '}';
        }
    }

    public static class Square implements Comparable<Square> {
        private final int sideLength;

        public Square(int sideLength) {
            this.sideLength = sideLength;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square square = (Square) o;
            return sideLength == square.sideLength;
        }

        public int hashCode() {
            return Objects.hash(sideLength);
        }

        public int compareTo(Square o) {
            return Integer.compare(this.sideLength, o.sideLength);
        }

        public String toString() {
            return "Square{" +
                    "sideLength=" + sideLength +
                    '}';
        }
    }

    public static class Line implements Comparable<Line> {
        private final Point startPoint;
        private final Point endPoint;

        public Line(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Objects.equals(startPoint, line.startPoint) && Objects.equals(endPoint, line.endPoint);
        }

        public int hashCode() {
            return Objects.hash(startPoint, endPoint);
        }

        public int compareTo(Line o) {
            int compareStart = this.startPoint.compareTo(o.startPoint);
            if (compareStart != 0) {
                return compareStart;
            }
            return this.endPoint.compareTo(o.endPoint);
        }

        public String toString() {
            return "Line{" +
                    "startPoint=" + startPoint +
                    ", endPoint=" + endPoint +
                    '}';
        }
    }

    public static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int compareTo(Point o) {
            int compareX = Integer.compare(this.x, o.x);
            if (compareX != 0) {
                return compareX;
            }
            return Integer.compare(this.y, o.y);
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);
        Circle circle3 = new Circle(5); // Duplicate

        Square square1 = new Square(8);
        Square square2 = new Square(4);
        Square square3 = new Square(8); // Duplicate

        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        Point point3 = new Point(0, 0); // Duplicate

        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point2, point1);
        Line line3 = new Line(point1, point2); // Duplicate

        // 1. Додавання елементів у невпорядкований список
        List<Object> list = new ArrayList<>();
        list.add(circle1);
        list.add(circle2);
        list.add(circle3);
        list.add(square1);
        list.add(square2);
        list.add(square3);
        list.add(point1);
        list.add(point2);
        list.add(point3);
        list.add(line1);
        list.add(line2);
        list.add(line3);

        System.out.println("Unordered List:");
        list.forEach(System.out::println);

        // 2. Додавання елементів в HashSet
        Set<Object> set = new HashSet<>(list);
        System.out.println("\nHashSet (Unique Elements):");
        set.forEach(System.out::println);

        // 3. Сортування списку за довільним критерієм
        List<Square> squareList = list.stream()
                .filter(e -> e instanceof Square)
                .map(e -> (Square) e).sorted().toList();
        System.out.println("\nSorted List of Squares:");
        squareList.forEach(System.out::println);

        // 4. Додавання елементів в TreeSet
        Set<Square> treeSet = new TreeSet<>();
        treeSet.add(square1);
        treeSet.add(square2);
        treeSet.add(square3);
        System.out.println("\nTreeSet (Sorted Unique Squares):");
        treeSet.forEach(System.out::println);

        // 5. Створення відображення (Map)
        Map<String, Circle> circleMap = new TreeMap<>();
        circleMap.put("Small Circle", circle1);
        circleMap.put("Large Circle", circle2);
        circleMap.put("Duplicate Circle", circle3);
        System.out.println("\nTreeMap (Circles):");
        circleMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // 6. Використання LinkedList
        LinkedList<Line> linkedList = new LinkedList<>();
        linkedList.add(line1);
        linkedList.add(line2);
        linkedList.add(line3);
        System.out.println("\nLinkedList:");
        linkedList.forEach(System.out::println);

        // 7. Використання ArrayList
        ArrayList<Point> arrayList = new ArrayList<>();
        arrayList.add(point1);
        arrayList.add(point2);
        arrayList.add(point3);
        System.out.println("\nArrayList:");
        arrayList.forEach(System.out::println);

        // 8. Використання Queue
        Queue<Square> queue = new LinkedList<>();
        queue.add(square1);
        queue.add(square2);
        queue.add(square3);
        System.out.println("\nQueue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // 9. Використання PriorityQueue
        PriorityQueue<Line> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(line1);
        priorityQueue.add(line2);
        priorityQueue.add(line3);
        System.out.println("\nPriorityQueue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}