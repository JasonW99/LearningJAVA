package c06_PriorityQueueAndGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bipartite {
    public boolean solve(List<GraphNode> graph) {
        Map<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
        int group = 0;
        Integer currGroup = null;
        Integer neighborGroup = null;
        for (GraphNode curr : graph) {
            currGroup = map.get(curr);
            if (currGroup == null) {
                currGroup = 1;
                map.put(curr, currGroup);
            }
            for (GraphNode neighbor : curr.neighbors) {
                neighborGroup = map.get(neighbor);
                if (neighborGroup == currGroup) {
                    return false;
                }
                if (neighborGroup == null) {
                    map.put(neighbor, 1 - currGroup);
                }
            }
        }
        return true;
    }
}
