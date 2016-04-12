package astar;

import java.util.Map;
final class NoData<T> {

    private final T nodeId;
    private final Map<T, Double> heuristica;

    private double g;  
    private double h; 
    private double f;

    public NoData(T nodeId, Map<T, Double> heuristica) {
        this.nodeId = nodeId;
        this.g = Double.MAX_VALUE;
        this.heuristica = heuristica;
    }

    public T getNoId() {
        return nodeId;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void calculaF(T destino) {
        this.h = heuristica.get(destino);   
        this.f = g + h;
        System.out.println("g(n): " + this.g);
        System.out.println("h(n): " + this.h);
        System.out.println("F(n): " + this.f);
    }

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
}
