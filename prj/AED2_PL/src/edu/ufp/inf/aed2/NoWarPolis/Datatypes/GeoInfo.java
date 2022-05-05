package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.awt.geom.Point2D;
import java.util.Objects;

public class GeoInfo extends Point2D {

    private String information = "coordinates";
    private String type = "coordinates";
    private double x = 0;
    private double y = 0;

    private GeoInfo(String information, String type){
        this.information = information;
        this.type =  type;
    }

    public GeoInfo(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String getInformation() {
        return information;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GeoInfo geoInfo = (GeoInfo) o;
        return java.lang.Double.compare(geoInfo.x, x) == 0 && java.lang.Double.compare(geoInfo.y, y) == 0 && Objects.equals(information, geoInfo.information) && Objects.equals(type, geoInfo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), information, type, x, y);
    }

    @Override
    public String toString() {
        return "GeoInfo{" +
                "information='" + information + '\'' +
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

