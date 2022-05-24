package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.Objects;

public class GraphWeight implements Cloneable{

    private String name;
    private float value;

    public GraphWeight(String name, float value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphWeight that = (GraphWeight) o;
        return Float.compare(that.value, value) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "GraphWeight{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return (GraphWeight)super.clone();
    }
}
