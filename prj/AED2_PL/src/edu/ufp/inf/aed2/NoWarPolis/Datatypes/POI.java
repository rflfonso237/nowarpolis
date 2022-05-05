package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class POI extends MapSymbol{

    private String type;
    private HashMap<Timestamp, Log> logs;
    private ArrayList<Vehicle> supportedVehicles = null;
    private MapSymbol location;
    private HashMap<String, User> visitedUsers;

    public POI(String name, Tag t, String type, MapSymbol location){
        super(name, t);
        this.type = type;
        this.logs = new HashMap<Timestamp, Log>();
        this.location = location;
        visitedUsers = new HashMap<String, User>();
    }

    public String getType() {
        return type;
    }

    public HashMap<Timestamp, Log> getLogs() {
        return logs;
    }

    public ArrayList<Vehicle> getSupportedVehicles() {
        return supportedVehicles;
    }

    public MapSymbol getLocation() {
        return location;
    }

    public HashMap<String, User> getVisitedUsers() {
        return visitedUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        POI poi = (POI) o;
        return Objects.equals(type, poi.type) && Objects.equals(logs, poi.logs) && Objects.equals(supportedVehicles, poi.supportedVehicles) && Objects.equals(location, poi.location) && Objects.equals(visitedUsers, poi.visitedUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, logs, supportedVehicles, location, visitedUsers);
    }

    @Override
    public String toString() {
        return "POI{" +
                "type='" + type + '\'' +
                ", logs=" + logs +
                ", supportedVehicles=" + supportedVehicles +
                ", location=" + location +
                ", visitedUsers=" + visitedUsers +
                '}';
    }
}
