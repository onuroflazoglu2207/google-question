import java.awt.Point;

public class Application02 {

    public static final boolean[][] array = {
            { true, false, false, false, false, true },
            { false, true, false, false, true, false },
            { false, false, true, true, false, false },
            { true, true, true, true, false, false },
            { false, true, false, false, true, false },
            { true, false, false, false, false, true } };

    public static void main(String[] args) {
        write(array);
        for (int y = 0; y < array.length; y++)
            for (int x = 0; x < array[y].length; x++)
                if (y == 0 || y == array.length - 1 || x == 0 || x == array.length - 1)
                    if (array[y][x])
                        check(new Point(x, y));
        write(array);
    }

    public static void check(Point p) {
        array[p.y][p.x] = false;
        Point[] points = { new Point(p.x - 1, p.y), new Point(p.x + 1, p.y),
                new Point(p.x, p.y - 1), new Point(p.x, p.y + 1) };
        for (Point t : points)
            if (checkNum(t))
                check(t);
    }

    public static boolean checkNum(Point p) {
        try {
            return array[p.y][p.x];
        } catch (Exception e) {
            return false;
        }
    }

    public static void write(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] ? "1 " : "0 ");
            System.out.println();
        }
        System.out.println();
    }
}
