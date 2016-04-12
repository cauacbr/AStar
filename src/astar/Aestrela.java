/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://codereview.stackexchange.com/questions/38376/a-search-algorithm
 */
package astar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cauã
 */
public class Aestrela {

    public static void main(String[] args) {
        Map<String, Map<String, Double>> heuristic = new HashMap<String, Map<String, Double>>();
        // map for A    
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("A", 0.0);
        map.put("B", 0.0);
        map.put("C", 0.0);
        map.put("D", 0.0);
        map.put("E", 0.0);
        map.put("F", 0.0);
        map.put("G", 0.0);
        map.put("H", 0.0);

        heuristic.put("A", map);
        heuristic.put("B", map);
        heuristic.put("C", map);
        heuristic.put("D", map);
        heuristic.put("E", map);
        heuristic.put("F", map);
        heuristic.put("G", map);
        heuristic.put("H", map);

        GraphAStar<String> graph = new GraphAStar<String>(heuristic);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        
        
        graph.addEdge("A", "B", 20);
        graph.addEdge("A", "C", 20);
        graph.addEdge("B", "D", 10);
        graph.addEdge("B", "F", 19);
        graph.addEdge("C", "G", 12);
        graph.addEdge("C", "H", 25);
        graph.addEdge("D", "E", 5);
        graph.addEdge("D", "F", 7);
        graph.addEdge("E", "H", 8);
        graph.addEdge("F", "H", 6);
        graph.addEdge("G", "H", 12);

        AStar<String> aStar = new AStar<String>(graph);
        for (String path : aStar.astar("A", "H")) {
            System.out.print(" -> " +path);
        }
        
    }

}
