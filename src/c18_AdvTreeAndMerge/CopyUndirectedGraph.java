package c18_AdvTreeAndMerge;

import c04_LinkedList.ListNode;

import java.util.*;

class GraphNode {
    int key;
    List<GraphNode> neighbors;
    GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
}


public class CopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        List<GraphNode> result = new ArrayList<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode curr : graph) {
            if (map.get(curr) == null) {
                map.put(curr, new GraphNode(curr.key));
            }
            GraphNode resultCurr = map.get(curr);
            for (GraphNode currNeighbor : curr.neighbors) {
                if (map.get(currNeighbor) == null) {
                    map.put(currNeighbor, new GraphNode(currNeighbor.key));
                }
                resultCurr.neighbors.add(map.get(currNeighbor));
            }
            result.add(resultCurr);
        }
        return result;
    }
}

/**
public class CopyUndirectedGraph {
    class Node {
        int value;
        List<Node> neighbors;
    }

    public Node cloneGraph(Node input, Map<Node, Node> lookup) {
        if (input == null) {
            return null;
        }
        if (lookup.containsKey(input)) {
            return lookup.get(input);
        }
        Node copyNode = new Node(input.value);
        lookup.put(input, copyNode);
        for (Node neighbor : input.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor, lookup));
        }
        return copyNode;
    }
}
**/
/**
public class Solution {
    public List<GraphNode> copy(List<GraphNode> graph) {
        List<GraphNode> result = new ArrayList<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node: graph) {
            GraphNode node_copy = map.get(node);
            if (node_copy == null) {
                node_copy = new GraphNode(node.key);
                map.put(node, node_copy);
            }
            List<GraphNode> neighbors_copy = new ArrayList<>();
            for (GraphNode neighbor: node.neighbors) {
                GraphNode nei_copy = map.get(neighbor);
                if (nei_copy == null) {
                    nei_copy = new GraphNode(neighbor.key);
                    map.put(neighbor, nei_copy);
                }
                neighbors_copy.add(nei_copy);
            }
            node_copy.neighbors = neighbors_copy;
            result.add(node_copy);
        }
        return result;
    }
}
 **/