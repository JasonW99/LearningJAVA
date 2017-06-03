package c06_PriorityQueueAndGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bipartite {
    public boolean solve(List<GraphNode> graph) {
        Map<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
        for (GraphNode curr : graph) {
            Integer color = map.get(curr);
            if (color == null) {
                color = 1;
                map.put(curr, color);
            }
            for (GraphNode currNeighbor : curr.neighbors) {
                Integer neighborColor = map.get(currNeighbor);
                if (neighborColor == null){
                    map.put(currNeighbor, 1 - color);
                } else if (neighborColor == color) {
                    return false;
                }
            }
        }
        return true;
    }
}
