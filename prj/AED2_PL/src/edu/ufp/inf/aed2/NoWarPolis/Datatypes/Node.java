package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.ArrayList;
import java.util.Objects;

public class Node extends MapSymbol{

    private ArrayList<Way> inOnlyWays;
    private ArrayList<Way> outOnlyWays;

    public Node(String name, Tag t){
        super(name,t);
        inOnlyWays = new ArrayList<Way>();
        outOnlyWays = new ArrayList<Way>();
    }

    public ArrayList<Way> getInOnlyWays() {
        return inOnlyWays;
    }

    public ArrayList<Way> getOutOnlyWays() {
        return outOnlyWays;
    }

    public void setInWay(Way t){
        if(this.inOnlyWays.contains(t) == false){
            this.inOnlyWays.add(t);
        }
    }

    public void setOutWay(Way t){
        if(this.outOnlyWays.contains(t) == false){
            this.outOnlyWays.add(t);
        }
    }

    public void setInOutWay(Way t){
        this.setInWay(t);
        this.setOutWay(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Node node = (Node) o;
        return Objects.equals(inOnlyWays, node.inOnlyWays) && Objects.equals(outOnlyWays, node.outOnlyWays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inOnlyWays, outOnlyWays);
    }

    @Override
    public String toString() {
        return "Node{" +
                "inOnlyWays=" + inOnlyWays +
                ", outOnlyWays=" + outOnlyWays +
                '}';
    }
}
