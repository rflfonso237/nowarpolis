package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Objects;

public class Tag {

    private long id;
    private GeoInfo localization;
    private ArrayList<GeoInfo> geoinfo;

    public Tag(long id, GeoInfo localization, ArrayList<GeoInfo> geoinfo){
        this.id = id;
        this.localization = localization;
        this.geoinfo = geoinfo;
    }

    public Tag(long id){
        this.id = id;
        this.localization = new GeoInfo(0.0,0.0);
        this.geoinfo = new ArrayList<GeoInfo>();
    }

    public long getId() {
        return id;
    }

    public Point2D getLocalization() {
        return localization;
    }

    public ArrayList<GeoInfo> getGeoinfo() {
        return geoinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id && Objects.equals(localization, tag.localization) && Objects.equals(geoinfo, tag.geoinfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localization, geoinfo);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", localization=" + localization +
                ", geoinfo=" + geoinfo +
                '}';
    }
}

