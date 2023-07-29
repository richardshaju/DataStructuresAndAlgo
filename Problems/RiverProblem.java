import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverProblem {
    public List<Integer> checkRiverSize(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {          //Traverseing through matrix
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                } else {
                    traverseThroughRiver(i, j, matrix, visited, sizes);
                }
            }
        }

        return sizes;
    }

    public void traverseThroughRiver(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;                              
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.add(new Integer[] { i, j });
        while (!nodesToExplore.empty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }

            currentRiverSize++;
            List<Integer[]> nearest = getNearestNodes(i, j, matrix, visited);
            nodesToExplore.addAll(nearest);
        }
        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    private List<Integer[]> getNearestNodes(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> nearset = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {     // checking whether it is in 1st row because 1st row didn't have [i-1]
            nearset.add(new Integer[] { i - 1, j });
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {  
            nearset.add(new Integer[] { i + 1, j });
        }
        if (j > 0 && !visited[i][j - 1]) {      // checking whether it is in 1st column because 1st column didn't have [j-1]
            nearset.add(new Integer[] { i, j - 1 });
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            nearset.add(new Integer[] { i, j + 1 });
        }

        return nearset;
    }

    public static void main(String[] args) {
        RiverProblem rp = new RiverProblem();

        int[][] matrix = { { 1, 0, 0, 1, 1 },   // 1 = River
                           { 0, 1, 0, 1, 0 },   // 2 = Land
                           { 0, 0, 1, 0, 1 },
                           { 1, 0, 0, 0, 1 } };

        List<Integer> result = rp.checkRiverSize(matrix);

        result.forEach(System.out::println);
    }
}
