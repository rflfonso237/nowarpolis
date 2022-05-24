package edu.ufp.inf.aed2.NoWarPolis.Datatypes;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class POI extends MapSymbol{

    private String type;
    private HashMap<Timestamp, Log> logs;
    private ArrayList<Vehicle> supportedVehicles = new ArrayList<Vehicle>();
    private MapSymbol location;
    private HashMap<User, ArrayList<Timestamp>> visitedUsers;

    public POI(String name, Tag t, String type, MapSymbol location){
        super(name, t);
        this.type = type;
        this.logs = new HashMap<Timestamp, Log>();
        this.location = location;
        visitedUsers = new HashMap<User, ArrayList<Timestamp>>();
    }

    public POI(POI p, Date init, Date end){
        super(p.getName(), p.getTag());
        this.type = p.getType();
        this.logs = p.getLogs();
        this.location = p.getLocation();
        visitedUsers = new HashMap<User, ArrayList<Timestamp>>();

        for(User u: this.visitedUsers.keySet()){
            ArrayList<Timestamp> filtered = new ArrayList<Timestamp>();

            for(Timestamp t: this.visitedUsers.get(u)){
                Date d=new Date(t.getTime());

                if(d.compareTo(init) >= 0 && d.compareTo(end) <= 0){
                    filtered.add(t);
                }
            }

            if(filtered.size() > 0){
                visitedUsers.put(u,filtered);
            }
        }
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

    public HashMap<User, ArrayList<Timestamp>> getVisitedUsers() {
        return visitedUsers;
    }

    private int totalVisits(){
        int v = 0;
        for(ArrayList<Timestamp> t: visitedUsers.values()){
            v += t.size();
        }
        return v;
    }

    public static ArrayList<POI> getAllPoiWithVisitsWithinRange(ArrayList<POI> all, Date init, Date end){
        ArrayList<POI> ret = new ArrayList<POI>();

        for(POI k : all){
            POI p = new POI(k,init,end);
            if(p.getVisitedUsers().size() > 0){
                ret.add(p);
            }
        }

        Collections.sort(ret, sortUserBynVisits);

        return ret;
    }
    private static Comparator<POI> sortUserBynVisits = new Comparator<POI>() {
        @Override
        public int compare(POI o1, POI o2) {
            return o1.totalVisits() - o2.totalVisits();
        }
    };

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
