package astar;

import java.util.HashMap;
import java.util.Map;
public class Aestrela {

    public static void main(String[] args) {
        Map<String, Map<String, Double>> heuristica = new HashMap<String, Map<String, Double>>();
        int h = 2; //seleciona a Heuristica (1 ou 2)
        Map<String, Double> mapaHeuristica = new HashMap<String, Double>();

        if (h == 1) {
            System.out.println("Heuristica 1");
            mapaHeuristica.put("A", 32.0);
            mapaHeuristica.put("B", 19.0);
            mapaHeuristica.put("C", 25.0);
            mapaHeuristica.put("D", 10.0);
            mapaHeuristica.put("E", 8.0);
            mapaHeuristica.put("F", 6.0);
            mapaHeuristica.put("G", 12.0);
            mapaHeuristica.put("H", 0.0);
        }

        if (h == 2) {
            System.out.println("Heuristica 2");
            mapaHeuristica.put("A", 45.0);
            mapaHeuristica.put("B", 25.0);
            mapaHeuristica.put("C", 24.0);
            mapaHeuristica.put("D", 13.0);
            mapaHeuristica.put("E", 8.0);
            mapaHeuristica.put("F", 6.0);
            mapaHeuristica.put("G", 12.0);
            mapaHeuristica.put("H", 0.0);
        }

        heuristica.put("A", mapaHeuristica);
        heuristica.put("B", mapaHeuristica);
        heuristica.put("C", mapaHeuristica);
        heuristica.put("D", mapaHeuristica);
        heuristica.put("E", mapaHeuristica);
        heuristica.put("F", mapaHeuristica);
        heuristica.put("G", mapaHeuristica);
        heuristica.put("H", mapaHeuristica);

        AmbienteAStar<String> grafo = new AmbienteAStar<String>(heuristica);
        grafo.adicionaNo("A");
        grafo.adicionaNo("B");
        grafo.adicionaNo("C");
        grafo.adicionaNo("D");
        grafo.adicionaNo("E");
        grafo.adicionaNo("F");
        grafo.adicionaNo("G");
        grafo.adicionaNo("H");

        grafo.adicionaFronteira("A", "B", 20);
        grafo.adicionaFronteira("A", "C", 20);
        grafo.adicionaFronteira("B", "D", 10);
        grafo.adicionaFronteira("B", "F", 19);
        grafo.adicionaFronteira("C", "G", 12);
        grafo.adicionaFronteira("C", "H", 25);
        grafo.adicionaFronteira("D", "E", 5);
        grafo.adicionaFronteira("D", "F", 7);
        grafo.adicionaFronteira("E", "H", 8);
        grafo.adicionaFronteira("F", "H", 6);
        grafo.adicionaFronteira("G", "H", 12);

        AgenteAstar<String> aEstrela = new AgenteAstar<String>(grafo);
        String inicio = "A", fim = "H"; //seleciona estado inicial e final
        System.out.println("Estado inicial: " + inicio + "\nEstado Final: " + fim);

        for (String caminho : aEstrela.astar(inicio, fim)) {
            System.out.print(" -> " + caminho);
        }
        System.out.println("");

    }

}
