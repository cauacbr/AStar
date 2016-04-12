/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        Map<String, Double> mapA = new HashMap<String, Double>();
        mapA.put("A", 0.0);
        mapA.put("B", 20.0);
        mapA.put("C", 20.0);
        mapA.put("D", 0.0);
        mapA.put("E", 0.0);
        mapA.put("F", 0.0);
        mapA.put("G", 0.0);
        mapA.put("H", 0.0);

        // map for B    
        Map<String, Double> mapB = new HashMap<String, Double>();
        mapB.put("A", 20.0);
        mapB.put("B", 0.0);
        mapB.put("C", 0.0);
        mapB.put("D", 10.0);
        mapB.put("E", 0.0);
        mapB.put("G", 0.0);
        mapB.put("F", 19.0);
        mapB.put("G", 0.0);
        mapB.put("H", 0.0);

        // map for C    
        Map<String, Double> mapC = new HashMap<String, Double>();
        mapC.put("A", 20.0);
        mapC.put("B", 0.0);
        mapC.put("C", 0.0);
        mapC.put("D", 0.0);
        mapC.put("E", 0.0);
        mapC.put("F", 0.0);
        mapC.put("G", 10.0);
        mapC.put("H", 25.0);

        // map for D    
        Map<String, Double> mapD = new HashMap<String, Double>();
        mapD.put("A", 0.0);
        mapD.put("B", 10.0);
        mapD.put("C", 0.0);
        mapD.put("D", 0.0);
        mapD.put("E", 5.0);
        mapD.put("F", 7.0);
        mapD.put("G", 0.0);
        mapD.put("H", 0.0);

        // map for E    
        Map<String, Double> mapE = new HashMap<String, Double>();
        mapE.put("A", 0.0);
        mapE.put("B", 0.0);
        mapE.put("C", 0.0);
        mapE.put("D", 5.0);
        mapE.put("E", 0.0);
        mapE.put("F", 0.0);
        mapE.put("G", 0.0);
        mapE.put("H", 8.0);

        // map for F    
        Map<String, Double> mapF = new HashMap<String, Double>();
        mapF.put("A", 0.0);
        mapF.put("B", 19.0);
        mapF.put("C", 0.0);
        mapF.put("D", 7.0);
        mapF.put("E", 0.0);
        mapF.put("F", 0.0);
        mapF.put("G", 0.0);
        mapF.put("H", 6.0);

        // map for G    
        Map<String, Double> mapG = new HashMap<String, Double>();
        mapG.put("A", 0.0);
        mapG.put("B", 12.0);
        mapG.put("C", 0.0);
        mapG.put("E", 0.0);
        mapG.put("F", 0.0);
        mapG.put("G", 0.0);
        mapG.put("H", 12.0);

        // map for H   
        Map<String, Double> mapH = new HashMap<String, Double>();
        mapH.put("A", 0.0);
        mapH.put("B", 0.0);
        mapH.put("C", 25.0);
        mapH.put("D", 0.0);
        mapH.put("E", 8.0);
        mapH.put("F", 6.0);
        mapH.put("G", 12.0);
        mapH.put("H", 0.0);

        heuristic.put("A", mapA);
        heuristic.put("B", mapB);
        heuristic.put("C", mapC);
        heuristic.put("D", mapD);
        heuristic.put("E", mapE);
        heuristic.put("F", mapF);
        heuristic.put("G", mapG);
        heuristic.put("H", mapH);

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
        graph.addEdge("B", "A", 20);
        graph.addEdge("B", "D", 10);
        graph.addEdge("B", "F", 19);
        graph.addEdge("C", "A", 20);
        graph.addEdge("C", "G", 12);
        graph.addEdge("C", "H", 25);
        graph.addEdge("D", "B", 10);
        graph.addEdge("D", "E", 5);
        graph.addEdge("D", "F", 7);
        graph.addEdge("E", "D", 5);
        graph.addEdge("E", "H", 8);
        graph.addEdge("F", "B", 19);
        graph.addEdge("F", "D", 7);
        graph.addEdge("F", "H", 6);
        graph.addEdge("G", "C", 12);
        graph.addEdge("G", "H", 12);
        graph.addEdge("H", "C", 25);
        graph.addEdge("H", "E", 8);
        graph.addEdge("H", "F", 6);
        graph.addEdge("H", "G", 12);

        AStar<String> aStar = new AStar<String>(graph);
        for (String path : aStar.astar("A", "H")) {
            System.out.print(path + " -> ");
        }
    }

}
