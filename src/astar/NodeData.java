/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Map;

/**
 *
 * @author Cauã
 */
final class NodeData<T> {

    private final T nodeId;
    private final Map<T, Double> heuristic;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 

    public NodeData(T nodeId, Map<T, Double> heuristic) {
        this.nodeId = nodeId;
        this.g = Double.MAX_VALUE;
        this.heuristic = heuristic;
    }

    public T getNodeId() {
        return nodeId;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void calcF(T destination) {
        this.h = heuristic.get(destination);
        //System.out.println("Heuristica: " + this.h + "\n" + heuristic.toString());
        this.f = g + h;
    }

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
}
