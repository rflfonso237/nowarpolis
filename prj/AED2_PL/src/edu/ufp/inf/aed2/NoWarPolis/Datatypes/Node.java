package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.ArrayList;
import java.util.Objects;

public class Node extends MapSymbol{

    private ArrayList<Way> inOnlyWays;
    private ArrayList<Way> outOnlyWays;
    private ArrayList<Way> InOutWays;

    public Node(String name, Tag t){
        super(name,t);
        inOnlyWays = new ArrayList<Way>();
        outOnlyWays = new ArrayList<Way>();
        InOutWays = new ArrayList<Way>();
    }

    public ArrayList<Way> getInOnlyWays() {
        return inOnlyWays;
    }

    public ArrayList<Way> getOutOnlyWays() {
        return outOnlyWays;
    }

    public ArrayList<Way> getInOutWays() {
        return InOutWays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Node node = (Node) o;
        return Objects.equals(inOnlyWays, node.inOnlyWays) && Objects.equals(outOnlyWays, node.outOnlyWays) && Objects.equals(InOutWays, node.InOutWays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inOnlyWays, outOnlyWays, InOutWays);
    }

    @Override
    public String toString() {
        return "Node{" +
                "inOnlyWays=" + inOnlyWays +
                ", outOnlyWays=" + outOnlyWays +
                ", InOutWays=" + InOutWays +
                '}';
    }
}
