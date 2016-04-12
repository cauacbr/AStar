package astar;

/*
@Cauã Barneze Rocha
@Rafael Henrique Zaleski
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AgenteAstar<T> {

    private final AmbienteAStar<T> graph;

    public AgenteAstar(AmbienteAStar<T> graphAStar) {
        this.graph = graphAStar;
    }

   public class NodeComparator implements Comparator<NoData<T>> {

        public int compare(NoData<T> noPrimeiro, NoData<T> noSegundo) {
            if (noPrimeiro.getF() > noSegundo.getF()) {
                return 1;
            }
            if (noSegundo.getF() > noPrimeiro.getF()) {
                return -1;
            }
            return 0;
        }
    }

    public List<T> astar(T origem, T destino) {

        final Queue<NoData<T>> openQueue = new PriorityQueue<NoData<T>>(11, new NodeComparator());

        NoData<T> noOrigemData = graph.getNoData(origem);
        noOrigemData.setG(0);
        noOrigemData.calculaF(destino);
        openQueue.add(noOrigemData);

        final Map<T, T> caminho = new HashMap<T, T>();
        final Set<NoData<T>> listaFechada = new HashSet<NoData<T>>();

        while (!openQueue.isEmpty()) {
            final NoData<T> noData = openQueue.poll();
            System.out.println("No para expansao: " + noData.getNoId().toString());

            if (noData.getNoId().equals(destino)) {
                return caminho(caminho, destino);
            }

            listaFechada.add(noData);

            for (Entry<NoData<T>, Double> vizinhoInscricao : graph.fronteiraLista(noData.getNoId()).entrySet()) {
                NoData<T> vizinho = vizinhoInscricao.getKey();
                System.out.println("No explorado: " + vizinho.getNoId().toString());

                if (listaFechada.contains(vizinho)) {
                    System.out.println("No " + vizinho.getNoId().toString() + " ja visitado");
                    continue;
                }

                double distanciaEntreDoisNos = vizinhoInscricao.getValue();
                double tentativaG = distanciaEntreDoisNos + noData.getG();

                if (tentativaG < vizinho.getG()) {
                    vizinho.setG(tentativaG);
                    vizinho.calculaF(vizinho.getNoId());

                    caminho.put(vizinho.getNoId(), noData.getNoId());
                    if (!openQueue.contains(vizinho)) {
                        openQueue.add(vizinho);
                    }
                }
            }
        }

        return null;
    }

    private List<T> caminho(Map<T, T> caminho, T destino) {
        assert caminho != null;
        assert destino != null;

        final List<T> listaCaminho = new ArrayList<T>();
        listaCaminho.add(destino);
        while (caminho.containsKey(destino)) {
            destino = caminho.get(destino);
            listaCaminho.add(destino);
        }
        Collections.reverse(listaCaminho);
        return listaCaminho;
    }

}
