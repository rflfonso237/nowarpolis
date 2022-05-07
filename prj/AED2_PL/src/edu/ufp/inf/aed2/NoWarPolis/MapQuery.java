package edu.ufp.inf.aed2.NoWarPolis;

import edu.ufp.inf.aed2.NoWarPolis.Datatypes.MapSymbol;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.POI;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.Tag;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

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
        ArrayList<POI> ret = new ArrayList<POI>();

        for(POI o: this.md.getAllPOI()){
            Boolean add = true;
            for(User u: users){

                //1. If user does not exist
                if(
                    o.getVisitedUsers().containsKey(u) == false && visited == true ||
                    o.getVisitedUsers().containsKey(u) == true && visited == false
                ){
                    add = false;
                    break;
                }
                //2. in case he visited and he is part of the history
                if(o.getVisitedUsers().containsKey(u) == true && visited == true){
                    Boolean found = false;

                    for(Date d:  o.getVisitedUsers().get(u) ){
                        if(d.compareTo(init) >= 0 && d.compareTo(end) <= 0 ){
                            found = true;
                        }
                    }

                    if(found == false)
                        add = false;
                }
            }

            if(add == true)
                ret.add(o);
        }


        return ret;
    }

    public ArrayList<POI> find_User_visitedPOI(boolean visited, Date init, Date end, User user){
       ArrayList<User> tmp = new ArrayList<User>();
       tmp.add(user);
       return this.find_POI(visited,init,end,tmp);
    }

    public ArrayList<User> top_Users(int rankN, Date init, Date end){
        ArrayList<User> ret = new ArrayList<User>();
        for(User u: User.getAllUsersWithVisitsWithinRange(this.md.getAllUsers(), init, end)){

            if(rankN <= 0){
                return ret;
            }

            ret.add(u);

            rankN--;
        }
        return ret;
    }

    public ArrayList<POI> top_POI(int rankN, Date init, Date end){
        ArrayList<POI> ret = new ArrayList<POI>();
        for(POI p: POI.getAllPoiWithVisitsWithinRange(this.md.getAllPOI(), init, end)){

            if(rankN <= 0){
                return ret;
            }

            ret.add(p);

            rankN--;
        }
        return ret;
    }

    public HashMap<String, MapSymbol> find_whereisPOI(POI p){
        HashMap<String, MapSymbol> ret = new HashMap<String, MapSymbol>();

        for(String mapName: this.md.getAllMaps().keySet()){
            if(this.md.getAllMaps().get(mapName).containsKey(p.getTag()) == true){
                ret.put(mapName,p.getLocation());
            }
        }

        return ret;
    }
}
