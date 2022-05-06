package edu.ufp.inf.aed2.NoWarPolis;

import edu.ufp.inf.aed2.NoWarPolis.Datatypes.MapSymbol;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.POI;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.User;

import java.util.ArrayList;
import java.util.Date;

public class MapQuery {

    private MapDatabase md;

    public MapQuery(String filepath){
        md = new MapDatabase();
        md.load(filepath);
    }

    public MapQuery(){
        md = new MapDatabase();
    }

    public ArrayList<POI> find_POI(boolean visited, Date init, Date end, ArrayList<User> users){
        return null;
    }

    public ArrayList<POI> find_User_visitedPOI(boolean visited, Date init, Date end, User user){
        return null;
    }

    public ArrayList<User> top_Users(int rankN, boolean visited, Date init, Date end){
        return null;
    }

    public ArrayList<POI> top_POI(int rankN, boolean visited, Date init, Date end){
        return null;
    }

    public ArrayList<MapSymbol> find_whereisPOI(POI p){
        return null;
    }
}
