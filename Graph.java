import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    private void addVertex(T data) {
        map.put(data, new ArrayList<>());
    }

    public void insert(T vertex, T edge, boolean isBidirectional) {
        if (!map.containsKey(vertex)) {
            addVertex(vertex);
        }
        if (!map.containsKey(edge)) {
            addVertex(edge);
        }

        map.get(vertex).add(edge);

        if (isBidirectional) {
            map.get(edge).add(vertex);
        }
    }



    public void display() {
        for (T i : map.keySet()) {
            System.out.print(i + ": ");
            for (T j : map.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.insert("Richard", "Albin", true);
        graph.insert("Leo", "Richard", true);
        graph.insert("Paul" ,"Richard", true);
        graph.insert("Albin","Paul", false);

        graph.display();

    }
}
