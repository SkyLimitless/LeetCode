package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aakash on 1/25/2017.
 */

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class Problem133_CloneGraph {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(node.label);
        map.put(undirectedGraphNode.label, undirectedGraphNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            undirectedGraphNode.neighbors.add(cloneGraph(neighbor));
        }
        return undirectedGraphNode;
    }
}
