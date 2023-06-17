package advanced.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(map, node);
    }

    public UndirectedGraphNode clone(Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            if(map.containsKey(neighbor.label)) cloneNode.neighbors.add(map.get(neighbor.label));
            else cloneNode.neighbors.add(clone(map, neighbor));
        }
        return cloneNode;
    }

}
