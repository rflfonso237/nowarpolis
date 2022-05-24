package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Node extends MapSymbol{

    private ArrayList<Way> inWays;
    private ArrayList<Way> outOnlyWays;

    public Node(String name, Tag t){
        super(name,t);
        inWays = new ArrayList<Way>();
        outOnlyWays = new ArrayList<Way>();
    }

    public Node(){
        super("",null);
    }

    public ArrayList<Way> getInOnlyWays() {
        ArrayList<Way> ret = new ArrayList<Way>();
        for(Way w : this.inWays){
            if(this.outOnlyWays.contains(w) == false){
                ret.add(w);
            }
        }
        return ret;
    }

    public ArrayList<Way> getOutOnlyWays() {
        ArrayList<Way> ret = new ArrayList<Way>();
        for(Way w : this.outOnlyWays){
            if(this.inWays.contains(w) == false){
                ret.add(w);
            }
        }
        return ret;
    }

    public ArrayList<Way> getInOutWays(){
        ArrayList<Way> ret = new ArrayList<Way>();
        for(Way w : this.inWays){
            if(this.outOnlyWays.contains(w) == true){
                ret.add(w);
            }
        }
        return ret;
    }

    public void setInWay(Way t){
        if(this.inWays.contains(t) == false){
            this.inWays.add(t);
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
        return Objects.equals(inWays, node.inWays) && Objects.equals(outOnlyWays, node.outOnlyWays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inWays, outOnlyWays);
    }

    @Override
    public String toString() {
        return "Node{" +
                "inOnlyWays=" + inWays +
                ", outOnlyWays=" + outOnlyWays +
                '}';
    }
}
