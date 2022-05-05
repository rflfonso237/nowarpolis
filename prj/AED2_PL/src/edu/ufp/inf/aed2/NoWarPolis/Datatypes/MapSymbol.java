package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.util.Objects;

public abstract class MapSymbol {

    private String name;
    private Tag tag;


    public MapSymbol(String name, Tag tag){
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapSymbol mapSymbol = (MapSymbol) o;
        return Objects.equals(name, mapSymbol.name) && Objects.equals(tag, mapSymbol.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tag);
    }

    @Override
    public String toString() {
        return "MapSymbol{" +
                "name='" + name + '\'' +
                ", tag=" + tag +
                '}';
    }
}
