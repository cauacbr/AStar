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
        int h = 2;
        Map<String, Double> map = new HashMap<String, Double>();

        if (h == 1) {
            System.out.println("Heuristica 1");
            map.put("A", 32.0);
            map.put("B", 19.0);
            map.put("C", 25.0);
            map.put("D", 10.0);
            map.put("E", 8.0);
            map.put("F", 6.0);
            map.put("G", 12.0);
            map.put("H", 0.0);
        }

        if (h == 2) {
            System.out.println("Heuristica 2");
            map.put("A", 45.0);
            map.put("B", 25.0);
            map.put("C", 24.0);
            map.put("D", 13.0);
            map.put("E", 8.0);
            map.put("F", 6.0);
            map.put("G", 12.0);
            map.put("H", 0.0);
        }

        heuristic.put("A", map);
        heuristic.put("B", map);
        heuristic.put("C", map);
        heuristic.put("D", map);
        heuristic.put("E", map);
        heuristic.put("F", map);
        heuristic.put("G", map);
        heuristic.put("H", map);

        AmbienteAStar<String> graph = new AmbienteAStar<String>(heuristic);
        graph.adicionaNo("A");
        graph.adicionaNo("B");
        graph.adicionaNo("C");
        graph.adicionaNo("D");
        graph.adicionaNo("E");
        graph.adicionaNo("F");
        graph.adicionaNo("G");
        graph.adicionaNo("H");

        graph.adicionaFronteira("A", "B", 20);
        graph.adicionaFronteira("A", "C", 20);
        graph.adicionaFronteira("B", "D", 10);
        graph.adicionaFronteira("B", "F", 19);
        graph.adicionaFronteira("C", "G", 12);
        graph.adicionaFronteira("C", "H", 25);
        graph.adicionaFronteira("D", "E", 5);
        graph.adicionaFronteira("D", "F", 7);
        graph.adicionaFronteira("E", "H", 8);
        graph.adicionaFronteira("F", "H", 6);
        graph.adicionaFronteira("G", "H", 12);

        AgenteAstar<String> aStar = new AgenteAstar<String>(graph);

        /*Scanner sc = new Scanner(System.in);
        System.out.print("Digite o estado inicial: ");
        String inicio = sc.nextLine().toUpperCase();
        System.out.print("Digite o estado final: ");
        String fim = sc.nextLine().toUpperCase();
        System.out.println("Estado inicial: "+ inicio + "\nEstado Final: " + fim);*/
        String inicio = "A", fim = "H";
        System.out.println("Estado inicial: " + inicio + "\nEstado Final: " + fim);

        for (String path : aStar.astar(inicio, fim)) {
            System.out.print(" -> " + path);
        }
        System.out.println("");

    }

}
