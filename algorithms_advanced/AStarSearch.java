import java.util.*;

public class AStarSearch {
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    public static void main(String[] args) {
     int[][] grid = {
    {1, 1, 1, 1},
    {1, 0, 0, 1},
    {1, 1, 1, 1}
};

        int[] start = {0, 0};
        int[] end = {grid.length - 1, grid[0].length - 1};

        System.out.println(search(grid, start, end));
    }

    public static double findH(int[] src, int[] dest) {
        return Math.sqrt(Math.pow(src[0] - dest[0], 2) + Math.pow(src[1] - dest[1], 2));
    }

    public static String search(int[][] grid, int[] src, int[] dest) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Cell[][] cells = new Cell[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells[i][j] = new Cell(i, j);

        // initialize start cell
        cells[src[0]][src[1]].g = 0;
        cells[src[0]][src[1]].h = findH(src, dest);
        cells[src[0]][src[1]].f = cells[src[0]][src[1]].h;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Double.compare(a.f, b.f));
        pq.offer(cells[src[0]][src[1]]);

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            if (vis[cell.i][cell.j]) continue;
            vis[cell.i][cell.j] = true;

            if (cell.i == dest[0] && cell.j == dest[1]) {
                return reconstructPath(cells, dest);
            }

            for (int k = 0; k < 4; k++) {
                int nrow = cell.i + drow[k];
                int ncol = cell.j + dcol[k];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] != 0) {
                    double newG = cell.g + 1;
                    double newH = findH(new int[]{nrow, ncol}, dest);
                    double newF = newG + newH;

                    if (newF < cells[nrow][ncol].f) {
                        cells[nrow][ncol].g = newG;
                        cells[nrow][ncol].h = newH;
                        cells[nrow][ncol].f = newF;
                        cells[nrow][ncol].parent = new int[]{cell.i, cell.j};
                        pq.offer(cells[nrow][ncol]);
                    }
                }
            }
        }

        return "No path found";
    }

    public static String reconstructPath(Cell[][] cells, int[] dest) {
        Stack<Cell> stack = new Stack<>();
        Cell cur = cells[dest[0]][dest[1]];

        while (cur != null) {
            stack.push(cur);
            if (cur.parent == null) break;
            cur = cells[cur.parent[0]][cur.parent[1]];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Cell c = stack.pop();
            sb.append("(").append(c.i).append(",").append(c.j).append(")->");
        }
        sb.append("END");
        return sb.toString();
    }
}

class Cell {
    int[] parent;
    double f = Double.MAX_VALUE;
    double g = Double.MAX_VALUE;
    double h = 0;
    int i, j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
