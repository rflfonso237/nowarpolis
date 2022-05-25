package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.ArrayList;
import java.util.Objects;


public class Way extends MapSymbol{

    private ArrayList<GraphWeight> weights;
    private Node nodeStart = null;
    private Node nodeEnd = null;
    private boolean oneway = false;

    public Way(){
        super(null,null);
    }

    public Way(String name, Tag t){
        super(name, t);
        this.weights = new ArrayList<GraphWeight>();
    }

    private Way(String name, Tag t, Node s, Node ed){
        super(name, t);
        this.weights = new ArrayList<GraphWeight>();
        this.nodeStart = s;
        this.nodeEnd = ed;
    }

    public ArrayList<GraphWeight> getWeights() {
        return weights;
    }

    public float getWeight() {
        float w = 0;

        for(GraphWeight g: this.getWeights()){
            w+=g.getValue();
        }

        return w;
    }

    public Node getNodeStart() {
        return nodeStart;
    }

    public void setNodeStart(Node nodeStart) {
        this.nodeStart = nodeStart;
    }

    public Node getNodeEnd() {
        return nodeEnd;
    }

    public void setNodeEnd(Node nodeEnd) {
        this.nodeEnd = nodeEnd;
    }

    public boolean isOneway() {
        return oneway;
    }

    public void setOneway(boolean oneway) {
        this.oneway = oneway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Way way = (Way) o;
        return oneway == way.oneway && Objects.equals(weights, way.weights) && Objects.equals(nodeStart, way.nodeStart) && Objects.equals(nodeEnd, way.nodeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weights, nodeStart, nodeEnd, oneway);
    }

    @Override
    public String toString() {
        return "Way{" +
                "weights=" + weights +
                ", nodeStart=" + nodeStart +
                ", nodeEnd=" + nodeEnd +
                ", oneway=" + oneway +
                '}';
    }
}
