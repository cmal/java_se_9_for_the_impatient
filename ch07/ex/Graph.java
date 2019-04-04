package ch07.ex;

import ch07.ex.GraphVertex;
import ch07.ex.GraphEdge;
import java.util.*;

public class Graph { // DIRECTED for simple
    HashMap<String, GraphVertex> vertices; // 顶点列表 list of vertex, keyed by string

    // Graph(boolean isDirected) {
    Graph(boolean isDirected) {
        vertices = new HashMap<>();
    }

    public void addVertex(GraphVertex v) {
        vertices.put(v.getKey(), v);
    }

    public GraphVertex getVertexByKey(String key) {
        return vertices.get(key);
    }

    public void addEdge(GraphEdge e) {
        GraphVertex startV = getVertexByKey(e.startVertex.getKey());
        GraphVertex endV   = getVertexByKey(e.  endVertex.getKey());
        if (startV == null) {
            addVertex(startV);
        }
        if (endV == null) {
            addVertex(endV);
        }
        if (this.edges)
    }
}
