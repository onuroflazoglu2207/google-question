import java.util.*;
import java.awt.Point;

public class Application01 {

    public static final boolean[][] array = {
            { true, false, false, false, false, false },
            { false, true, false, true, true, true },
            { false, false, true, false, true, false },
            { true, true, false, false, true, false },
            { true, false, true, true, false, false },
            { true, false, false, false, false, true } };

    public static void main(String[] args) {
        write(array);
        for (int y = 0; y < array.length; y++)
            for (int x = 0; x < array[y].length; x++)
                if (y == 0 || y == array.length - 1 || x == 0 || x == array.length - 1)
                    if (array[y][x])
                        check(new Point(x, y), new Point(x, y), new ArrayList<Point>());
        write(array);
    }

    public static boolean check(Point c, Point p, List<Point> seen) {
        Point[] points = { new Point(c.x - 1, c.y), new Point(c.x + 1, c.y),
                new Point(c.x, c.y - 1), new Point(c.x, c.y + 1) };
        seen.add(c);
        int[] states = { checkChild(points[0], p, seen), checkChild(points[1], p, seen),
                checkChild(points[2], p, seen), checkChild(points[3], p, seen) };
        for (int i : states)
            if (i == -1)
                return false;
        for (int i = 0; i < states.length; i++)
            if (states[i] == 1 && check(points[i], c, seen))
                states[i] = 0;
        if (!Arrays.stream(states).allMatch(i -> i == 0))
            return false;
        array[c.y][c.x] = false;
        return true;
    }

    public static int checkChild(Point c, Point p, List<Point> seen) {
        try {
            if (c == null || c.equals(p) || !array[c.y][c.x])
                return 0;// not check
            if (seen == null || !seen.contains(c))
                return 1;// need check
            return -1;// check is false
        } catch (Exception e) {
            return 0;// not check
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
