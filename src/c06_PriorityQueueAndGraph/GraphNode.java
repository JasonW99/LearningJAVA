package c06_PriorityQueueAndGraph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    GraphNode(int key){
        this.key = key;
        this.neighbors = new LinkedList<GraphNode>();
    }
}
