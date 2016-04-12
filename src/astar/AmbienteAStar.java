package astar;

/*
@Cauã Barneze Rocha
@Rafael Henrique Zaleski
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class AmbienteAStar<T> implements Iterable<T> {


    private final Map<T, Map<NoData<T>, Double>> grafo;
    private final Map<T, Map<T, Double>> mapaHeuristica;
    private final Map<T, NoData<T>> noIdData;

    public AmbienteAStar(Map<T, Map<T, Double>> heuristicaMap) {
        if (heuristicaMap == null) {
            throw new NullPointerException("O mapa de heuristica não pode ser nulo!");
        }
        grafo = new HashMap<T, Map<NoData<T>, Double>>();
        noIdData = new HashMap<T, NoData<T>>();
        this.mapaHeuristica = heuristicaMap;
    }

    public void adicionaNo(T noId) {
        if (noId == null) {
            throw new NullPointerException("O no não pode ser nulo!");
        }
        if (!mapaHeuristica.containsKey(noId)) {
            throw new NoSuchElementException("Este no não faz parte do mapa de heuristica");
        }

        grafo.put(noId, new HashMap<NoData<T>, Double>());
        noIdData.put(noId, new NoData<T>(noId, mapaHeuristica.get(noId)));
    }

    public void adicionaFronteira(T noIdPrimeiro, T noIdSegundo, double tamanhoFronteira) {
        if (noIdPrimeiro == null || noIdSegundo == null) {
            throw new NullPointerException("Nem o primeiro quanto o segundo no podem ser nulos.");
        }

        if (!mapaHeuristica.containsKey(noIdPrimeiro) || !mapaHeuristica.containsKey(noIdSegundo)) {
            throw new NoSuchElementException("Primeiro e segundo no devem fazer parte do mapa de heuristica");
        }
        if (!grafo.containsKey(noIdPrimeiro) || !grafo.containsKey(noIdSegundo)) {
            throw new NoSuchElementException("Origem e destino devem fazer parte do grafo");
        }

        grafo.get(noIdPrimeiro).put(noIdData.get(noIdSegundo), tamanhoFronteira);
        grafo.get(noIdSegundo).put(noIdData.get(noIdPrimeiro), tamanhoFronteira);
    }

    public Map<NoData<T>, Double> fronteiraLista(T nodeId) {
        if (nodeId == null) {
            throw new NullPointerException("No de entrada nao pode ser nulo.");
        }
        if (!mapaHeuristica.containsKey(nodeId)) {
            throw new NoSuchElementException("Este no não faz parte do mapa de heuristica");
        }
        if (!grafo.containsKey(nodeId)) {
            throw new NoSuchElementException("O no não pode ser nulo.");
        }

        return Collections.unmodifiableMap(grafo.get(nodeId));
    }

    public NoData<T> getNoData(T nodeId) {
        if (nodeId == null) {
            throw new NullPointerException("O noId não pode estar vazio");
        }
        if (!noIdData.containsKey(nodeId)) {
            throw new NoSuchElementException("O noId não existe");
        }
        return noIdData.get(nodeId);
    }

    @Override
    public Iterator<T> iterator() {
        return grafo.keySet().iterator();
    }
}
