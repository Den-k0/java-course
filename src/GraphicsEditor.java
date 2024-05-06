// Головний клас програми
public class GraphicsEditor {
    // Внутрішній клас Circle
    public class Circle {
        private int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public void draw() {
            System.out.println("Draw circle with radius " + radius);
        }
    }

    // Вкладений (статично вкладений) клас Square
    public static class Square {
        private int sideLength;

        public Square(int sideLength) {
            this.sideLength = sideLength;
        }

        public void draw() {
            System.out.println("Draw square with side length " + sideLength);
        }
    }

    // Локальний клас Curve
    public void drawCurve() {
        class Curve {
            public void draw() {
                System.out.println("Draw curve");
            }
        }
        Curve curve = new Curve();
        curve.draw();
    }

    // Клас Line, який має асоціацію з класом Point
    public class Line {
        private Point startPoint;
        private Point endPoint;

        public Line(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        public void draw() {
            System.out.println("Draw line from " + startPoint + " to " + endPoint);
        }
    }

    // Клас Point для асоціації з класом Line
    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Головний метод
    public static void main(String[] args) {
        GraphicsEditor editor = new GraphicsEditor();

        Circle circle = editor.new Circle(5); // Створення екземпляру внутрішнього класу
        circle.draw();

        Square square = new Square(8); // Створення екземпляру вкладеного (статичного) класу
        square.draw();

        editor.drawCurve(); // Виклик методу з локального класу

        Point startPoint = editor.new Point(0, 0);
        Point endPoint = editor.new Point(10, 10);
        Line line = editor.new Line(startPoint, endPoint); // Створення екземпляру класу, що має асоціацію з іншим класом
        line.draw();
    }
}